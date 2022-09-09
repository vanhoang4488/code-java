/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedemo.services;

import basedemo.Inject;
import basedemo.Service;
import basedemo.ServiceA;
import basedemo.ServiceB;

/**
 *
 * @author hoang
 */
@Service
public class ServiceBImpl implements ServiceB{
    
    @Inject
    private ServiceA serviceA;
    
    @Override
    public ServiceA getServiceA(){
        return serviceA;
    }
    
    @Override
    public void setServiceA(final ServiceA serviceA){
        this.serviceA = serviceA;
    }
    
    public String jobB(){
        return "jobB()";
    }
}
