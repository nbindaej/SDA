package JavaChallenges;

import java.util.Scanner;

public class J02SwapNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        Swap(num1,num2);
    }
    public static void Swap(int num1,int num2){
        int temp=num1;
        num1=num2;
        num2=temp;
        System.out.println("After swapping:");
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
    }
}
