package rest.object;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author  Vinicius Pedro da Silveira
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRest {
	
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("username")
    private String username;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("status")
	private String status;

    @JsonProperty("register_date")
    private Date register_date;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("surname")
    private String surname;
    
    
    @JsonProperty("email")
    private String email;
    
	@JsonProperty("phone")
	private Boolean phone;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
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

	public Boolean getPhone() {
		return phone;
	}

	public void setPhone(Boolean phone) {
		this.phone = phone;
	}
	
	
}
