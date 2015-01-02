/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pakiet.rt;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 *
 * @author rafal
 */
@Component
public class DelicjaResponseObject {
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    
    
}
