/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ricardo.bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author ricardo
 */
@Named(value = "rechazoBean")
@SessionScoped
public class RechazoBean implements Serializable {

    /**
     * Creates a new instance of RechazoBean
     */
    public RechazoBean() {
    }
    
}
