package trilhasbrasil.com.servico;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import trilhasbrasil.com.persistencia.beans.Trilheiro;
import trilhasbrasil.com.persistencia.dao.TrilheiroDao;
import trilhasbrasil.com.xml.adapter.TrilheiroXmlAdapter;
import trilhasbrasil.com.xml.type.TrilheiroXmlType;

@Stateless
public class TrilheiroServico {

	@EJB
	private TrilheiroDao trilheiroDao;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public TrilheiroXmlType salvar(TrilheiroXmlType trilheiroXmlType) throws Exception {
		Trilheiro trilheiro = TrilheiroXmlAdapter.getInstance().unmarshal(trilheiroXmlType);
		this.trilheiroDao.salvar(trilheiro);
		return TrilheiroXmlAdapter.getInstance().marshal(trilheiro);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<TrilheiroXmlType> procurarTodosTrilheiros() throws Exception {
		List<TrilheiroXmlType> trilheirosXmlTypes = new ArrayList<TrilheiroXmlType>();
		List<Trilheiro> trilheiros = this.trilheiroDao.procurarTodos();
		for(Trilheiro trilheiro : trilheiros)
			trilheirosXmlTypes.add(TrilheiroXmlAdapter.getInstance().marshal(trilheiro));
		return trilheirosXmlTypes;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<TrilheiroXmlType> procurarTrilheirosPorGrupo(Long grupoDeTrilheirosId) throws Exception {
		List<TrilheiroXmlType> trilheirosXmlTypes = new ArrayList<TrilheiroXmlType>();
		List<Trilheiro> trilheiros = this.trilheiroDao.procurarTrilheirosPorGrupo(grupoDeTrilheirosId);
		for(Trilheiro trilheiro : trilheiros)
			trilheirosXmlTypes.add(TrilheiroXmlAdapter.getInstance().marshal(trilheiro));
		return trilheirosXmlTypes;
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public Boolean deletarTrilheiro(Long trilheiroId, Long grupoDeTrilheirosId) {
		Trilheiro trilheiro = this.trilheiroDao.procurarPeloId(trilheiroId);
		if(trilheiro != null && grupoDeTrilheirosId != null && trilheiro.getGrupoDeTrilheiros().getId().equals(grupoDeTrilheirosId)) {
			return this.trilheiroDao.remove(trilheiro);
		} else {
			return false;
		}
	}
	
}
