package trilhasbrasil.com.xml.type;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class EventoXmlType implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private Date data;
	
	private String descricao;
	
	private Double custo;
	
	private List<ImagemXmlType> imagems;
	
	private GrupoDeTrilheirosXmlType grupoDeTrilheiros;
	
	public EventoXmlType() { }

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
		return data;
	}

	public void setDate(Date date) {
		this.data = date;
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

	public List<ImagemXmlType> getImagems() {
		return imagems;
	}

	public void setImagems(List<ImagemXmlType> imagems) {
		this.imagems = imagems;
	}

	public GrupoDeTrilheirosXmlType getGrupoDeTrilheiros() {
		return this.grupoDeTrilheiros;
	}

	public void setGrupoDeTrilheiros(GrupoDeTrilheirosXmlType grupoDeTrilheiros) {
		this.grupoDeTrilheiros = grupoDeTrilheiros;
	}
	
}
