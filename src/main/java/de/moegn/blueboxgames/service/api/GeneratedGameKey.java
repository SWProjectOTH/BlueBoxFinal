package de.moegn.blueboxgames.service.api;

import java.io.Serializable;

public class GeneratedGameKey implements Serializable {
	private static final long serialVersionUID = 1030295278632420004L;

	private long id;
	private long gameId;
	private String gameKey;

	public GeneratedGameKey() {

	}

	public GeneratedGameKey(long id, long gameId, String gameKey) {
		this.id = id;
		this.gameId = gameId;
		this.gameKey = gameKey;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGameId() {
		return gameId;
	}

	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	public String getGameKey() {
		return gameKey;
	}

	public void setGameKey(String gameKey) {
		this.gameKey = gameKey;
	}
}