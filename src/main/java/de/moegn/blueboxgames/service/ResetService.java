package de.moegn.blueboxgames.service;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.moegn.blueboxgames.model.Account;
import de.moegn.blueboxgames.model.Game;

@ApplicationScoped
public class ResetService {
	@Inject
	private InitService initService;
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void resetAll() {
		File file = new File(initService.getBaseDir());
		if(!file.exists()) {
			file.delete();
		}

		em.createQuery("DELETE FROM " + Game.class.getSimpleName());
		em.createQuery("DELETE FROM " + Account.class.getSimpleName());
		em.createQuery("DELETE FROM " + Game.class.getSimpleName());
		em.createQuery("DELETE FROM " + Game.class.getSimpleName());
		em.createQuery("DELETE FROM " + Game.class.getSimpleName());
		em.flush();
	}
}