package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Vinicius Pedro da Silveira
 */

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private String username;

	private String password;

	private Boolean status;

	private Date register_date;

	private String name;

	private String surname;

	private String email;

	private String phone;

	public String getId() {
		return id;
	}
	
	public void setId(Object id) {
		this.id = id != null ? id.toString() : null;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Date getRegister_date() {
		return register_date;
	}

	public void setRegister_date(Date register_date) {
		this.register_date = register_date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	
}
