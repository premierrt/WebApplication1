/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controler.rt;


import java.io.IOException;
import javax.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pakiet.rt.DelicjaResponseObject;
import pakiet.rt.DelicjaSerwis;
import pakiet.rt.DelicjaXMLParser;

/**
 *
 * @author rafal
 */
 @Controller
 @RequestMapping("/dupa")
public class DelicjaControler {

     @Autowired
     private DelicjaXMLParser pars;
     
     private DelicjaResponseObject resp;
     
    @RequestMapping(method = RequestMethod.GET)
    public String drukujDelicje(ModelMap model) throws IOException, JAXBException{
               //to tez powinien byc bean 
        String out= DelicjaSerwis.getSimpleResponeFromDelicje();
        // dodac parsowanie xml - bo caly xml nie pojawi sie w przegladace
        pars.setXmlInputString(out);
        resp= pars.parseAndCreateRespone();
                System.out.println("response :"+ resp.getUser() );

        
        model.addAttribute("msg", " " + out + " ");
        model.addAttribute("user", resp.getUser());
        System.out.println("dsafsfdsfsdfsfsdfsdf"+ out );
        return ("delicje");
    }
    
}


