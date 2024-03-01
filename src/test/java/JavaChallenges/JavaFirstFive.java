package JavaChallenges;

import java.util.Scanner;

public class JavaFirstFive {
    public static void main(String[] args) {
        //1. Write a Java Program that reverses a string
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any text to be reversed : ");
        String realText = scanner.nextLine();
        String reversedText = ReverseString(realText);
        System.out.println("Reversed Text = " + reversedText);

        //2. Write a Java Program to swap two numbers
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        Swap(num1,num2);

        //3. Write a Java Program that prints fibonacci number due to given integer (11235811...)
        System.out.print("Enter the maximum Fibonacci number: ");
        int maxNumber = scanner.nextInt();
        Fibon(maxNumber);

        //4. Write a Java Program that checks whether given integer is Prime or not
        System.out.print("Enter a number: ");
        int Num = scanner.nextInt();
        if(isPrime(Num)) {
            System.out.println(Num + " is prime");
        }
        else{
            System.out.println(Num + " is not prime ");
        }

        //5. Write a Java Program that takes an array and returns the difference between the biggest and the smallest numbers.
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the numbers of the array:");
        for (int i=0; i<size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("The difference is "+Difference(array));


    }

    //1. Method to reverses a string
    public static String ReverseString(String str){
        char[] ArrayToReverse = str.toCharArray();
        String text="";
        for (int i=ArrayToReverse.length-1; i>=0 ; i--){
            text += ArrayToReverse[i];
        }
        return text;
    }

    //2. Method to swap two numbers
    public static void Swap(int num1,int num2){
        int temp=num1;
        num1=num2;
        num2=temp;
        System.out.println("After swapping:");
        System.out.println("First number: " + num1);
        System.out.println("Second number: " + num2);
    }

    //3. Method to print fibonacci number
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

    //4. Method to checks whether given integer is Prime or not
    static  boolean isPrime(int num) {
        if(num<=1) {
            return false;}

        for(int i=2;i<=num/2;i++) {
            if((num%i)==0)
                return  false;}
        return true;
    }

    //5.
    public static int Difference(int[] array){
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i]; }

            if (array[i] > max) {
                max = array[i];}
        }
        return max-min;
    }




}
