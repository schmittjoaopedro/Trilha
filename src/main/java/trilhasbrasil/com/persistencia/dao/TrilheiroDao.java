package trilhasbrasil.com.persistencia.dao;

import trilhasbrasil.com.persistencia.beans.Trilheiro;

public interface TrilheiroDao extends GenericoDao<Trilheiro> {

	public Boolean associarTrilheiroAoGrupo(Long trilheiroId, Long grupoId);
	
	public Boolean removerTrilheiroDoGrupo(Long grupoId, Long trilheiroId);
	
}
