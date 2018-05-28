/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancaonline.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author EzequielRodriguez
 */
@Named(value = "bOnlineBean")
@SessionScoped
public class bOnlineBean implements Serializable {

    /**
     * Creates a new instance of bOnlineBean
     */
    public bOnlineBean() {
    }
    
}
