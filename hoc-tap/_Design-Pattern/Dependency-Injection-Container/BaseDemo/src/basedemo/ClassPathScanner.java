/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedemo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author hoang
 */

//Lớp từ động tìm kiếm class chứa dependency.
//Trong ví dụ này là hai class ServiceAImpl và ServiceBImpl.
//Việc này sau sẽ được ứng dụng để tự tìm nạp các lớp Service (các lớp chứa dependency.)
//nếu không việc đăng ký thủ công các class là rất tốn thời gian. 
public class ClassPathScanner {
    
    public Set<Class<?>> autoServiceFile(String packageName) throws IOException, ClassNotFoundException{
        Set<Class<?>> serviceClasses = new HashSet<>();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replaceAll("\\.", "/");
        Enumeration<URL> resources = classLoader.getResources(path);
        
        List<File> files = new ArrayList<>();
        while(resources.hasMoreElements()){
            URL resource = resources.nextElement();
            files.add(new File(resource.getFile()));
        }
        
        for(File file : files){
            serviceClasses.addAll(findAll(file, packageName));
        }
        
        return serviceClasses;
    }
    
    private Set<Class<?>> findAll(File directory, String packageName) throws ClassNotFoundException{
     
        Set<Class<?>> files = new HashSet<>();
        if(!directory.exists()) return files;
          
        for(File file : directory.listFiles()){
            if(file.isDirectory()){
                files.addAll(findAll(file, packageName + "." + file.getName()));
            }
            else{
                Class<?> aClazz = Class.forName(packageName + "." + file.getName().substring(0, file.getName().length() - 6));
                
                if( aClazz.isAnnotationPresent(Service.class) )files.add(aClazz);
            }
        }
        
        return files;
    }
}
