package trilhasbrasil.com.persistence.dao;

import trilhasbrasil.com.persistence.beans.GrupoDeTrilheiros;

public interface GrupoDeTrilheirosDao extends GenericoDao<GrupoDeTrilheiros> { 
	
	public Boolean adicionarTrilha(Integer grupoId, Integer trilhaId);
	
}
