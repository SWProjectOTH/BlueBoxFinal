package de.moegn.blueboxgames.service;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import de.moegn.blueboxgames.model.Account;
import de.moegn.blueboxgames.model.RoleType;

@SessionScoped
public class SessionManager implements Serializable {
	private static final long serialVersionUID = -4104411752391925348L;

	private Account currentAccount;

	public Account getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

	public boolean allowed(RoleType roleType) {
		return currentAccount.getRoles().stream().anyMatch(e -> e.getRoleType() == roleType);
	}

	public boolean isLogin() {
		return currentAccount != null;
	}
}