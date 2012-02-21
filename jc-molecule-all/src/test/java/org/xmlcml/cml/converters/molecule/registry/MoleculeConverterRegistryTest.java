package org.xmlcml.cml.converters.molecule.registry;

import static org.junit.Assert.assertNull;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.xmlcml.cml.converters.Converter;
import org.xmlcml.cml.converters.MimeType;
import org.xmlcml.cml.converters.cml.CML2CMLLiteConverter;
import org.xmlcml.cml.converters.cml.CMLCommon;
import org.xmlcml.cml.converters.molecule.registry.MoleculeConverterRegistry;
import org.xmlcml.cml.converters.registry.ConverterRegistry;
import org.xmlcml.cml.converters.registry.TypePair;
import org.xmlcml.cml.converters.molecule.mdl.MDLModule;

//@Ignore
public class MoleculeConverterRegistryTest {

	String CML = "chemical/x-cml";
	String CDX = "chemical/x-cdx";
	String FOO = "chemical/x-foo";
	TypePair PAIR_OK  = new TypePair(FOO, CML);
	TypePair PAIR_MISSING  = new TypePair(CML, CDX);

    @Test
    public void testMap() {
    	Map<TypePair, List<Converter>> map = MoleculeConverterRegistry.getDefaultConverterRegistry().getMap();
    	Assert.assertNotNull(map);
    	// size will change as more are added
    	Assert.assertEquals(9, map.size());
    }

    @Test
    public void testList() {
    	List<Converter> converterList = MoleculeConverterRegistry.getDefaultConverterRegistry().getConverterList();
    	Assert.assertNotNull(converterList);
    	for (Converter converter : converterList) {
    		System.out.println(converter);
    	}
    	Assert.assertEquals(10, converterList.size());
    }

    @Test
    public void testList1() {
    	List<Converter> converterList = MoleculeConverterRegistry.getDefaultConverterRegistry().getConverterList();
    	boolean found = false;
    	for (Converter converter : converterList) {
    		if (CML2CMLLiteConverter.class.equals(converter.getClass())) {
    			found = true;
    			break;
    		}
    	}
    	Assert.assertTrue("converter", found);
    }

    @Test
    public void testMap1() {
    	Map<TypePair, List<Converter>> map = MoleculeConverterRegistry.getDefaultConverterRegistry().getMap();
    	Assert.assertTrue(map.containsKey(PAIR_OK));
    	Assert.assertFalse(map.containsKey(PAIR_MISSING));
    	for (TypePair typePair1 : map.keySet()) {
    		System.out.println(typePair1);
    	}
    }

    @Test
    public void testFindConverter() {
    	List<Converter> converters = MoleculeConverterRegistry.getDefaultConverterRegistry().findConverters(
    			MDLModule.MOL_TYPE.getMimeType(), CMLCommon.CML_TYPE.getMimeType());
    	Assert.assertNotNull("mdl", converters);
    	for (Converter converter : converters) {
    		System.out.println("Converter: "+converter);
    	}
    	Assert.assertEquals("mdl", 2, converters.size());
    	Assert.assertEquals("mdl", "org.xmlcml.cml.converters.molecule.mdl.MDL2CMLConverter", converters.get(0).getClass().getName());
    }

    @Test
    public void testFindConverter1() {
    	List<Converter> converters = MoleculeConverterRegistry.getDefaultConverterRegistry().findConverters(CML, CML);
    	Assert.assertNotNull("cml", converters);
//    	for (Converter converter : converters) {
//    		System.out.println(converter);
//    	}
    	Assert.assertEquals("cml", 4, converters.size());
    }

	@Test
	public void testRegistryLoadsConverterList() {
		List<Converter> list = MoleculeConverterRegistry.getDefaultConverterRegistry().getConverterList();
		assertTrue(list.size()>0);
	}

	@Test
	public void testFindFoo2BarConverter() {
		List<Converter> converterList = MoleculeConverterRegistry.getDefaultConverterRegistry().findConverters("foo", "bar");
		assertNull(converterList);
	}

	@Test
	public void testFindTypesFromSuffix() {
		Set<MimeType> types = MoleculeConverterRegistry.getDefaultConverterRegistry().getTypes("cml");
		Assert.assertNotNull("get types", types);
		Assert.assertEquals("get types", 2, types.size());
		Assert.assertEquals("get types", "chemical/x-cml", ((MimeType)types.toArray()[0]).getMimeType());
	}

	@Test
	public void testFindTypesFromSuffix1() {
		Set<MimeType> types = MoleculeConverterRegistry.getDefaultConverterRegistry().getTypes("foo");
		Assert.assertNotNull("get types", types);
		Assert.assertEquals("types count", 1, types.size());
		Assert.assertEquals("type", "chemical/x-foo", ((MimeType)types.toArray()[0]).getMimeType());
	}

	@Test
	public void testFindSingleTypeFromSuffix() {
		MimeType type = MoleculeConverterRegistry.getDefaultConverterRegistry().getSingleTypeFromSuffix("cml");
		Assert.assertNull("get type", type);
	}

	@Test
	public void testSingletonConverterRegistry() {
		Assert.assertNotNull(MoleculeConverterRegistry.getDefaultConverterRegistry());
	}

	@Test
	public void testCreateRegistryList0() {
		ConverterRegistry converterRegistry = new ConverterRegistry(ConverterRegistry.class.getClassLoader());
		List<Converter> converterList = converterRegistry.getConverterList();
		Assert.assertNotNull(converterList);
		converterRegistry.createConvertersList();
		converterList = converterRegistry.getConverterList();
		Assert.assertNotNull(converterList);
	}

	@Test
	public void testCreateRegistryList() {
		ConverterRegistry converterRegistry = new MoleculeConverterRegistry(MoleculeConverterRegistry.class.getClassLoader());
		converterRegistry.populateAndRegister();
		List<Converter> converterList = converterRegistry.getConverterList();
		converterRegistry.createConvertersList();
		converterList = converterRegistry.getConverterList();
		// should at least contain org.xmlcml.cml.converters.cml.CML2CMLLiteConverter@76f2d004
		Assert.assertTrue(converterList.size()>0);
		boolean hasCmllite = false;
		for (Converter converter : converterList) {
			if (converter instanceof org.xmlcml.cml.converters.cml.CML2CMLLiteConverter) {
				hasCmllite = true;
				break;
			}
		}
		Assert.assertTrue("has cmllite", hasCmllite);
	}

	@Test
	public void testSingletonConverterRegistryList0() {
		ConverterRegistry converterRegistry = MoleculeConverterRegistry.getDefaultConverterRegistry();
		List<Converter> converterList = converterRegistry.getConverterList();
		Assert.assertNotNull(converterList);
		Assert.assertEquals("converterList", 10, converterList.size());
	}

	@Test
	public void testSingletonConverterRegistryList() {
		List<Converter> converterList = MoleculeConverterRegistry.getDefaultConverterRegistry().getConverterList();
		Assert.assertNotNull(converterList);
		Assert.assertEquals("converterList", 10, converterList.size());
	}

}
