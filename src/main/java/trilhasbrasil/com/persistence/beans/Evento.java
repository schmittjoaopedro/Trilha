package trilhasbrasil.com.persistence.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	public String nome;
	
	public Date date;
	
	public String descricao;
	
	public Double custo;
	
	@OneToMany(targetEntity = Imagens.class)
	public List<Imagens> imagems;
	
	@ManyToOne
	private Trilha trilha;
	
	@ManyToOne
	private GrupoDeTrilheiros grupoDeTrilheiros;
	
	public Evento() {}

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
