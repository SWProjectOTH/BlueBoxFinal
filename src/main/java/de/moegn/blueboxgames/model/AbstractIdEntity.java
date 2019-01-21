package de.moegn.blueboxgames.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public abstract class AbstractIdEntity {
	@Id
	@GeneratedValue
	private long id;

	public AbstractIdEntity(long id) {
		this.id = id;
	}

	public AbstractIdEntity() {

	}

	public final void setId(long id) {
		this.id = id;
	}

	public final long getId() {
		return id;
	}

	public final boolean isPersistent() {
		return id > 0;
	}
}