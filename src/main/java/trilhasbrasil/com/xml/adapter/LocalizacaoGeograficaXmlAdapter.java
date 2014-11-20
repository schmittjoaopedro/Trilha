package trilhasbrasil.com.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import trilhasbrasil.com.persistencia.beans.LocalizacaoGeografica;
import trilhasbrasil.com.xml.type.LocalizacaoGeograficaXmlType;

public class LocalizacaoGeograficaXmlAdapter extends XmlAdapter<LocalizacaoGeografica, LocalizacaoGeograficaXmlType>{

	private static final LocalizacaoGeograficaXmlAdapter LOCALIZACAO_GEOGRAFICA_XML_ADAPTER = new LocalizacaoGeograficaXmlAdapter();
	
	private LocalizacaoGeograficaXmlAdapter() {}
	
	public static LocalizacaoGeograficaXmlAdapter getInstance() {
		return LocalizacaoGeograficaXmlAdapter.LOCALIZACAO_GEOGRAFICA_XML_ADAPTER;
	}
	
	@Override
	public LocalizacaoGeografica marshal(LocalizacaoGeograficaXmlType localizacaoGeograficaXmlType) throws Exception {
		return null;
	}

	@Override
	public LocalizacaoGeograficaXmlType unmarshal(LocalizacaoGeografica localizacaoGeografica) throws Exception {
		return null;
	}

}
