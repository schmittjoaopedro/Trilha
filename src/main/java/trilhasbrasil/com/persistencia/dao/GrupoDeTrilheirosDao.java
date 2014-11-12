package trilhasbrasil.com.persistencia.dao;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;

public interface GrupoDeTrilheirosDao extends GenericoDao<GrupoDeTrilheiros> { 
	
	public GrupoDeTrilheiros procurarPorLoginESenha(String login, String senha);
	
}
