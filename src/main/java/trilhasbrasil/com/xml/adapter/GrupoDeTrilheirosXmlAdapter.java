package trilhasbrasil.com.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import trilhasbrasil.com.persistencia.beans.Evento;
import trilhasbrasil.com.persistencia.beans.GrupoDeTrilheiros;
import trilhasbrasil.com.persistencia.beans.Imagens;
import trilhasbrasil.com.persistencia.beans.Trilha;
import trilhasbrasil.com.persistencia.beans.Trilheiro;
import trilhasbrasil.com.util.GeradorMD5;
import trilhasbrasil.com.xml.type.GrupoDeTrilheirosXmlType;

public final class GrupoDeTrilheirosXmlAdapter extends XmlAdapter<GrupoDeTrilheirosXmlType, GrupoDeTrilheiros>{

	private static final GrupoDeTrilheirosXmlAdapter GRUPO_DE_TRILHEIROS = new GrupoDeTrilheirosXmlAdapter();
	
	private GrupoDeTrilheirosXmlAdapter() {
		super();
	}
	
	public static GrupoDeTrilheirosXmlAdapter getInstance() {
		return GrupoDeTrilheirosXmlAdapter.GRUPO_DE_TRILHEIROS;
	}
	
	@Override
	public GrupoDeTrilheirosXmlType marshal(GrupoDeTrilheiros grupoDeTrilheiros) throws Exception {
		GrupoDeTrilheirosXmlType grupoDeTrilheirosXmlType = new GrupoDeTrilheirosXmlType();
		grupoDeTrilheirosXmlType.setCidade(grupoDeTrilheiros.getCidade());
		grupoDeTrilheirosXmlType.setEstado(grupoDeTrilheiros.getEstado());
		grupoDeTrilheirosXmlType.setId(grupoDeTrilheiros.getId());
		grupoDeTrilheirosXmlType.setNome(grupoDeTrilheiros.getNome());
		grupoDeTrilheirosXmlType.setLogin(grupoDeTrilheiros.getLogin());
		for(Evento evento : grupoDeTrilheiros.getEventos()) {
			grupoDeTrilheirosXmlType.getEventos().add(new Evento(evento.getId()));
		}
		for (Imagens imagem : grupoDeTrilheiros.getImagens()) {
			grupoDeTrilheirosXmlType.getImagens().add(new Imagens(imagem.getId(), imagem.getUrl()));
		}
		for (Trilha trilha : grupoDeTrilheiros.getTrilhas()) {
			grupoDeTrilheirosXmlType.getTrilhas().add(new Trilha(trilha.getId()));
		}
		for(Trilheiro trilheiro : grupoDeTrilheiros.getTrilheiros()) {
			grupoDeTrilheirosXmlType.getTrilheiros().add(new Trilheiro(trilheiro.getId()));
		}
		return grupoDeTrilheirosXmlType;
	}

	@Override
	public GrupoDeTrilheiros unmarshal(GrupoDeTrilheirosXmlType grupoDeTrilheirosXmlType) throws Exception {
		GrupoDeTrilheiros grupoDeTrilheiros = new GrupoDeTrilheiros();
		grupoDeTrilheiros.setCidade(grupoDeTrilheirosXmlType.getCidade());
		grupoDeTrilheiros.setEstado(grupoDeTrilheirosXmlType.getEstado());
		grupoDeTrilheiros.setEventos(grupoDeTrilheirosXmlType.getEventos());
		grupoDeTrilheiros.setId(grupoDeTrilheirosXmlType.getId());
		grupoDeTrilheiros.setImagens(grupoDeTrilheirosXmlType.getImagens());
		grupoDeTrilheiros.setLogin(grupoDeTrilheirosXmlType.getLogin());
		grupoDeTrilheiros.setNome(grupoDeTrilheirosXmlType.getNome());
		grupoDeTrilheiros.setSenha(GeradorMD5.gerarMD5(grupoDeTrilheirosXmlType.getSenha()));
		grupoDeTrilheiros.setTrilhas(grupoDeTrilheirosXmlType.getTrilhas());
		grupoDeTrilheiros.setTrilheiros(grupoDeTrilheirosXmlType.getTrilheiros());
		return grupoDeTrilheiros;
	}

}
