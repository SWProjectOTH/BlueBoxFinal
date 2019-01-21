package de.moegn.blueboxgames.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GameKey extends AbstractIdEntity {
	@Column
	private long transactionId;
	@ManyToOne
	private Game game;
	@ManyToOne
	private Account account;
	@Column
	private Date date;

	public GameKey() {
		super();
	}

	public GameKey(long transactionId, Game game, Account account) {
		super();
		this.transactionId = transactionId;
		this.game = game;
		this.account = account;
		date = new Date();
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getKey() {
		return getId() + "";
	}
}