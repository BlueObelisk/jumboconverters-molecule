package org.xmlcml.cml.converters.molecule.xyz;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.AbstractConverterModule;
import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;

/**
 * @author Sam Adams
 */
public class XYZModule extends AbstractConverterModule {

	public static final MimeType XYZ_TYPE = new MimeType("chemical/x-xyz", ObjectType.TEXT, "xyz");
	private static final String PREFIX = "xyz";
	
    public XYZModule(){
    }
    
    public String getPrefix() {
    	return PREFIX;
    }

	public List<Converter> getConverterList() {
		if (converterList == null) {
			converterList = new ArrayList<Converter>();
			converterList.add(new XYZ2CMLConverter());
			converterList.add(new CML2XYZConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
			mimeTypeList.add(XYZ_TYPE);
		}
		return mimeTypeList;
	}
	
	
}
