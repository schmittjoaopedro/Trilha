package trilhasbrasil.com.servico;

import java.util.List;

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
	public GrupoDeTrilheiros salvar(GrupoDeTrilheiros grupoDeTrilheiros) {
		return this.grupoDeTrilheirosDao.salvar(grupoDeTrilheiros);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<GrupoDeTrilheiros> procurarTodos() {
		return this.grupoDeTrilheirosDao.procurarTodos();
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<GrupoDeTrilheiros> procurarTodosComFiltroPaginado(Integer start, Integer limit, String query) {
		return this.grupoDeTrilheirosDao.procurarPorQueryPaginado(start, limit, query);
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public Boolean remover(Long id) {
		return this.grupoDeTrilheirosDao.remove(id);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public GrupoDeTrilheiros procurarPeloId(Long id) {
		return this.grupoDeTrilheirosDao.procurarPeloId(id);
	}
	
	public Boolean adicionarTrilha(Long grupoId, Long trilhaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
