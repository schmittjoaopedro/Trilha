package trilhasbrasil.com.persistencia.dao;

import trilhasbrasil.com.persistencia.beans.Trilha;

public interface TrilhaDao extends GenericoDao<Trilha> { 

	public Boolean associarGrupoATrilha(Long grupoId, Long trilhaId);
	
}
