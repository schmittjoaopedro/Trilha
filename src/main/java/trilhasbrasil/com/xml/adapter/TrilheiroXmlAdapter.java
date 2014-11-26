package trilhasbrasil.com.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import trilhasbrasil.com.persistencia.beans.Imagens;
import trilhasbrasil.com.persistencia.beans.Trilheiro;
import trilhasbrasil.com.xml.type.GrupoDeTrilheirosXmlType;
import trilhasbrasil.com.xml.type.ImagemXmlType;
import trilhasbrasil.com.xml.type.TrilheiroXmlType;


public final class TrilheiroXmlAdapter extends XmlAdapter<TrilheiroXmlType, Trilheiro> {

	private static final TrilheiroXmlAdapter TRILHEIRO_XML_ADAPTER = new TrilheiroXmlAdapter();
	
	private TrilheiroXmlAdapter() { }
	
	public static TrilheiroXmlAdapter getInstance() {
		return TrilheiroXmlAdapter.TRILHEIRO_XML_ADAPTER;
	}
	
	@Override
	public TrilheiroXmlType marshal(Trilheiro trilheiro) throws Exception {
		TrilheiroXmlType trilheiroXmlType = new TrilheiroXmlType();
		trilheiroXmlType.setId(trilheiro.getId());
		trilheiroXmlType.setEmail(trilheiro.getEmail());
		trilheiroXmlType.setNome(trilheiro.getNome());
		trilheiroXmlType.setTelefone(trilheiro.getTelefone());
                if(trilheiro.getGrupoDeTrilheiros() != null) {
                    GrupoDeTrilheirosXmlType grupoDeTrilheirosXmlType = new GrupoDeTrilheirosXmlType();
                    grupoDeTrilheirosXmlType.setId(trilheiro.getGrupoDeTrilheiros().getId());
                    trilheiroXmlType.setGrupoDeTrilheirosXmlType(grupoDeTrilheirosXmlType);
                }
		for(Imagens imagens : trilheiro.getImagens())
			trilheiroXmlType.getImagemXmlTypes().add(ImagemXmlAdapter.getInstance().marshal(imagens));
		return trilheiroXmlType;
	}

	@Override
	public Trilheiro unmarshal(TrilheiroXmlType trilheiroXmlType) throws Exception {
		Trilheiro trilheiro = new Trilheiro();
		trilheiro.setId(trilheiroXmlType.getId());
		trilheiro.setEmail(trilheiroXmlType.getEmail());
		trilheiro.setNome(trilheiroXmlType.getNome());
		trilheiro.setTelefone(trilheiroXmlType.getTelefone());
		trilheiro.setGrupoDeTrilheiros(GrupoDeTrilheirosXmlAdapter.getInstance().unmarshal(trilheiroXmlType.getGrupoDeTrilheirosXmlType()));
		for(ImagemXmlType imagemXmlType : trilheiroXmlType.getImagemXmlTypes())
			trilheiro.getImagens().add(ImagemXmlAdapter.getInstance().unmarshal(imagemXmlType));
		return trilheiro;
	}

}
