import annotation.Autowired;
import annotation.Bean;
import annotation.Service;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Objects;

public class DependencyInjectionContext {

    private HashMap<String, Object> store;

    public DependencyInjectionContext() throws ClassNotFoundException,
            NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.store = new HashMap<>();
        this.init();
    }

    public void init() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.scanDirectory("src");
    }

    // duyệt thư mục
    public void scanDirectory (String dirName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File dir = new File(dirName);
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                this.scanDirectory(file.getPath());
            }
            else {
                String fileName = file.getPath()
                        .replace(File.separator, ".")
                        .substring(4, file.getPath().length() - 5);
                Class<?> clazz = Class.forName(fileName);
                if (clazz.isAnnotationPresent(Service.class)) {
                    Constructor<?> constructor = clazz.getConstructor();
                    Object object = constructor.newInstance();
                    this.store.put(clazz.getSimpleName(), object);
                }
                else if (clazz.isAnnotationPresent(Bean.class)) {
                    Constructor<?> constructor = clazz.getConstructor();
                    Object object = constructor.newInstance();
                    this.store.put(this.getSuperClassName(clazz), object);
                }
            }
        }
    }

    public HashMap<String, Object> getStore() {
        return this.store;
    }

    public Object getDependency (String name) throws IllegalAccessException {
        Object dependency = this.store.get(name);
        if (Objects.nonNull(dependency)) {
            Class<?> clazz = dependency.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    field.setAccessible(true);
                    Object inject = this.store.get(field.getType().getSimpleName());
                    if (Objects.nonNull(inject)) {
                        field.set(dependency, inject);
                    }
                }
            }
        }
        return dependency;
    }

    public String getSuperClassName (Class<?> clazz) {
        Class<?> superClazz = clazz.getSuperclass();
        if (!superClazz.isAssignableFrom(Object.class)) {
            this.getSuperClassName(superClazz);
        }
        return superClazz.getSimpleName();
    }

    @Override
    public String toString() {
        return this.store.toString();
    }
}
