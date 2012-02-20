package org.xmlcml.cml.converters.molecule.pubchem;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;
import org.xmlcml.cml.converters.registry.AbstractConverterModule;

/**
 * @author Sam Adams
 */
public class PubchemModule extends AbstractConverterModule {

	public static final MimeType PUBCHEM_XML_TYPE = new MimeType("chemical/x-pubchem-xml", ObjectType.XML, "pubchem-xml");
	private static final String PREFIX = "pubchem.xml";
	
    public PubchemModule(){
    }
    
    public String getPrefix() {
    	return PREFIX;
    }

	public List<Converter> getConverterList() {
		if (converterList == null) {
			converterList = new ArrayList<Converter>();
			converterList.add(new PubchemXML2CMLConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
			mimeTypeList.add(PUBCHEM_XML_TYPE);
		}
		return mimeTypeList;
	}
	
	
}
