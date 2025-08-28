/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject11;

/**
 *
 * @author ekate
 */
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Привет, мир! ������");
        System.out.println("Сегодня: " + java.time.LocalDate.now());
        
        // Простые вычисления
        int a = 10;
        int b = 5;
        System.out.println(a + " + " + b + " = " + (a + b));
        
        // Массив
        String[] languages = {"Java", "Python", "JavaScript"};
        System.out.print("Любимые языки: ");
        for (String lang : languages) {
            System.out.print(lang + " ");
        }
    }
}