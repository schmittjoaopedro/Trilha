package trilhasbrasil.com.servico;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import trilhasbrasil.com.persistencia.beans.Trilha;
import trilhasbrasil.com.persistencia.dao.TrilhaDao;
import trilhasbrasil.com.xml.adapter.TrilhaXmlAdapter;
import trilhasbrasil.com.xml.type.TrilhaXmlType;

@Stateless
public class TrilhaServico {

	@EJB
	private TrilhaDao trilhaDao;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public TrilhaXmlType salvar(TrilhaXmlType trilhaXmlType) throws Exception {
		Trilha trilha = TrilhaXmlAdapter.getInstance().marshal(trilhaXmlType);
		trilha = trilhaDao.salvar(trilha);
		return TrilhaXmlAdapter.getInstance().unmarshal(trilha);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<TrilhaXmlType> procurarTodasAsTrilhas() throws Exception {
		List<Trilha> trilhas = this.trilhaDao.procurarTodos();
		List<TrilhaXmlType> trilhaXmlTypes = new ArrayList<TrilhaXmlType>();
		for(Trilha trilha : trilhas) 
			trilhaXmlTypes.add(TrilhaXmlAdapter.getInstance().unmarshal(trilha));
		return trilhaXmlTypes;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public TrilhaXmlType procurarTrilhaPorId(Long id) throws Exception {
		return TrilhaXmlAdapter.getInstance().unmarshal(this.trilhaDao.procurarPeloId(id));
	}

	@Transactional(value = TxType.REQUIRES_NEW)
	public Boolean removerTrilhaPorId(Long id) {
		return this.trilhaDao.remove(id);
	}
	
}


