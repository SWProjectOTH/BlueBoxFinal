package de.moegn.blueboxgames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class GameVersion extends AbstractIdEntity {
	@ManyToOne
	private Game game;
	@Column
	private byte[] fileData;
	@Column
	private String version;
	@Column
	private String updateNews;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getUpdateNews() {
		return updateNews;
	}

	public void setUpdateNews(String updateNews) {
		this.updateNews = updateNews;
	}
}