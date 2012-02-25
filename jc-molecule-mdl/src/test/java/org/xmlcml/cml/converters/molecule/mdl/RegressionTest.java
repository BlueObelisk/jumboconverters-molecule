/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xmlcml.cml.converters.molecule.mdl;


import org.junit.Ignore;
import org.junit.Test;
import org.xmlcml.cml.converters.testutils.JumboConvertersRegressionSuite;
/**
 *
 * @author ojd20
 */
public class RegressionTest {

   @Test
   @Ignore
   public void cml2mdl() {
      JumboConvertersRegressionSuite.run("molecule/mdl/cml2mdl", "cml", "mol",
                          new CML2MDLConverter());
   }

   @Test
   @Ignore
   public void mdl2cml() {
      JumboConvertersRegressionSuite.run("molecule/mdl/mdl2cml", "mol", "cml",
                          new MDL2CMLConverter());
   }

   @Test
   @Ignore
   public void sdf2cml() {
      JumboConvertersRegressionSuite.run("molecule/sdf", "sdf", "cml",
                          new SDF2CMLConverter());
   }
}
