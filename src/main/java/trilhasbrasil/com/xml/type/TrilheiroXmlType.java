package trilhasbrasil.com.xml.type;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrilheiroXmlType {
	
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private List<ImagemXmlType> imagems;
	
	private GrupoDeTrilheirosXmlType grupoDeTrilheiros;
	
	public TrilheiroXmlType() {}

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

	public List<ImagemXmlType> getImagemXmlTypes() {
		if(this.imagems == null) this.imagems = new ArrayList<ImagemXmlType>();
		return imagems;
	}

	public void setImagemXmlTypes(List<ImagemXmlType> imagemXmlTypes) {
		this.imagems = imagemXmlTypes;
	}

	public GrupoDeTrilheirosXmlType getGrupoDeTrilheirosXmlType() {
		return grupoDeTrilheiros;
	}

	public void setGrupoDeTrilheirosXmlType(
			GrupoDeTrilheirosXmlType grupoDeTrilheirosXmlType) {
		this.grupoDeTrilheiros = grupoDeTrilheirosXmlType;
	}
	
}
