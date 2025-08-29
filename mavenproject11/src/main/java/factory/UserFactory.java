/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author macbookair
 */
public class UserFactory {
    
}
// Файл: UserFactory.java
package factory;

import model.User;       // Импорт класса User
import model.UserType;   // Импорт enum UserType
import com.github.javafaker.Faker; // Импорт библиотеки Faker
import java.util.UUID;   // Импорт класса UUID
import java.util.Random; // Импорт класса Random

/**
 * Фабрика для создания пользователей
 * Реализует паттерн "Фабричный метод"
 */
public class UserFactory {
    // Статический экземпляр Faker для генерации случайных данных
    private static final Faker faker = new Faker();
    
    // Статический экземпляр Random для случайного выбора типа пользователя
    private static final Random random = new Random();

    /**
     * Фабричный метод для создания одного пользователя
     * @return новый объект User со случайными данными
     */
    public static User createUser() {
        // Генерация уникального идентификатора
        UUID id = UUID.randomUUID();
        
        // Генерация случайного имени с помощью Faker
        String name = faker.name().fullName();
        
        // Генерация случайного email с помощью Faker
        String email = faker.internet().emailAddress();
        
        // Случайный выбор типа пользователя (50% вероятность для каждого типа)
        UserType userType = random.nextBoolean() ? UserType.PREMIUM : UserType.REGULAR;

        // Создание и возврат нового объекта User
        return new User(id, name, email, userType);
    }

    /**
     * Метод для создания нескольких пользователей
     * @param count количество пользователей для создания
     * @return массив объектов User
     */
    public static User[] createUsers(int count) {
        // Создание массива указанного размера
        User[] users = new User[count];
        
        // Заполнение массива пользователями
        for (int i = 0; i < count; i++) {
            users[i] = createUser(); // Создание каждого пользователя
        }
        
        return users; // Возврат заполненного массива
    }
}