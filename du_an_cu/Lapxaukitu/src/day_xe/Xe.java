package day_xe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Xe {
	
	private int len;
	private Scanner sc = new Scanner(System.in);
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private ArrayList<Integer> listxe_qua = new ArrayList<Integer>();
    
	public Xe() {
		init();
	}
	
	public void init() {
		len = sc.nextInt();
		sc.nextLine();
		for(int i=0; i< len; i++) {
			int soXe = sc.nextInt();
			list.add(soXe);
		}
	}
	
	private int viTriMax() {
		System.out.println(list.get(0));
		int max = list.get(0);
		int vitri = 0;
		for(int i=0; i< list.size(); i++) {
			if(max < list.get(i)) {
				max = list.get(i);
				vitri = i;
			}	
		}
		return vitri;
	}
	
	private int xuli_Xe() {
		int vitri = viTriMax();
		System.out.println(vitri);
		for(int i = listxe_qua.size(); i < vitri; i++) {
			listxe_qua.add(list.get(i));
		}
		ArrayList<Integer> bs = new ArrayList<Integer>(listxe_qua);
		Collections.sort(bs);
		for(int i = 0; i< bs.size(); i++) {
			System.out.println(bs.get(i));
		}
		System.out.println("-----------------");
		for(int i = 0; i< bs.size(); i++) {
			if(!listxe_qua.get(i).equals(bs.get(i)))
				return 0;
		}
//		if(list.get(list.size() - 1) == (listxe_qua.get(listxe_qua.size() -1) + 1))
//				return 2;
		if(list.size() == 0)
			return 0;
		list.remove(vitri);
		return 1;				
	}
	
	public void inRa() {
		while(true) {
			int xet = xuli_Xe();
			if(xet == 0) {
				System.out.println("No");
				break;
			}
			if(xet == 2) {
				System.out.println("Yes");
				break;
			}
		}
	}
	public void in() {
		for(int i=0; i<len; i++) {
			System.out.println(list.get(i));
		}
	}
}
