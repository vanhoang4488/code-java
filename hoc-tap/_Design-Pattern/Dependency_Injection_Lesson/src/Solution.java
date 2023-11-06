import annotation.Autowired;
import annotation.Bean;
import annotation.Service;
import base.Animal;
import base.Cat;
import container.AnimalBarn1;
import container.AnimalBarn2;
import container.AnimalBarn3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Ôn tập dependency injection
 * B1. Thiết kế gán cứng đối tượng trong biến thực thể của đối tượng khác.
 * B2. Tạo đối tượng vật nuôi trong hàm main và gán vào chuồng nuôi
 * B3. Tự động tạo đối tượng khi khởi tạo chương trình gán vật nuôi vào chuồng nuôi
 */

/**
 * Lưu ý: Ví dụ này tuy đúng cơ chế của dependency inject nhưng sai đối tượng bị quản lý thì sai
 * Các dependency không bao giờ là cấu trúc dữ liệu. Ở Ví dụ này là: Cat, Dog, Animal
 * mà là các lớp chứa các phương thức để xử lý dữ liệu.
 * => Đây mới là nhu cầu để xây dựng design pattern này.
 */
public class Solution {
    public static void main(String[] args){
        // B1:
//        AnimalBarn1 animalBarn1 = new AnimalBarn1();
//        animalBarn1.nameAnimal();
        // B2:
//        Animal animal = new Cat();
//        AnimalBarn2 animalBarn2 = new AnimalBarn2();
//        Class<AnimalBarn2> animalBarn2Class = AnimalBarn2.class;
//        Field animalField = null;
//        try {
//            animalField = animalBarn2Class.getDeclaredField("animal");
//            animalField.setAccessible(true);
//            animalField.set(animalBarn2, animal);
//            Method nameAnimalMethod = animalBarn2Class.getMethod("nameAnimal");
//            nameAnimalMethod.invoke(animalBarn2);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
        // B3:
        System.out.println("Start dependency injection ...");
        try {
            DependencyInjectionContext context = new DependencyInjectionContext();
            System.out.printf("dependency store: %s\n", context.toString());
            AnimalBarn3 animalBarn3 = (AnimalBarn3) context.getDependency(AnimalBarn3.class.getSimpleName());
            if (animalBarn3 != null) {
                animalBarn3.nameAnimal();
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}