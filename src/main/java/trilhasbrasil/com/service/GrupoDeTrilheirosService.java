package trilhasbrasil.com.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import trilhasbrasil.com.persistence.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.persistence.dao.GrupoDeTrilheirosDao;

@Stateless
public class GrupoDeTrilheirosService {

	@EJB
	private GrupoDeTrilheirosDao grupoDeTrilheirosDao;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public void save(GrupoDeTrilheiros grupoDeTrilheiros) {
		this.grupoDeTrilheirosDao.save(grupoDeTrilheiros);
	}
	
}
