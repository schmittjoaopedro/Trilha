package trilhasbrasil.com.xml.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import trilhasbrasil.com.persistencia.beans.Imagens;

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
	
	private List<TrilheiroXmlType> trilheiros = new ArrayList<TrilheiroXmlType>();
	
	private List<TrilhaXmlType> trilhas = new ArrayList<TrilhaXmlType>();
	
	private List<EventoXmlType> eventos = new ArrayList<EventoXmlType>();
	
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

	public List<TrilheiroXmlType> getTrilheiros() {
		return trilheiros;
	}

	public void setTrilheiros(List<TrilheiroXmlType> trilheirosId) {
		this.trilheiros = trilheirosId;
	}

	public List<TrilhaXmlType> getTrilhas() {
		if(this.trilhas == null) this.trilhas = new ArrayList<TrilhaXmlType>();
		return trilhas;
	}

	public void setTrilhas(List<TrilhaXmlType> trilhasId) {
		this.trilhas = trilhasId;
	}

	public List<EventoXmlType> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoXmlType> eventosId) {
		this.eventos = eventosId;
	}
	
}
