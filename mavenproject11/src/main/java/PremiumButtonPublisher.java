/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbookair
 */
public class PremiumButtonPublisher {
    
}
// Файл: PremiumButtonPublisher.java
package publisher;

import javax.swing.JButton; // Импорт класса JButton

/**
 * Специализированная кнопка, выступающая в роли издателя событий
 * Наследуется от JButton и содержит механизм публикации событий
 */
public class PremiumButtonPublisher extends JButton {
    // Внутренний издатель событий
    private final EventPublisher publisher = new EventPublisher();

    /**
     * Конструктор кнопки
     * @param text текст кнопки
     */
    public PremiumButtonPublisher(String text) {
        super(text); // Вызов конструктора родительского класса
    }

    /**
     * Метод для получения издателя событий
     * @return объект EventPublisher
     */
    public EventPublisher getPublisher() {
        return publisher; // Возврат ссылки на издателя
    }
}