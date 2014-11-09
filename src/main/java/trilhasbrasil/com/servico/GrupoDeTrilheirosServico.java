package trilhasbrasil.com.servico;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.persistencia.dao.GrupoDeTrilheirosDao;

@Stateless
public class GrupoDeTrilheirosServico {

	@EJB
	private GrupoDeTrilheirosDao grupoDeTrilheirosDao;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void save(GrupoDeTrilheiros grupoDeTrilheiros) {
		this.grupoDeTrilheirosDao.save(grupoDeTrilheiros);
	}
	
}
