package de.moegn.blueboxgames.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.moegn.blueboxgames.model.Account;
import de.moegn.blueboxgames.service.api.*;

@RequestScoped
@WebService
public class KeyService implements IKeyAPI {

	@PersistenceContext(unitName = "blueBoxPu")
	private EntityManager entityManager;

	@Inject
	private UserManagementService usermanagementService;

	@Override
	public GeneratedGameKey generateKey(KeyGenerationRequest request) throws KeyGenerationException {
		String customer = request.getCustomer();
		String password = request.getPassword();
		Account acc = usermanagementService.getAccount(customer);
		if (!acc.getPassword().equals(new Account("", password).getPassword())) {
			throw new KeyGenerationException("The Account does not exist or Account/Password do not match");
		}

		GeneratedGameKey key = new GeneratedGameKey();

		return key;
	}

	@Override
	public ReturnedGameKey returnKey(KeyReturnRequest request) throws KeyReturnException {
		String customer = request.getCustomer();

		ReturnedGameKey returnedGameKey = new ReturnedGameKey();
		returnedGameKey.setTransactionId(1234l);

		return returnedGameKey;
	}
}