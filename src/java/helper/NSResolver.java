/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helper;

import java.util.Iterator;
import javax.xml.namespace.NamespaceContext;

/**
 *
 * @author rafal
 */
public class NSResolver implements NamespaceContext{

    @Override
    public String getNamespaceURI(String prefix) {
        
         if (prefix == null) {
            throw new IllegalArgumentException("No prefix provided!");
        } else if (prefix.equals("aws")) {
            return "http://www.aws.com/aws";
        }
         else
            return null;
         
        
    }

    @Override
    public String getPrefix(String namespaceURI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
