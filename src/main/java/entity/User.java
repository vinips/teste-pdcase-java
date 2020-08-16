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
import javax.persistence.UniqueConstraint;

/**
 * @author Vinícius Pedro da Silveira
 */

@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))//The Word "USER" is a Reserved word on postgreSQL, so i had to use in plural.
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
	private String password;

	@Column(name = "IS_ENABLED")
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

	
	
//	public static User getUser(UserRest userRest) {		
//		if (userRest == null) {
//			return null;
//		}
//		
//		 id (int)
//		 * username (String)
//		 * password (String)
//		 * is_enabled (boolean)
//		 * register_date (Date)
//		 * name (String)
//		 * surname (String)
//		 * email (String)
//		 * phone (String)
//
//		
//		
//		User user = new User();
//		user.setUsername(userRest.);
//	   if(profissionalRest == null) return null;
//	   
//	   Pessoa pessoa = new Pessoa();
//	   pessoa.setNome(StringUtil.isNotEmpty(profissionalRest.getNome())?profissionalRest.getNome().toUpperCase() : null);
//		
//		if (profissionalRest.getContatos().length > 0)
//		{
//			pessoa.setTelefones(new ArrayList<Telefone>());
//			for (ContatoRest contato : profissionalRest.getContatos()) {
//				Telefone telefone = new Telefone();
//				if (StringUtil.isNotEmpty(contato.getId())) {
//					telefone.setId(Long.parseLong(contato.getId()));
//				}
//				if (StringUtil.isNotEmpty(contato.getIndex())) {
//				    telefone.setIndex(Integer.parseInt(contato.getIndex()));
//				}
//				if (StringUtil.isNotEmpty(contato.getTipo())) {
//				    telefone.setTipo(Integer.parseInt(contato.getTipo()));
//				}
//				telefone.setNumero(contato.getTelefone());
//				telefone.setDescricao(contato.getContato());
//				pessoa.getTelefones().add(telefone);
//			}
//		}
//		
//		PessoaFisica pessoaFisica = new PessoaFisica();
//		pessoaFisica.setPessoa(pessoa);
//		pessoaFisica.setCpf(profissionalRest.getCpf());
//		pessoaFisica.setEmail(profissionalRest.getEmail());
//	
//		Profissional profissional = new Profissional();
//		profissional.setPessoaFisica(pessoaFisica);
//		profissional.setJuiz(profissionalRest.getJuiz());
//		if (StringUtil.isNotEmpty(profissionalRest.getStatus()) && profissionalRest.getStatus().toLowerCase().equals("ativo")) {
//			profissional.setStatus(true);
//		} else {
//			profissional.setStatus(false);
//		}
//		
//		if (profissionalRest.getTipo_registro() != null && StringUtil.isNotEmpty(profissionalRest.getTipo_registro().getId())) {
//			profissional.setTipoRegistro(new TipoRegistro(Long.parseLong(profissionalRest.getTipo_registro().getId())));
//			profissional.setNumeroRegistro(profissionalRest.getNumero_registro());
//		}
//		
//		if (profissionalRest.getEspecialidades() != null && profissionalRest.getEspecialidades().length > 0) {
//			profissional.setEspecialidades(new ArrayList<Especialidade>());
//			
//			for (DescricaoRest e : profissionalRest.getEspecialidades()) {
//				Especialidade especialidade = new Especialidade();
//				if (StringUtil.isNotEmpty(e.getId())) {
//					especialidade.setId(Long.parseLong(e.getId()));
//				}
//				if (StringUtil.isNotEmpty(e.getDescricao())) {
//					especialidade.setDescricao(e.getDescricao());
//				}
//				profissional.getEspecialidades().add(especialidade);
//			}
//		}
//		if (profissionalRest.getUf() != null) {
//			profissional.setUf(profissionalRest.getUf());
//		}
//		
//		if (profissionalRest.getEndereco() != null && profissionalRest.getEndereco().getLogradouro() != null) {
//			Endereco endereco = new Endereco();
//			
//			if (profissionalRest.getEndereco() != null && StringUtil.isNotEmpty(profissionalRest.getEndereco().getId())) endereco.setId(Long.parseLong(profissionalRest.getEndereco().getId()));
//						
//			endereco.setId_logradouro(profissionalRest.getEndereco() != null && StringUtil.isNotEmpty(profissionalRest.getEndereco().getLogradouro().getId())? Integer.valueOf(profissionalRest.getEndereco().getLogradouro().getId()) : null);
//			endereco.setComplemento(profissionalRest.getEndereco().getComplemento());
//			endereco.setLogradouro(profissionalRest.getEndereco().getNome_logradouro());
//			endereco.setId_zona(StringUtil.isNotEmpty(profissionalRest.getEndereco().getZona())? Integer.parseInt(profissionalRest.getEndereco().getZona()): null);
//			endereco.setNumero(profissionalRest.getEndereco().getNumero());
//			endereco.setReferencia(profissionalRest.getEndereco().getReferencia());
//			endereco.setTipo(StringUtil.isNotEmpty(profissionalRest.getEndereco().getTipo())? Integer.parseInt(profissionalRest.getEndereco().getTipo()): null);
//						
//			List<Endereco> enderecos = new ArrayList<Endereco>();
//			enderecos.add(endereco);
//			profissional.getPessoaFisica().getPessoa().setEnderecos(enderecos);
//		}
//
//		if (StringUtil.isNotEmpty(profissionalRest.getId()))
//		{
//			profissional.setId(Long.parseLong(profissionalRest.getId()));
//		}
//		return profissional;
//	}

	
}
