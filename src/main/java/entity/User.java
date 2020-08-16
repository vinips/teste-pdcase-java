package entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author Vinícius Pedro da Silveira
 */

@Entity
@Table(name = "USERS")//The Word "USER" is a Reserved word on postgreSQL, so i had to use in plural.
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private byte[] password;

	@Column(name = "STATUS")
	private Boolean status;

	@Column(name = "REGISTER_DATE")
	private LocalDate registerDate;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "BY_KEY")
	private byte[] by_key;

	@Column(name = "BY_IV")
	private byte[] by_iv;

	@Transient
	private String stPassword;

	@Transient
	private String stRepeatedPassword;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
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

	public byte[] getBy_key() {
		return by_key;
	}

	public void setBy_key(byte[] by_key) {
		this.by_key = by_key;
	}

	public byte[] getBy_iv() {
		return by_iv;
	}

	public void setBy_iv(byte[] by_iv) {
		this.by_iv = by_iv;
	}

	public String getStPassword() {
		return stPassword;
	}

	public void setStPassword(String stPassword) {
		this.stPassword = stPassword;
	}

	public String getStRepeatedPassword() {
		return stRepeatedPassword;
	}

	public void setStRepeatedPassword(String stRepeatedPassword) {
		this.stRepeatedPassword = stRepeatedPassword;
	}

	
}
