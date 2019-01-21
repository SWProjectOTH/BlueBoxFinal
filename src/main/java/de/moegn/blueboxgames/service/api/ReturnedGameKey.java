package de.moegn.blueboxgames.service.api;

import java.io.Serializable;

public class ReturnedGameKey implements Serializable {
	private static final long serialVersionUID = -727830818300511094L;

	private long transactionId;

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
}