package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] banknotes =  {1,  3, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
        int[] quantities = {10, 5, 5, 3,  2,  1,   2,   3,   3,    2,    0,    2};
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите желаемую сумму: ");
        int userInPut = scanner.nextInt();
        int totalAvilable = 0;
        int count = 0;
        int sum = userInPut;
        for (int i = 0; i < banknotes.length - 1; i++) {
            totalAvilable = totalAvilable + (banknotes[i] * quantities[i]);
        }

        if (totalAvilable < userInPut) {
            System.out.println("Недостаточно средств в банкомате, запрашиваемая сумма не может быть выдана " + totalAvilable);
        } else {
            for (int i = banknotes.length - 1; i >= 0; i--) {
                if (userInPut >= banknotes[i] && quantities[i] > 0) {
                    count = userInPut / banknotes[i];
                    if (count < quantities[i]) {
                        quantities[i] = quantities[i] - count;
                        result = result + count + " x " + banknotes[i] + " ";
                        totalAvilable = totalAvilable - (banknotes[i] * count);
                        userInPut = userInPut - (banknotes[i] * count);
                    } else {
                        result = result + quantities[i] + " x " + banknotes[i] + "  ";
                        totalAvilable = totalAvilable - (banknotes[i] * quantities[i]);
                        userInPut = userInPut - (banknotes[i] * quantities[i]);
                        quantities[i] = 0;
                    }

                }

            }
            if (userInPut == 0) {
                System.out.println("Вы получили " + result);
                System.out.println("Всего = " + sum);
            } else {
                System.out.println("Недостаточно средств в банкомате, запрашиваемая сумма не может быть выдана" );
            }
        }
    }
}
