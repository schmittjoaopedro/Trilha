package trilhasbrasil.com.xml.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import trilhasbrasil.com.persistencia.beans.Evento;
import trilhasbrasil.com.persistencia.beans.Imagens;
import trilhasbrasil.com.persistencia.beans.Trilha;
import trilhasbrasil.com.persistencia.beans.Trilheiro;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GrupoDeTrilheirosXmlType implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private String login;
	
	private String senha;
	
	private List<Imagens> images = new ArrayList<Imagens>();
	
	private String cidade;
	
	private String estado;
	
	private List<Trilheiro> trilheiros = new ArrayList<Trilheiro>();
	
	private List<Trilha> trilhas = new ArrayList<Trilha>();
	
	private List<Evento> eventos = new ArrayList<Evento>();
	
	public GrupoDeTrilheirosXmlType() {}

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

	public List<Imagens> getImagens() {
		return images;
	}

	public void setImagens(List<Imagens> imagesIds) {
		this.images = imagesIds;
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

	public List<Trilheiro> getTrilheiros() {
		return trilheiros;
	}

	public void setTrilheiros(List<Trilheiro> trilheirosId) {
		this.trilheiros = trilheirosId;
	}

	public List<Trilha> getTrilhas() {
		return trilhas;
	}

	public void setTrilhas(List<Trilha> trilhasId) {
		this.trilhas = trilhasId;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventosId) {
		this.eventos = eventosId;
	}
	
}
