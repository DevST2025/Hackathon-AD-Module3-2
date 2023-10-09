package exam2;

import exam1.ra.util.InputMethods;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String inputData = "";

    public static void main(String[] args) {

        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập câu\n" +
                    "2. Đảo ngược câu\n" +
                    "3. Thoát");
            System.out.print("Nhập vào  lựa chọn của bạn: ");
            byte choice = InputMethods.getByte();

            switch (choice) {
                case 1:
                    System.out.print("Nhập một câu từ bàn phím: ");
                    inputData = InputMethods.getString();
                    break;
                case 2:
                    if (inputData.isEmpty()) {
                        System.out.println("Vui lòng nhập câu trước khi đảo ngược!!!");
                    } else {
                        Stack<String> stack = new Stack<>();
                        String[] arrText = inputData.split(" ");
                        for (String text: arrText) {
                            stack.push(text);
                        }
                        String newText = "";
                        for (int i = 0; i < arrText.length; i++) {
                            newText += stack.pop() + " ";
                        }
                        System.out.println("Câu được đảo ngược là: " + newText);
                    }
                    break;
                case 3:
                    System.out.println("******************END******************");
                    sc.close();
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn 1 trong 3 option trên");
            }
        } while (true);

    }
}
