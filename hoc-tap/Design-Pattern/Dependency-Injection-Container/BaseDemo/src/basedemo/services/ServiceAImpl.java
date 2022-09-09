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
public class ServiceAImpl implements ServiceA{
    
    @Inject
    private ServiceB serviceB;
    
    @Override
    public ServiceB getServiceB(){
        return serviceB;
    }
    
    @Override
    public void setServiceB(final ServiceB serviceB){
        this.serviceB = serviceB;
    }
    
    public String jobA(){
        return "jobA(" + this.serviceB.jobB() +")";
    }
}
