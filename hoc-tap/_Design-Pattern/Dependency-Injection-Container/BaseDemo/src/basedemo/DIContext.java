/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hoang
 */
//Để tránh lặp lại việc khởi tạo đối tượng từ class, mỗi khi có yêu cầu về đối tượng.
//Ta sẽ gán đối tượng vào biến thực thể khi khởi tạo đối tượng DIContext.
//Với mỗi lần tham chiếu yêu cầu đối tượng ta chỉ cần truy xuất Collection Set<Object> serviceInstances.
//=> Đúng vậy, với mỗi kiểu tham chiếu chỉ có một thể hiện.
public class DIContext {
    
    private Set<Object> serviceInstances = new HashSet<>();
    
    public DIContext(Collection<Class<?>> serviceClasses) throws Exception{
        //tạo 1 thể hiện của tất cả các lớp được khai báo.
        for(Class<?> serviceClass : serviceClasses){
            
            Constructor<?> constructor = serviceClass.getConstructor();
            constructor.setAccessible(true);
            Object instance = constructor.newInstance();
            this.serviceInstances.add(instance);
        }
        
        //gán các đối tượng cho các biến tham chiếu của từng thể hiện.
        for(Object instance : serviceInstances){
            for(Field field : instance.getClass().getDeclaredFields()){
                
                if(!field.isAnnotationPresent(Inject.class)) continue;
                
                Class<?> fieldType = field.getType();
                
                field.setAccessible(true);
                
                //gán giá trị cho trường nếu nó thuộc kiểu tham chiếu.
                for(Object matchPartner : serviceInstances){
                    if(fieldType.isInstance(matchPartner)) 
                        field.set(instance, matchPartner);
                }
            }
        }
    }
    
    //trả về đối tượng của Class truyển vào.
    public <T> T getServiceInstance(Class<T> serviceClass){
        for(Object serviceInstance : serviceInstances){
            
            if(serviceClass.isInstance(serviceInstance))
                return (T) serviceInstance;
        }
        return null;
    }
}
