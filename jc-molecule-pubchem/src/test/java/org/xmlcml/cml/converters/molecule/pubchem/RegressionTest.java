package org.xmlcml.cml.converters.molecule.pubchem;

import org.junit.Ignore;
import org.junit.Test;
import org.xmlcml.cml.converters.molecule.pubchem.sdf.CML2PubchemSDFConverter;
import org.xmlcml.cml.converters.testutils.JumboConvertersRegressionSuite;

/**
 *
 * @author ojd20
 */
public class RegressionTest {

   @Test
   @Ignore
   public void cml2pubchem() {
      JumboConvertersRegressionSuite.run("molecule/pubchem/sdf", "cml.xml", "sdf",
                          new CML2PubchemSDFConverter());
   }

   @Test
   @Ignore
   public void pubchemxml2cml() {
      JumboConvertersRegressionSuite.run("molecule/pubchem", "xml", "cml",
                          new PubchemXML2CMLConverter(
              "molecule/pubchem/config/config.xml"));
   }
}
