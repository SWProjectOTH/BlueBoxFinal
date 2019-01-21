package de.moegn.blueboxgames.service;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.moegn.blueboxgames.model.Account;
import de.moegn.blueboxgames.model.Game;
import de.moegn.blueboxgames.model.GameKey;

@RequestScoped
@WebService
public class GameService {
	private static final String GAME_NAME = Game.class.getSimpleName();
	private static final String GAME_KEY_NAME = GameKey.class.getSimpleName();

	@PersistenceContext(unitName = "blueBoxPu")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional
	public Game getGame(String name) {
		List<Game> games = entityManager.createQuery("SELECT a FROM " + GAME_NAME + " a WHERE a.name = :name")
				.setParameter("name", name).getResultList();

		return games.isEmpty() ? null : games.get(0);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Game> getAllGames() {
		return entityManager.createQuery("SELECT g FROM " + GAME_NAME + " g").getResultList();
	}

	@Transactional
	public GameKey generateGameKey(Game game, Account account, long transactionId) {
		GameKey key = new GameKey(transactionId, game, account);
		entityManager.persist(key);
		return key;
	}
}