package de.moegn.blueboxgames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Game extends AbstractIdEntity {
	@Column
	private String name;
	@Column
	private String desc;
	@OneToMany(mappedBy = "game")
	private List<GameKey> gameKeys = new ArrayList<>();
	@OneToMany(mappedBy = "game")
	private List<GameVersion> versions = new ArrayList<>();

	public Game() {
		super();
	}

	public Game(long id, String name, String desc) {
		super(id);
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<GameKey> getGameKeys() {
		return gameKeys;
	}

	public void setGameKeys(List<GameKey> gameKeys) {
		this.gameKeys = gameKeys;
	}

	public List<GameVersion> getVersions() {
		return versions;
	}

	public void setVersions(List<GameVersion> versions) {
		this.versions = versions;
	}
}