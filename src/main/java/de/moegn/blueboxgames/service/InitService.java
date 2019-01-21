package de.moegn.blueboxgames.service;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.moegn.blueboxgames.model.Account;
import de.moegn.blueboxgames.model.Game;
import de.moegn.blueboxgames.model.Role;
import de.moegn.blueboxgames.model.RoleType;

@ApplicationScoped
public class InitService {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void init() {
		File file = new File(getBaseDir());
		if (!file.exists()) {
			file.mkdir();

			file = new File(getGamesDir());
			file.mkdir();
			file = new File(getAccountsDir());
			file.mkdir();
		}

		Game game = em.find(Game.class, 1l);
		if (game == null) {
			game = new Game(0, "Generic Jump and run", "Test Desc");
			em.persist(game);
			game = new Game(0, "Test Game", "hello");
			em.persist(game);
			game = new Game(0, "Yolo Game", "Lololol");
			em.persist(game);

			em.flush();
		}

		Account account = em.find(Account.class, 1l);
		if (account == null) {
			account = new Account("Admin", "123");
			em.persist(account);
			Role role = new Role(RoleType.ADMIN, account);
			em.persist(role);

			account = new Account("Bob", "123");
			em.persist(account);
			role = new Role(RoleType.CUSTOMER, account);
			em.persist(role);

			em.flush();
		}
	}

	public String getBaseDir() {
		return "blueboxgames/";
	}

	public String getGamesDir() {
		return getBaseDir() + "games/";
	}

	public String getGameDir(Game game) {
		return getGamesDir() + game.getId() + "/";
	}

	public String getAccountsDir() {
		return getBaseDir() + "accounts/";
	}
}