package bai2;
public class Ps {
    private int tu = 2;
    private int mau = 2;
    private int mauchung = 2;
    private int tong = 2;
    private static int sosanh = 2;
    
    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }
    public Ps(){}
    public Ps(int a , int b ){
        this.tu = a;
        this.mau = b;
    }
    public Ps(Ps a){
        this(a.tu,a.mau);
    }
    public int UCLN(int a , int b){
        while(a!=b)
        {
            if(a>b)
                a = a-b;
            else
                b= b - a;
        }
        return a;
    }
    public int BCNN(int a, int b){
        mauchung = a*b / UCLN(a,b);
        return mauchung;
    }
    public void cong(Ps b){
          tong = this.tu * b.mau + this.mau*b.tu;
          mauchung = BCNN(this.mau,b.mau);
          sosanh = UCLN(tong,mauchung);
          if( sosanh== 1)
              System.out.println(tong+"/"+mauchung);
          else
              System.out.println(tong/sosanh+"/"+mauchung/sosanh);
    }
    
    public void tru(Ps b){
          tong = this.tu * b.mau - this.mau*b.tu;
          mauchung = BCNN(this.mau,b.mau);
          sosanh = UCLN(tong,mauchung);
          if( sosanh == 1)
              System.out.println(tong+"/"+mauchung);
          else
              System.out.println(tong/sosanh+"/"+mauchung/sosanh);
    }
    
    public void nhan(Ps b){
          this.tu = this.tu*b.tu;
          this.mau = this.mau*b.mau;
          sosanh = UCLN(this.tu,this.mau);
          if( sosanh == 1)
              System.out.println(this.tu+"/"+this.mau);
          else
              System.out.println(this.tu/sosanh+"/"+this.mau/sosanh);
    }
    
    public void chia(Ps b){
          this.tu = this.tu*b.mau;
          this.mau = this.mau*b.tu;
          sosanh = UCLN(this.tu,this.mau);
          if( sosanh == 1)
              System.out.println(this.tu+"/"+this.mau);
          else
              System.out.println(this.tu/sosanh+"/"+this.mau/sosanh);
    }
    
    public boolean equals(Object obj){
        if(obj instanceof Ps)
        {
            Ps other = (Ps) obj;
            sosanh = this.mau / this.tu;
            mauchung = other.mau/other.tu; 
            return sosanh == mauchung;
        }
        else 
        {
            return false;
        }
    }
}
