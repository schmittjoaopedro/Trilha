package trilhasbrasil.com.persistencia.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LocalizacaoGeografica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double latitude;
	
	private Double longitude;
	
	@ManyToOne
	private Trilha trilha;
	
	public LocalizacaoGeografica() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Trilha getTrilha() {
		return trilha;
	}

	public void setTrilha(Trilha trilha) {
		this.trilha = trilha;
	}
	
}
