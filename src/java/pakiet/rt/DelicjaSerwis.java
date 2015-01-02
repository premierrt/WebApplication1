/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pakiet.rt;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import org.netbeans.saas.RestResponse;
import org.netbeans.saas.delicious.DeliciousBookmarkingService;

/**
 *
 * @author rafal
 */
public class DelicjaSerwis {
    
    public static String getSimpleResponeFromDelicje () throws IOException, JAXBException{
        String tag = null;
                String dt = null;
                String url = "";
                String hashes = null;
                String meta = null;
              

        RestResponse result = DeliciousBookmarkingService.getPosts( tag, dt, url, hashes, meta);
                if (result.getDataAsObject(delicious.bookmarkingservice.deliciousresponse.Posts.class) instanceof delicious.bookmarkingservice.deliciousresponse.Posts) {
                    delicious.bookmarkingservice.deliciousresponse.Posts resultObj = result.getDataAsObject(delicious.bookmarkingservice.deliciousresponse.Posts.class);
                }
                System.out.println(result.getDataAsString());
                
                return result.getDataAsString();
    }
    
}
