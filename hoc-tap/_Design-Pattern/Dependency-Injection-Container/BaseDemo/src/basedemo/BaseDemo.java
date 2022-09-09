/*
 * thiết kế một ví dụ cơ bản để hiều thực tế bên trong dependency inject container hoạt động như thế nào!
 */
package basedemo;

import basedemo.services.ServiceBImpl;
import basedemo.services.ServiceAImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author hoang
 */
public class BaseDemo {

   
    public static void main(String[] args) throws Exception{
        DIContext context = getDIContext();
        ServiceA serviceA = context.getServiceInstance(ServiceAImpl.class);
        ServiceB serviceB = context.getServiceInstance(ServiceBImpl.class); 
        System.out.println(serviceA.jobA());
        System.out.println(serviceB.jobB());
    }
    
    public static DIContext getDIContext() throws Exception{
        String servicePath = ServiceAImpl.class.getPackage().getName();
        Set<Class<?>> serviceClasses = new ClassPathScanner().autoServiceFile(servicePath);
        return new DIContext(serviceClasses);
    }
    
    public static ServiceA createServiceA(Set<Class<?>> serviceClasses) throws Exception{
        
        //bước 1: Tạo mỗi thể hiện cho mỗi service class.
        Set<Object> serviceInstances = new HashSet<>();
        for(Class serviceClass : serviceClasses){
            Constructor<?> constructor = serviceClass.getConstructor();
            constructor.setAccessible(true);
            serviceInstances.add(constructor.newInstance());
        }
        
        //gán giá trị cho các trường tham chiếu của từng đối tượng.
        for(Object instance : serviceInstances){
            
            for(Field field : instance.getClass().getDeclaredFields()){
                
                if(!field.isAnnotationPresent(Inject.class)) continue;
                
                Class<?> fieldType = field.getType();
                
                field.setAccessible(true);
                //gán giá trị cho trường nếu nó thuộc kiểu tham chiếu có đăng ký trong serviceClasses
                for(Object fieldInstance : serviceInstances){
                    if(fieldType.isInstance(fieldInstance)){
                        field.set(instance, fieldInstance);
                    }
                }
            }
        }
        
        //trả về đối tượng thuộc lớp ServiceAImpl.
        for(Object instance : serviceInstances){
            if(instance instanceof ServiceA) return (ServiceA) instance;
        }
        
        //nếu lớp ServiceAImpl chưa đăng ký trả về null
        return null;
    }
}
