package trilhasbrasil.com.xml.type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TrilhaXmlType implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;
	
	private List<ImagemXmlType> imagens;
	
	private String cidade;
	
	private String estado;
	
	private List<LocalizacaoGeograficaXmlType> localizacaoGeograficas;
	
	private GrupoDeTrilheirosXmlType grupoDeTrilheirosXmlType;
	
	public TrilhaXmlType() {}

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

	public List<ImagemXmlType> getImagens() {
		if(this.imagens == null) this.imagens = new ArrayList<ImagemXmlType>();
		return imagens;
	}

	public void setImagens(List<ImagemXmlType> imagens) {
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

	public List<LocalizacaoGeograficaXmlType> getLocalizacaoGeograficas() {
		if(this.localizacaoGeograficas == null) this.localizacaoGeograficas = new ArrayList<LocalizacaoGeograficaXmlType>();
		return localizacaoGeograficas;
	}

	public void setLocalizacaoGeograficas(List<LocalizacaoGeograficaXmlType> localizacaoGeograficas) {
		this.localizacaoGeograficas = localizacaoGeograficas;
	}

	public GrupoDeTrilheirosXmlType getGrupoDeTrilheirosXmlType() {
		return grupoDeTrilheirosXmlType;
	}

	public void setGrupoDeTrilheirosXmlType(GrupoDeTrilheirosXmlType grupoDeTrilheirosXmlType) {
		this.grupoDeTrilheirosXmlType = grupoDeTrilheirosXmlType;
	}
	
	
}
