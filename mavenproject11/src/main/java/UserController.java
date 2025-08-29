/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbookair
 */
public class UserController {
    
}
// Файл: UserController.java
package controller;

import model.User;           // Импорт класса User
import model.UserType;       // Импорт enum UserType
import factory.UserFactory;  // Импорт фабрики пользователей
import publisher.EventPublisher; // Импорт издателя событий
import javax.swing.JTextArea; // Импорт компонента текстовой области
import java.util.function.Consumer; // Импорт функционального интерфейса

/**
 * Контроллер для управления бизнес-логикой приложения
 * Связывает модель, фабрику и представление
 */
public class UserController {
    // Текущий массив пользователей
    private User[] currentUsers;
    
    // Текстовая область для вывода информации
    private final JTextArea outputArea;

    /**
     * Конструктор контроллера
     * @param outputArea текстовая область для вывода
     */
    public UserController(JTextArea outputArea) {
        this.outputArea = outputArea; // Инициализация текстовой области
    }

    /**
     * Метод создания пользователей и настройки подписок
     * @param publisher издатель событий для подписки
     */
    public void createUsers(EventPublisher publisher) {
        outputArea.setText(""); // Очистка текстовой области
        
        // Создание 5 пользователей через фабрику
        currentUsers = UserFactory.createUsers(5);

        // Обход всех созданных пользователей
        for (User user : currentUsers) {
            // Вывод информации о каждом пользователе
            outputArea.append("Создан: " + user + "\n");
            
            // Проверка типа пользователя
            if (user.getUserType() == UserType.PREMIUM) {
                // Создание лямбда-выражения для обработки события
                Consumer<Void> handler = v -> {
                    // Вывод информации о PREMIUM пользователе
                    outputArea.append(user.getName() + " | " + user.getEmail() + "\n");
                };
                // Подписка на событие
                publisher.subscribe(handler);
            }
        }
        
        // Вывод количества подписчиков
        outputArea.append("\nPREMIUM подписчиков: " + publisher.getSubscribersCount() + "\n");
    }
}