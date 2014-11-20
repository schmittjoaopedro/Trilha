package trilhasbrasil.com.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import trilhasbrasil.com.persistencia.beans.Imagens;
import trilhasbrasil.com.persistencia.beans.LocalizacaoGeografica;
import trilhasbrasil.com.persistencia.beans.Trilha;
import trilhasbrasil.com.xml.type.ImagemXmlType;
import trilhasbrasil.com.xml.type.LocalizacaoGeograficaXmlType;
import trilhasbrasil.com.xml.type.TrilhaXmlType;

public final class TrilhaXmlAdapter extends XmlAdapter<Trilha, TrilhaXmlType> {

	private static final TrilhaXmlAdapter TRILHA_XML_ADAPTER = new TrilhaXmlAdapter();
	
	private TrilhaXmlAdapter() {}
	
	public static TrilhaXmlAdapter getInstance() {
		return TrilhaXmlAdapter.TRILHA_XML_ADAPTER;
	}
	
	@Override
	public Trilha marshal(TrilhaXmlType trilhaXmlType) throws Exception {
		Trilha trilha = new Trilha();
		trilha.setId(trilhaXmlType.getId());
		trilha.setCidade(trilhaXmlType.getCidade());
		trilha.setEstado(trilhaXmlType.getEstado());
		trilha.setNome(trilhaXmlType.getNome());
		for(ImagemXmlType imagemXmlType : trilhaXmlType.getImagens()) {
			trilha.getImagens().add(ImagemXmlAdapter.getInstance().unmarshal(imagemXmlType));
		}
		for(LocalizacaoGeograficaXmlType localizacaoGeograficaXmlType : trilhaXmlType.getLocalizacaoGeograficas()) {
			LocalizacaoGeografica geografica = LocalizacaoGeograficaXmlAdapter.getInstance().marshal(localizacaoGeograficaXmlType);
			trilha.getLocalizacaoGeograficas().add(geografica);
			geografica.setTrilha(trilha);
		}
		return trilha;
	}

	@Override
	public TrilhaXmlType unmarshal(Trilha trilha) throws Exception {
		TrilhaXmlType trilhaXmlType = new TrilhaXmlType();
		trilhaXmlType.setId(trilha.getId());
		trilhaXmlType.setCidade(trilha.getCidade());
		trilhaXmlType.setEstado(trilha.getEstado());
		trilhaXmlType.setNome(trilha.getNome());
		for(Imagens imagens : trilha.getImagens())
			trilhaXmlType.getImagens().add(ImagemXmlAdapter.getInstance().marshal(imagens));
		for(LocalizacaoGeografica geografica : trilha.getLocalizacaoGeograficas())
			trilhaXmlType.getLocalizacaoGeograficas().add(LocalizacaoGeograficaXmlAdapter.getInstance().unmarshal(geografica));
		return trilhaXmlType;
	}

}
