package de.moegn.blueboxgames.service.api;

import java.io.Serializable;

public class KeyReturnRequest implements Serializable {
	private static final long serialVersionUID = 3982677205511229313L;

	private String customer;
	private String password;
	private String key;

	public KeyReturnRequest() {

	}

	public KeyReturnRequest(String customer, String password, String key) {
		this.customer = customer;
		this.password = password;
		this.key = key;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}