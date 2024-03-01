package JavaChallenges;

import java.util.Scanner;

public class J05ArrayDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the numbers of the array:");
        for (int i=0; i<size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("The difference is "+Difference(array));
    }
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
