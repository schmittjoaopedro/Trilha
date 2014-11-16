package trilhasbrasil.com.persistencia.dao;

import java.util.List;

import trilhasbrasil.com.persistencia.beans.Trilheiro;

public interface TrilheiroDao extends GenericoDao<Trilheiro> {

	public List<Trilheiro> procurarTrilheirosPorGrupo(Long grupoDeTrilheirosId);
	
}
