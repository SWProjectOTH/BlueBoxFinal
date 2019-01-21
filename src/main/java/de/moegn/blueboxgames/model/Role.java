package de.moegn.blueboxgames.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Entity
public class Role extends AbstractIdEntity {

	@Enumerated(EnumType.STRING)
	private RoleType roleType;
	@ManyToOne
	private Account account;

	public Role() {

	}

	public Role(RoleType roleType, Account account) {
		this.roleType = roleType;
		this.account = account;
	}

	public RoleType getRoleType() {
		return roleType;
	}

	public void setRoleType(RoleType roleType) {
		this.roleType = roleType;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}