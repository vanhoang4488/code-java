/*
 * Đề bài: Trong folder nguồn.
 */
package romancovertingprogram;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class RomanCovertingProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String roman = scan.next();
        
        boolean check = true;
        int maxValue_now = 1000;
        int countV = 0;
        int countL = 0;
        int countD = 0;
        
        int countI = 0;
        int countX = 0;
        int countC = 0;
        int countM = 0;
        
        for(int i = 0; i < roman.length(); i++){
            String s = Character.toString(roman.charAt(i));
            if(!s.equals("I") && !s.equals("V") && !s.equals("X") && !s.equals("L") && !s.equals("C")&& !s.equals("D") && !s.equals("M")) {
               
                check = false;
                break;
            }
            
            switch(s) {
                case "I":
                    if(i < roman.length() - 1){
                        String s2 = Character.toString(roman.charAt(i + 1));
                        if(!s2.equals("V") && !s2.equals("X")){
                            if(maxValue_now > 1) maxValue_now = 1;
                            countI++;
                        }
                    }else {
                        if(maxValue_now > 1) maxValue_now = 1;
                        countI++;
                    }
                    
                    if(countI > 3) check = false;
                    
                    break;
                case "V":
                    if(maxValue_now > 5) maxValue_now = 5;
                    else if(maxValue_now < 5) check = false;
                    countV++;
                    if(countV > 1) check = false;
                    break;
                case "X":
                    if(i < roman.length() - 1){
                        String s2 = Character.toString(roman.charAt(i + 1));
                        if(!s2.equals("L") && !s2.equals("C")){
                            if(maxValue_now > 10) maxValue_now = 10;
                            else if(maxValue_now < 10) check = false;
                            countX++;
                        }
                    }else {
                        if(maxValue_now > 10) maxValue_now = 10;
                        else if(maxValue_now < 10) check = false;
                        countX++;
                    }
                    
                    if(countX > 3) check = false;
                    
                    break;
                case "L":
                    if(maxValue_now > 50) maxValue_now = 50;
                    else if(maxValue_now < 50) check = false;
                    countL++;
                    if(countL > 1) check = false;
                    break;
                case "C":
                    if(i < roman.length() - 1){
                        String s2 = Character.toString(roman.charAt(i + 1));
                        if(!s2.equals("D") && !s2.equals("M")){
                            if(maxValue_now > 100) maxValue_now = 100;
                            else if(maxValue_now < 100) check = false;
                            countC++;
                        }
                    }else {
                        if(maxValue_now > 100) maxValue_now = 100;
                        else if(maxValue_now < 100) check = false;
                        countC++;
                    }
                    
                    if(countC > 3) check = false;
                    break;
                case "D":
                    if(maxValue_now > 500) maxValue_now = 500;
                    else if(maxValue_now < 500) check = false;
                    countD++;
                    if(countD > 1) check = false;
                    break;   
                case "M":
                    countM++;
                    if(countM > 3) check = false;
                    if(maxValue_now < 1000) check = false;
                    break;
                    
            }
            
            if(!check) break;
         }
       
        if(!check) System.out.println("Số Roman không thỏa mãn!");
        else {
            int i = 0;
            int sum = 0;
            
            while(i < roman.length()){
                String s = Character.toString(roman.charAt(i));
                
                switch(s){
                    case "V":
                        sum += 5;
                        i++;
                        break;
                    case "L":
                        sum += 50;
                        i++;
                        break;
                    case "D":
                        sum += 500;
                        i++;
                        break;
                    case "M":
                        sum += 1000;
                        i++;
                        break;
                }
                
                if(s.equals("I")){
                    if(i < roman.length() - 1){
                        String s2 = Character.toString(roman.charAt(i + 1));
                        if(s2.equals("V")){
                            sum += 4;
                            i += 2;
                        }else if(s2.equals("X")){
                            sum += 9;
                            i += 2;
                        }else if(s2.equals("I")){
                            sum += 1;
                            i++;
                        }else {
                            System.out.println("số Roman không thỏa mãn!");
                            break;
                        }
                         
                    }else{
                        sum += 1;
                        i++;
                    }
                }
                
                if(s.equals("X")){
                    if(i < roman.length() - 1){
                        String s2 = Character.toString(roman.charAt(i + 1));
                        if(s2.equals("L")){
                            sum += 40;
                            i += 2;
                        }else if(s2.equals("C")){
                            sum += 90;
                            i += 2;
                        }else if(s2.equals("I") || s2.equals("V") || s2.equals("X")){
                            sum += 10;
                            i++;
                        }else {
                            System.out.println("số Roman không thỏa mãn!");
                            break;
                        }
                         
                    }else{
                        sum += 10;
                        i++;
                    }
                }
                
                if(s.equals("C")){
                    if(i < roman.length() - 1){
                        String s2 = Character.toString(roman.charAt(i + 1));
                        if(s2.equals("D")){
                            sum += 400;
                            i += 2;
                        }else if(s2.equals("M")){
                            sum += 900;
                            i += 2;
                        }else if(s2.equals("I") || s2.equals("V") || s2.equals("X") || s2.equals("L") || s2.equals("C")){
                            sum += 100;
                            i++;
                        }else {
                            System.out.println("số Roman không thỏa mãn!");
                            break;
                        }
                         
                    }else{
                        sum += 100;
                        i++;
                    }
                }
                    
            }
            
            if(i == roman.length()) System.out.printf("Số Roman sang số thập phân là: %d\n", sum);
            
        }
        
    }
    
}
