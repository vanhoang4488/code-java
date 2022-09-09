package lab05;

abstract public class HoaQua {
    private double giaban;
    private String nguongoc;
    private String date;
    private int amount;
    private String name;

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }
    
    protected void setGiaBan(double a){
        giaban = a;
    }
    protected double getGiaBan (){
        return giaban;
    }

    protected String getNguongoc() {
        return nguongoc;
    }

    protected void setNguongoc(String nguongoc) {
        this.nguongoc = nguongoc;
    }

    protected String getDate() {
        return date;
    }

    protected void setDate(String date) {
        this.date = date;
    }

    protected int getAmount() {
        return amount;
    }

    protected void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void infor (){
        System.out.println(name+" "+amount + " " + date +" " + nguongoc + " " + giaban);
    }
    public void object(int amount, String date, String nguongoc, double giaban){}
}

class QuaCam extends HoaQua {
    QuaCam() {
        setName("Qua Cam");
    }
    public void object(int amount, String date, String nguongoc, double giaban){
        setAmount(amount);
        setDate(date);
        setNguongoc(nguongoc);
        setGiaBan(giaban);
    }
}
class QuaTao extends HoaQua {
    QuaTao() {
        setName("Qua Tao");
    }
    public void object(int amount, String date, String nguongoc, double giaban){
        setAmount(amount);
        setDate(date);
        setNguongoc(nguongoc);
        setGiaBan(giaban);
    }
}
class QuaCaoPhong extends HoaQua {
    QuaCaoPhong(){
        setName("Qua Cao Phong");
    }
    public void object(int amount, String date, String nguongoc, double giaban){
        setName("Qua Cao Phong");
        setAmount(amount);
        setDate(date);
        setNguongoc(nguongoc);
        setGiaBan(giaban);
    }
}