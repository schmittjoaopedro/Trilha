package trilhasbrasil.com.xml.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import trilhasbrasil.com.persistencia.beans.Imagens;
import trilhasbrasil.com.xml.type.ImagemXmlType;

public final class ImagemXmlAdapter extends XmlAdapter<ImagemXmlType, Imagens> {

	private static final ImagemXmlAdapter IMAGEM_XML_ADAPTER = new ImagemXmlAdapter();

	private ImagemXmlAdapter() {
		super();
	}

	public static ImagemXmlAdapter getInstance() {
		return ImagemXmlAdapter.IMAGEM_XML_ADAPTER;
	}

	@Override
	public ImagemXmlType marshal(Imagens imagens) throws Exception {
		ImagemXmlType imagemXmlType = new ImagemXmlType();
		imagemXmlType.setId(imagens.getId());
		imagemXmlType.setUrl(imagens.getUrl());
		return imagemXmlType;
	}

	@Override
	public Imagens unmarshal(ImagemXmlType imagemXmlType) throws Exception {
		Imagens imagens = new Imagens();
		imagens.setId(imagemXmlType.getId());
		imagens.setUrl(imagemXmlType.getUrl());
		return imagens;
	}

}
