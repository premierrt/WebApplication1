/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pakiet.rt;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rafal
 */
public class DelicjaSerwisTest {
    
    public DelicjaSerwisTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getSimpleResponeFromDelicje method, of class DelicjaSerwis.
     */
    @Test
    public void testGetSimpleResponeFromDelicje() throws Exception {
        System.out.println("getSimpleResponeFromDelicje");
        String expResult = "";
        String result = DelicjaSerwis.getSimpleResponeFromDelicje();
        
       // assertEquals(expResult, result);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
    }
    
}
