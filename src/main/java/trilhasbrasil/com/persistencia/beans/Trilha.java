package trilhasbrasil.com.persistencia.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
	@NamedQuery(name = "Trilha.procurarTrilhasPorEstado", query = "SELECT t FROM Trilha t JOIN t.grupoDeTrilheiros gp WHERE gp.estado LIKE :nomeDoEstado"),
	@NamedQuery(name = "Trilha.procurarTrilhasPorGrupoDeTrilheiros", query = "SELECT T FROM Trilha T JOIN T.grupoDeTrilheiros GP WHERE GP.nome LIKE :nomeDoGrupo")
})
public class Trilha implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@OneToMany(targetEntity = Imagens.class)
	private List<Imagens> imagens;
	
	private String cidade;
	
	private String estado;
	
	@ManyToMany
	private List<GrupoDeTrilheiros> grupoDeTrilheiros;
	
	@OneToMany(mappedBy = "trilha")
	private List<Evento> eventos;
	
	@OneToMany(mappedBy = "trilha", cascade = CascadeType.ALL)
	private List<LocalizacaoGeografica> localizacaoGeograficas;
	
	public Trilha() {}
	
	public Trilha(Long id) {
		this.setId(id);
	}

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

	public List<Imagens> getImagens() {
		if(this.imagens == null) this.imagens = new ArrayList<Imagens>();
		return imagens;
	}

	public void setImagens(List<Imagens> imagens) {
		this.imagens = imagens;
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

	public List<GrupoDeTrilheiros> getGrupoDeTrilheiros() {
		if(this.grupoDeTrilheiros == null) this.grupoDeTrilheiros = new ArrayList<GrupoDeTrilheiros>();
		return grupoDeTrilheiros;
	}

	public void setGrupoDeTrilheiros(List<GrupoDeTrilheiros> grupoDeTrilheiros) {
		this.grupoDeTrilheiros = grupoDeTrilheiros;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<LocalizacaoGeografica> getLocalizacaoGeograficas() {
		if(this.localizacaoGeograficas == null) this.localizacaoGeograficas = new ArrayList<LocalizacaoGeografica>();
		return localizacaoGeograficas;
	}

	public void setLocalizacaoGeograficas(
			List<LocalizacaoGeografica> localizacaoGeograficas) {
		this.localizacaoGeograficas = localizacaoGeograficas;
	}
	
}
