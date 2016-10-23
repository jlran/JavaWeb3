package com.github.jlran.dbutil;

public class Demo01 {
	public static void sum(int ...num){
		int total = 0;
		for(int i = 0 ; i < num.length; i++){
			total += num[i];
		}
		System.out.println(total);
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		sum(a);
		
		sum(1,2,1,4,5,6,7);
	}
}
