package de.moegn.blueboxgames.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Account extends AbstractIdEntity {
	@Column(unique = true)
	private String name;
	@Column
	private String password;

	@OneToMany(mappedBy = "account")
	private List<Role> roles;

	public Account() {
		super();
	}

	public Account(String name, String password) {
		this.name = name;
		setPassword(password);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] bytes = md.digest(password.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}

			this.password = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}