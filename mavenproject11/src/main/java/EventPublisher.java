/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbookair
 */
public class EventPublisher {
    
}
// Файл: EventPublisher.java
package publisher;

import java.util.ArrayList;     // Импорт ArrayList для хранения подписчиков
import java.util.List;          // Импорт интерфейса List
import java.util.function.Consumer; // Импорт функционального интерфейса Consumer

/**
 * Класс издателя событий
 * Реализует паттерн "Издатель-Подписчик" (Publisher-Subscriber)
 */
public class EventPublisher {
    // Список для хранения подписчиков (лямбда-выражений)
    private final List<Consumer<Void>> subscribers = new ArrayList<>();

    /**
     * Метод для подписки на события
     * @param subscriber лямбда-выражение для обработки события
     */
    public void subscribe(Consumer<Void> subscriber) {
        subscribers.add(subscriber); // Добавление подписчика в список
    }

    /**
     * Метод для отписки от событий
     * @param subscriber лямбда-выражение для удаления из подписчиков
     */
    public void unsubscribe(Consumer<Void> subscriber) {
        subscribers.remove(subscriber); // Удаление подписчика из списка
    }

    /**
     * Метод для публикации события
     * Оповещает всех подписчиков и очищает список
     */
    public void publishEvent() {
        // Создание копии списка для безопасной итерации
        List<Consumer<Void>> currentSubscribers = new ArrayList<>(subscribers);
        
        // Оповещение всех подписчиков
        for (Consumer<Void> subscriber : currentSubscribers) {
            subscriber.accept(null); // Вызов лямбда-выражения
        }
        
        subscribers.clear(); // Очистка списка подписчиков после обработки
    }

    /**
     * Метод для получения количества подписчиков
     * @return количество текущих подписчиков
     */
    public int getSubscribersCount() {
        return subscribers.size(); // Возврат размера списка
    }
}