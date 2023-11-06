public class Card {

    private final int serialPin;
    private int money;

    public Card (int serialPin) {
        this.serialPin = serialPin;
    }

    public int getSerialPin() {
        return this.serialPin;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public void napTien (int money) {
        this.money += money;
    }

    public void rutTien (int money) {
        this.money -= money;
    }
}
