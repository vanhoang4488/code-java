package bai3;

public class Bai3 {
    public static void main(String[] args) {
        MoiNguoi[] nguoi = new MoiNguoi[10];
        nguoi[0] = new A(); nguoi[0].setName("Hoang");nguoi[0].setAge ("19");nguoi[0].setSex("Nam");
        nguoi[1] = new B();nguoi[1].setName("De");nguoi[1].setAge ("19");nguoi[1].setSex("Nam");
        nguoi[2] = new C();nguoi[2].setName("Minh");nguoi[2].setAge ("19");nguoi[2].setSex("Nam");
        nguoi[3] = new D();nguoi[3].setName("Giap");nguoi[3].setAge ("19");nguoi[3].setSex("Nam");
        nguoi[4] = new E();nguoi[4].setName("Tuan");nguoi[4].setAge ("19");nguoi[4].setSex("Nam");
        nguoi[5] = new F();nguoi[5].setName("Phuc");nguoi[5].setAge ("19");nguoi[5].setSex("Nam");
        nguoi[6] = new G();nguoi[6].setName("Con");nguoi[6].setAge ("19");nguoi[6].setSex("Nam");
        nguoi[7] = new P();nguoi[7].setName("Thang");nguoi[7].setAge ("19");nguoi[7].setSex("Nam");
        nguoi[8] = new H();nguoi[8].setName("Ngoi");nguoi[8].setAge ("42");nguoi[8].setSex("Nu");
        nguoi[9] = new T();nguoi[9].setName("Tan");nguoi[9].setAge ("48");nguoi[9].setSex("Nam");
        
        for( int i =0 ; i<10 ; i++){
            nguoi[i].introduce();
            nguoi[i].acTion("nghi");
        }
        
    }
    
}
