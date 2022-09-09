package lab04;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab04 {
    public static int max(int a, int b){
        return Math.max(a, b);
    }
    
    public static int minArray(int[] a){
        if(a.length == 0) return 1;
        int min = a[0];
        for(int i = 0; i< a.length; i++){
            min = Math.min(a[i],min);
        }
        return min;
    }
    
    public static String  BMI(double weigh, double high){
        double bmi = weigh / ( high * high);
        if(bmi < 18.5)
            return "Thieu can";
        if(bmi >= 18.5 && bmi < 23)
            return "Binh thuong";
        if(bmi >=23 && bmi <=24.99)
            return "Thua can";
        return "Beo phi";
    }
    
    
}
