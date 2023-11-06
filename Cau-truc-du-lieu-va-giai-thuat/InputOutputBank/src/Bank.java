import java.util.Random;

public class Bank {

    private Random generator = new Random();
    public void createCard (Custome custome) {
        int serialPin = generator.nextInt(10);
        Card card = new Card(serialPin);
        custome.setCard(card);
    }
}
