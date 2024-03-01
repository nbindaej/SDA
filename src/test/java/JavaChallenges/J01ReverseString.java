package JavaChallenges;

import java.util.Scanner;

public class J01ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any text to be reversed : ");
        String realText = scanner.nextLine();
        String reversedText = ReverseString(realText);
        System.out.println("Reversed Text = " + reversedText);
    }
    public static String ReverseString(String str){
        char[] ArrayToReverse = str.toCharArray();
        String text="";
        for (int i=ArrayToReverse.length-1; i>=0 ; i--){
            text += ArrayToReverse[i];
        }
        return text;
    }
}
