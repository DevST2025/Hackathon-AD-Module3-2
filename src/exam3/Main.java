package exam3;

import exam1.ra.util.InputMethods;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static PriorityQueue<String> priorityQueue = new PriorityQueue<>();
    public static void main(String[] args) {
        do {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập tên phụ huynh nộp hồ sơ\n" +
                    "2. Phụ huynh tiếp theo\n" +
                    "3. Thoát");
            System.out.print("Nhập vào  lựa chọn của bạn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên phụ huynh nộp hồ sơ: ");
                    String inputData = InputMethods.getString();
                    priorityQueue.offer(inputData);
                    break;
                case 2:
                    System.out.println(priorityQueue);
                    String firstName = priorityQueue.poll();
                    System.out.println(firstName);
                    System.out.println(priorityQueue);

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
