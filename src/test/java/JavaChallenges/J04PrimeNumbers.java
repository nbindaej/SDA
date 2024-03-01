package JavaChallenges;

import java.util.Scanner;

public class J04PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int Num = scanner.nextInt();
        if(isPrime(Num)) {
            System.out.println(Num + " is prime");
        }
        else{
            System.out.println(Num + " is not prime ");
        }
    }
    static  boolean isPrime(int num) {
        if(num<=1) {
            return false;}

        for(int i=2;i<=num/2;i++) {
            if((num%i)==0)
                return  false;}
        return true;
    }
}
