public class Custome {

    private Card card;

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String toString () {
        return "" + this.card.getSerialPin();
    }
}
