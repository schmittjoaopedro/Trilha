package trilhasbrasil.com.persistencia.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "Evento.procurarProximosEventosEntre", query = "SELECT e FROM Evento e WHERE e.date > :initdate AND e.date < :enddate ORDER BY e.date ASC"),
	@NamedQuery(name = "Evento.procurarProximosEventosAPartirDe", query = "SELECT e FROM Evento e WHERE e.date > :initdate ORDER BY e.date ASC"),
	@NamedQuery(name = "Evento.procurarProximosEventosPorDono", query = "SELECT e FROM Evento e WHERE e.date > :initdate AND e.grupoDeTrilheiros.id = :grupoId ORDER BY e.date ASC")
})
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	        
	private Date date;
	
	private String descricao;
	
	private Double custo;
	
	@OneToMany(targetEntity = Imagens.class, cascade = CascadeType.ALL)
	private List<Imagens> imagems;
	
	@ManyToOne
	private Trilha trilha;
	
	@ManyToOne
	private GrupoDeTrilheiros grupoDeTrilheiros;
	
	public Evento() {}
	
	public Evento(Long id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}

	public List<Imagens> getImagems() {
		if(this.imagems == null) this.imagems = new ArrayList<Imagens>();
		return imagems;
	}

	public void setImagems(List<Imagens> imagems) {
		this.imagems = imagems;
	}

	public Trilha getTrilha() {
		return trilha;
	}

	public void setTrilha(Trilha trilha) {
		this.trilha = trilha;
	}

	public GrupoDeTrilheiros getGrupoDeTrilheiros() {
		return grupoDeTrilheiros;
	}

	public void setGrupoDeTrilheiros(GrupoDeTrilheiros grupoDeTrilheiros) {
		this.grupoDeTrilheiros = grupoDeTrilheiros;
	}
	
}
