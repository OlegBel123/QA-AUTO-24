package HW1.Zadanie1;

import java.awt.*;
import java.util.ArrayList;

///Задание 1. Написать метод, принимающий в качестве параметра массив целых чисел. И выводит на экран
// все четные числа списком, а также нечетные числа списком.
public class Class1 {
    //Создаем метод, принимающий массив целых чисел и выводящий все четные и нечетные числа
    public static void printEvenAndOddNumbers(int[] numbers) {
        System.out.println("Even numbers:");
        for (int num : numbers) {
        //цикл "for" выводит все четные числа из массива. Он использует оператор % для определения остатка
        // от деления числа на 2.
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        System.out.println("Odd numbers:");
        for (int num : numbers) {
            if (num % 2 != 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
}