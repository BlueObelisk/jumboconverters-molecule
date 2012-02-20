package org.xmlcml.cml.converters.molecule.mdl;

import java.util.ArrayList;
import java.util.List;

import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.MimeType.ObjectType;
import org.xmlcml.cml.converters.registry.AbstractConverterModule;

/**
 * @author Sam Adams
 */
public class MDLModule extends AbstractConverterModule {

	public static final MimeType MOL_TYPE = new MimeType("chemical/x-mdl-molfile", ObjectType.TEXT, "mol");
	public static final MimeType SDF_TYPE = new MimeType("chemical/x-mdl-sdffile", ObjectType.TEXT, "sdf");
	private static final String PREFIX = "mol";
	
    public MDLModule(){
    }
    
    public String getPrefix() {
    	return PREFIX;
    }

	public List<Converter> getConverterList() {
		if (converterList == null) {
			System.out.println("MDLMODULE");
			converterList = new ArrayList<Converter>();
			converterList.add(new CML2MDLConverter());
			converterList.add(new CML2SDFConverter());
			converterList.add(new MDL2CMLConverter());
			converterList.add(new SDF2CMLConverter());
		}
		return converterList;
	}

	public List<MimeType> getMimeTypeList() {
		if (mimeTypeList == null) {
			mimeTypeList = new ArrayList<MimeType>();
			mimeTypeList.add(MOL_TYPE);
			mimeTypeList.add(SDF_TYPE);
		}
		return mimeTypeList;
	}
	
	
}
