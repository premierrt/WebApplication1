/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pakiet.rt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author rafal
 */
@Service
public class DelicjaXMLParser {

    public DelicjaXMLParser() {
    }

private String xmlInputString;

@Autowired
private DelicjaResponseObject resp; 

public DelicjaResponseObject parseAndCreateRespone(){
        try {
            parse();
        } catch (SAXException ex) {
            Logger.getLogger(DelicjaXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DelicjaXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (XPathExpressionException ex) {
            Logger.getLogger(DelicjaXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DelicjaXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
}

private void parse() throws SAXException, IOException, XPathExpressionException, ParserConfigurationException{
    DocumentBuilderFactory builderFactory =
        DocumentBuilderFactory.newInstance();
DocumentBuilder builder =  builderFactory.newDocumentBuilder();
Document xmlDocument = builder.parse(new ByteArrayInputStream(xmlInputString.getBytes()));
XPath xPath =  XPathFactory.newInstance().newXPath();
String userName = xPath.evaluate("//*[1]/@user", xmlDocument);
resp.setUser(userName);
System.out.println("test: " +userName);

try {
    builder = builderFactory.newDocumentBuilder();
} catch (ParserConfigurationException e) {
    e.printStackTrace();  
}
    



}

    public String getXmlInputString() {
        return xmlInputString;
    }

    public void setXmlInputString(String xmlInputString) {
        this.xmlInputString = xmlInputString;
    }

    public DelicjaResponseObject getResp() {
        return resp;
    }

    
    
}
