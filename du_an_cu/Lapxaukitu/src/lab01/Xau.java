package lab01;

import java.util.ArrayList;
import java.util.Scanner;

public class Xau {
	
	private ArrayList<String> list = new ArrayList<String>();
	private ArrayList<Integer> list_so = new ArrayList<Integer>();
	private ArrayList<String> list_xau = new ArrayList<String>();
	private Scanner sc = new Scanner(System.in);
	private int len;
	
    public Xau() {
    	init();
    }
    
    public void init() {
    	len = sc.nextInt();
    	sc.nextLine();
    	for(int i = 0; i< len; i++) {
    		String userInput = sc.nextLine();
    		list.add(userInput);
    	}
    }
    
    public void tachXau() {
    	for(int i=0; i< len; i++) {
    		String[] tmpStr = list.get(i).split(" ");
    		list_so.add(Integer.parseInt(tmpStr[1]));
    	    list_xau.add(tmpStr[2]);
    	}
    }
    
    public void xuly_Xau() {
    	for(int i=0; i< len; i++) {
    		String xau_moi = "";
    		for(int j=0; j< list_xau.get(i).length(); j++) {
    			for(int x=0; x< list_so.get(i); x++) {
    				xau_moi += list_xau.get(i).charAt(j);
    			}
    		}
    		list_xau.remove(i);
    		list_xau.add(i, xau_moi);
    	}
    }
    
    public void inXau() {
    	for(int i = 1; i<= len; i++) {
    		System.out.print(i + " ");
    	    System.out.println(list_xau.get(i-1));
    	}
    }
}
