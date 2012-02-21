package org.xmlcml.cml.converters.molecule.registry;

import org.xmlcml.cml.converters.registry.ConverterRegistry;

/**
 * @author pm286
 */
public class MoleculeConverterRegistry extends ConverterRegistry {

    /** create singleton registry
     */
    private static MoleculeConverterRegistry MOLECULE_CONVERTER_REGISTRY = null;

    public static synchronized MoleculeConverterRegistry getDefaultConverterRegistry() {
    	if (MOLECULE_CONVERTER_REGISTRY == null) {
    		MOLECULE_CONVERTER_REGISTRY = new MoleculeConverterRegistry(MoleculeConverterRegistry.class.getClassLoader());
    		MOLECULE_CONVERTER_REGISTRY.populateAndRegister();
    	}
    	return MOLECULE_CONVERTER_REGISTRY;
    }

    public MoleculeConverterRegistry(ClassLoader classLoader) {
    	super(classLoader);
    }

    public MoleculeConverterRegistry(Class clazz) {
    	super(clazz);
    }


}
