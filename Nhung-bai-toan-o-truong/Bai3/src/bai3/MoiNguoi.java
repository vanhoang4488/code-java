package bai3;


public class MoiNguoi {
    private String name;
    private String age;
    private String sex;
    
    private String ngay;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    public void introduce(){
        System.out.println("So yeu li lich: "+name+" "+age+" "+sex+" ");
    }
    
    public void acTion(String n){
           switch(n){
               case "nghi":
                   System.out.println("ngu ngay");
                   break;
               case "hoc":
                   System.out.println("Di hoc");
                   break;
            }
    }
    
}
class A extends MoiNguoi{};
class B extends MoiNguoi{}
class C extends MoiNguoi{}
class D extends MoiNguoi{}
class  E extends MoiNguoi{}
class F extends MoiNguoi{}  
class G extends MoiNguoi{}
class H extends MoiNguoi{
    public void acTion(String n){
           switch(n){
               case "nghi":
                   System.out.println("ve que");
                   break;
               default:
                   System.out.println("Di lam");
                   break;
            }
    }
     
}
class T extends MoiNguoi{
    public void acTion(String n){
           switch(n){
               case "nghi":
                   System.out.println("Nghi ngoi");
                   break;
               default:
                   System.out.println("Di lam");
                   break;
            }
    }
     
}
class P extends MoiNguoi{
    public void acTion(String n){
           switch(n){
               case "nghi":
                   System.out.println("Di choi");
                   break;
               case "hoc":
                   System.out.println("Di hoc");
                   break;
            }
    }
     
}

