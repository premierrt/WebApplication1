/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package location;

import helper.NSResolver;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author rafal
 */
public class NewJerseyClientTest {
    
    public NewJerseyClientTest() {
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
     * Test of getStationsXML method, of class NewJerseyClient.
     */
    @Test
    public void testGetStationsXML() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        //http://docs.oracle.com/javaee/7/tutorial/doc/jaxrs-client001.htm
        //http://i.wxbug.net/REST/SP/getStationsXML.aspx?api_key=pstz97by4eghv4rkvejmyhzc&cityCode=73051
        System.out.println("getStationsXML");
        NewJerseyClient instance = new NewJerseyClient();
        Object expResult = null;
        String result = instance.getStationsXML(String.class,"pstz97by4eghv4rkvejmyhzc","CityCode=73051");
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //https://weblogs.java.net/blog/mhadley/archive/2006/01/restful_web_ser.html
        //http://viralpatel.net/blogs/java-xml-xpath-tutorial-parse-xml/
       System.out.println(result);
       
       
       
       //DOM xml parser
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        builderFactory.setNamespaceAware(true);
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc= builder.parse(new ByteArrayInputStream(result.getBytes()));
//    Node n=doc.getFirstChild();
//       System.out.println(n.toString());
//              System.out.println( n.getFirstChild().toString());

      
        //http://www.ibm.com/developerworks/library/x-nmspccontext/
        //Xpath
        XPath xp = XPathFactory.newInstance().newXPath();
      xp.setNamespaceContext(new NSResolver());
        String expression = "//aws:station[@id='EPWA']";
   NodeList nodeList2 = (NodeList) xp.compile(expression).evaluate(doc, XPathConstants.NODESET);
System.out.println(nodeList2.item(0).getNodeName());
        
 

        String expression2 = "aws:weather/aws:stations/aws:station";

        
     NodeList nodeList = (NodeList) xp.compile(expression2).evaluate(doc, XPathConstants.NODESET);
System.out.println(nodeList.getLength());
     for (int i = 0; i < nodeList.getLength(); i++) {
    System.out.println("i= "+ i +nodeList.item(i).getNodeName()); 
} 
       
       
        assertNotNull(result);
   //     fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class NewJerseyClient.
     */
    @Test
    public void testClose() {
        System.out.println("close");
        NewJerseyClient instance = new NewJerseyClient();
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
