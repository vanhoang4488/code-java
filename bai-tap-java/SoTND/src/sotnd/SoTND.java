/*
 * Bài 8. Một số được gọi là số thuận nghịch độc nếu ta đọc từ trái sang phải hay từ phải sang trái số đó ta vẫn nhận được một số giống nhau. 
    Hãy liệt kê tất cả các số thuận nghịch độc có sáu chữ số (Ví dụ số: 558855)
 */
package sotnd;

/**
 *
 * @author ABC
 */
public class SoTND {

    private int daoSo(int n){
      int m = 0;
      int i = 5;
      while(i >=  0){
          m += ( Math.pow(10, i) * (n % 10) );
          n /= 10;
          i--;
      }
      return m;  
    }
    
    private void cacSoTND(){
        System.out.print("Cac so thuan nghich dao co 6 chu so la: ");
        for(int i = 100000; i < 999999; i++){
            if(daoSo(i) == i) System.out.print(i + " ");
        }
    }
    
    public static void main(String[] args) {
        SoTND tnd = new SoTND();
        tnd.cacSoTND();
    }
    
}
