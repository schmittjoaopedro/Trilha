package trilhasbrasil.com.servico;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import trilhasbrasil.com.persistencia.beans.AccessRoles;
import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.persistencia.dao.GrupoDeTrilheirosDao;
import trilhasbrasil.com.util.GeradorMD5;
import trilhasbrasil.com.xml.adapter.GrupoDeTrilheirosXmlAdapter;
import trilhasbrasil.com.xml.type.GrupoDeTrilheirosXmlType;

@Stateless
public class GrupoDeTrilheirosServico {

	@EJB
	private GrupoDeTrilheirosDao grupoDeTrilheirosDao;
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public GrupoDeTrilheirosXmlType salvar(GrupoDeTrilheirosXmlType grupoDeTrilheirosXmlType) throws Exception {
		GrupoDeTrilheiros grupoDeTrilheiros = GrupoDeTrilheirosXmlAdapter.getInstance().unmarshal(grupoDeTrilheirosXmlType);
		grupoDeTrilheiros.setAccessRoles(AccessRoles.Grupo);
		return GrupoDeTrilheirosXmlAdapter.getInstance().marshal(this.grupoDeTrilheirosDao.salvar(grupoDeTrilheiros));
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<GrupoDeTrilheirosXmlType> procurarTodos() throws Exception {
		List<GrupoDeTrilheirosXmlType> grupoDeTrilheirosXmlTypes = new ArrayList<GrupoDeTrilheirosXmlType>();
		for(GrupoDeTrilheiros grupoDeTrilheiros : this.grupoDeTrilheirosDao.procurarTodos()) {
			grupoDeTrilheirosXmlTypes.add(GrupoDeTrilheirosXmlAdapter.getInstance().marshal(grupoDeTrilheiros));
		}
		return grupoDeTrilheirosXmlTypes;
	}
	
	@Transactional(value = TxType.REQUIRED)
	public List<GrupoDeTrilheirosXmlType> procurarTodosComFiltroPaginado(Integer start, Integer limit, String query) throws Exception {
		List<GrupoDeTrilheirosXmlType> grupoDeTrilheirosXmlTypes = new ArrayList<GrupoDeTrilheirosXmlType>();
		if(query.equals(null) || query.trim().equals("")) {
			query = "_";
		}
		for(GrupoDeTrilheiros grupoDeTrilheiros : this.grupoDeTrilheirosDao.procurarPorQueryPaginado(start, limit, query)) {
			grupoDeTrilheirosXmlTypes.add(GrupoDeTrilheirosXmlAdapter.getInstance().marshal(grupoDeTrilheiros));
		}
		return grupoDeTrilheirosXmlTypes;
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public Boolean remover(Long id) {
		return this.grupoDeTrilheirosDao.remove(id);
	}
	
	@Transactional(value = TxType.REQUIRED)
	public GrupoDeTrilheirosXmlType procurarPeloId(Long id) throws Exception {
		return GrupoDeTrilheirosXmlAdapter.getInstance().marshal(this.grupoDeTrilheirosDao.procurarPeloId(id));
	}
	
	public Boolean adicionarTrilha(Long grupoId, Long trilhaId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(value = TxType.REQUIRES_NEW)
	public GrupoDeTrilheirosXmlType autenticarUsuario(String login, String senha, HttpServletRequest httpServletRequest) throws Exception {
		GrupoDeTrilheiros grupoDeTrilheiros = null;
		try {
			grupoDeTrilheiros = this.grupoDeTrilheirosDao.procurarPorLoginESenha(login, GeradorMD5.gerarMD5(senha));
			httpServletRequest.getSession().setAttribute("user", grupoDeTrilheiros);
		} catch (Exception ex) {
			throw new Exception("Usuário não registrado");
		}
		if(grupoDeTrilheiros == null) {
			throw new Exception("Usuário inválido");
		} else {
			return GrupoDeTrilheirosXmlAdapter.getInstance().marshal(grupoDeTrilheiros);
		}
	}
	
}
