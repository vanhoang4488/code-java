package container;

import annotation.Autowired;
import annotation.Service;
import base.Animal;

/**
 * B3: Tự động gán đối tượng vào chuồng nuôi
 */
@Service
public class AnimalBarn3 {
    @Autowired
    private Animal animal;
    public void nameAnimal() {
        System.out.println(animal.toString());
    }
}
