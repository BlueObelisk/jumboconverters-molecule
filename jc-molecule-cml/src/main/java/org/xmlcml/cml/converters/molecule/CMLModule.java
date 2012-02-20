package org.xmlcml.cml.converters.molecule;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;
import org.xmlcml.cml.converters.molecule.cml.CML2CMLConverter;
import org.xmlcml.cml.converters.registry.AbstractConverterModule;

/**
 * @author Sam Adams
 */
public class CMLModule extends AbstractConverterModule {

	public static final MimeType MOL_TYPE = new MimeType("chemical/x-mdl-molfile", ObjectType.TEXT, "mol");
	public static final MimeType SDF_TYPE = new MimeType("chemical/x-mdl-sdffile", ObjectType.TEXT, "sdf");
	private static final String PREFIX = "cml";
	
    public CMLModule(){
    }
    
    public String getPrefix() {
    	return PREFIX;
    }

	public List<Converter> getConverterList() {
		if (converterList == null) {
			converterList = new ArrayList<Converter>();
			converterList.add(new CML2CMLConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
		}
		return mimeTypeList;
	}
	
	
}
