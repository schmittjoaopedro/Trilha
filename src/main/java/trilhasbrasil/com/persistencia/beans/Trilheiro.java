package trilhasbrasil.com.persistencia.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Trilheiro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	@OneToMany(targetEntity = Imagens.class)
	private List<Imagens> imagens;
	
	@ManyToOne
	private GrupoDeTrilheiros grupoDeTrilheiros;
	
	public Trilheiro() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Imagens> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagens> imagens) {
		this.imagens = imagens;
	}

	public GrupoDeTrilheiros getGrupoDeTrilheiros() {
		return grupoDeTrilheiros;
	}

	public void setGrupoDeTrilheiros(GrupoDeTrilheiros grupoDeTrilheiros) {
		this.grupoDeTrilheiros = grupoDeTrilheiros;
	}
	
}
