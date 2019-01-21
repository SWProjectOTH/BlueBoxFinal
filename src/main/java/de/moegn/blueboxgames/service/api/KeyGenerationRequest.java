package de.moegn.blueboxgames.service.api;

import java.io.Serializable;

public class KeyGenerationRequest implements Serializable {
	private static final long serialVersionUID = 7084197593638071568L;

	private String customer;
	private String password;
	private String transactionId;
	private String gameId;

	public KeyGenerationRequest() {

	}

	public KeyGenerationRequest(String customer, String password, String transactionId, String gameId) {
		this.customer = customer;
		this.password = password;
		this.transactionId = transactionId;
		this.gameId = gameId;
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

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}
}
