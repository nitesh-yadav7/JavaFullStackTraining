package junitdemo;

import java.util.Arrays;

public class Operations {
    public static void main(String[] args) {
    	System.out.println("operations class");
    }
	
	public int add(int a, int b) {
        return a+b;
    }

    public int sub(int a, int b) {
        return a-b;
    }
    
    public int mul(int a, int b) {
        return a*b;
    }
    
    public int div(int a, int b) {
        return a/b;
    }
    
    public int arrayMax(int[] arr) {
    	Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}
