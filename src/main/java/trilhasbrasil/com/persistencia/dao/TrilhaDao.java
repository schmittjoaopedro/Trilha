package trilhasbrasil.com.persistencia.dao;

import java.util.List;

import trilhasbrasil.com.persistencia.beans.Trilha;

public interface TrilhaDao extends GenericoDao<Trilha> { 
	
	List<Trilha> procurarTrilhasPorEstado(String nomeDoEstado);
	
	List<Trilha> procurarTrilhasPorGrupoDeTrilheiros(String nomeDoGrupo);
	
}
