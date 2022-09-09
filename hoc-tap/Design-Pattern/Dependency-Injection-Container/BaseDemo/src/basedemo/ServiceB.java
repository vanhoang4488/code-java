/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedemo;

/**
 *
 * @author hoang
 */
public interface ServiceB {
    
    public ServiceA getServiceA();
    
    public void setServiceA(final ServiceA serviceA);
    
    public String jobB();
}
