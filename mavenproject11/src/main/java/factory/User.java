/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author macbookair
 */
public class User {
    
}
// Файл: User.java
package model;

import java.util.UUID; // Импорт класса для генерации UUID

/**
 * Класс пользователя с основными полями и методом обработки событий
 */
public class User {
    // Приватные final поля для обеспечения иммутабельности
    private final UUID id;           // Уникальный идентификатор пользователя
    private final String name;       // Имя пользователя
    private final String email;      // Email пользователя
    private final UserType userType; // Тип пользователя (REGULAR или PREMIUM)

    // Конструктор класса
    public User(UUID id, String name, String email, UserType userType) {
        this.id = id;               // Инициализация поля id
        this.name = name;           // Инициализация поля name
        this.email = email;         // Инициализация поля email
        this.userType = userType;   // Инициализация поля userType
    }

    // Геттер для поля id
    public UUID getId() { return id; }
    
    // Геттер для поля name
    public String getName() { return name; }
    
    // Геттер для поля email
    public String getEmail() { return email; }
    
    // Геттер для поля userType
    public UserType getUserType() { return userType; }

    /**
     * Метод обработки события для PREMIUM пользователей
     * Выводит информацию в формате: имя | email
     */
    public void handlePremiumEvent() {
        // Проверяем, является ли пользователь PREMIUM
        if (userType == UserType.PREMIUM) {
            // Выводим информацию о пользователе
            System.out.println(name + " | " + email);
        }
    }

    /**
     * Переопределенный метод toString для красивого вывода информации
     * @return строка в формате: имя | email | тип_пользователя
     */
    @Override
    public String toString() {
        return name + " | " + email + " | " + userType;
    }
}
