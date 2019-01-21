package de.moegn.blueboxgames.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import de.moegn.blueboxgames.model.Account;

@RequestScoped
@WebService
public class UserManagementService {

	@PersistenceContext(unitName = "blueBoxPu")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public Account getAccount(String name) {

		List<Account> accounts = entityManager.createQuery("SELECT a FROM Account a WHERE a.name = :name")
				.setParameter("name", name).getResultList();

		return accounts.isEmpty() ? null : accounts.get(0);
	}

	@Transactional
	public List<Account> getAllAccounts() {
		return null;
	}

	public boolean logIn(String userName, String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			Account a = getAccount(userName);
			if (a == null) {
				return false;
			}
			return a.getPassword().equals(sb.toString());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean createAccount(String name, String password) {
		if (getAccount(name) != null) {
			return false;
		}

		Account acc = new Account(name, password);
		entityManager.persist(acc);
		return true;
	}
}