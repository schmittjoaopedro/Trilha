package trilhasbrasil.com.persistencia.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoDeTrilheiros.findAll", query = "SELECT gt FROM GrupoDeTrilheiros gt WHERE gt.nome LIKE :nome"),
	@NamedQuery(name = "GrupoDeTrilheiros.procurarPorLoginESenha", query = "SELECT gt FROM GrupoDeTrilheiros gt WHERE gt.login = :login AND gt.senha = :senha")
})
public class GrupoDeTrilheiros implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String login;
	
	private String senha;
	
	private AccessRoles accessRoles;
	
	@OneToMany(targetEntity = Imagens.class)
	private List<Imagens> imagens;
	
	private String cidade;
	
	private String estado;
	
	@OneToMany(mappedBy = "grupoDeTrilheiros")
	private List<Trilheiro> trilheiros;
	
	@ManyToMany
	private List<Trilha> trilhas;
	
	@OneToMany(mappedBy = "grupoDeTrilheiros")
	private List<Evento> eventos;
	
	public GrupoDeTrilheiros() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Imagens> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagens> imagens) {
		this.imagens = imagens;
	}

	public List<Trilheiro> getTrilheiros() {
		return trilheiros;
	}

	public void setTrilheiros(List<Trilheiro> trilheiros) {
		this.trilheiros = trilheiros;
	}

	public List<Trilha> getTrilhas() {
		return trilhas;
	}

	public void setTrilhas(List<Trilha> trilhas) {
		this.trilhas = trilhas;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public AccessRoles getAccessRoles() {
		return accessRoles;
	}

	public void setAccessRoles(AccessRoles accessRoles) {
		this.accessRoles = accessRoles;
	}
	
}
