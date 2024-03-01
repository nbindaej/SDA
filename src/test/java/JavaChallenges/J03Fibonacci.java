package JavaChallenges;

import java.util.Scanner;

public class J03Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum Fibonacci number: ");
        int maxNumber = scanner.nextInt();
        Fibon(maxNumber);
    }
    public static void Fibon(int max){
        int num1=1;
        int num2=1;
        for(int i=1; i<=max; i++){
            System.out.print(num1);
            int temp = num1+num2;
            num1=num2;
            num2=temp;
        }
        System.out.print("\n");
    }
}
