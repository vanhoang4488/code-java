
package container;

import base.Animal;
import base.Cat;

/**
 * khai báo cứng: chuồng nuôi có đối tượng vật nuôi nào
 */
public class AnimalBarn1 {

    private Animal animal = new Cat();

    public void nameAnimal () {
        System.out.println("Animal in animal barn is: " + animal.toString());
    }
}
