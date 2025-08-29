/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author macbookair
 */
public class UserApp {
    
}
// Файл: UserApp.java
package view;

import controller.UserController; // Импорт контроллера
import publisher.PremiumButtonPublisher; // Импорт специализированной кнопки
import javax.swing.*; // Импорт Swing компонентов
import java.awt.*; // Импорт AWT компонентов

/**
 * Главный класс приложения с графическим интерфейсом
 * Реализует основное окно приложения
 */
public class UserApp extends JFrame {
    // Кнопка-издатель для PREMIUM событий
    private final PremiumButtonPublisher premiumButton = new PremiumButtonPublisher("Показать PREMIUM");
    
    // Текстовая область для вывода информации
    private final JTextArea outputArea = new JTextArea(10, 30);
    
    // Контроллер для управления логикой
    private final UserController controller;

    /**
     * Конструктор главного окна
     */
    public UserApp() {
        setTitle("User Management App"); // Установка заголовка окна
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Действие при закрытии
        setSize(400, 300); // Установка размеров окна
        setLocationRelativeTo(null); // Центрирование окна на экране
        
        // Инициализация контроллера с текстовой областью
        controller = new UserController(outputArea);
        
        initComponents(); // Инициализация компонентов интерфейса
    }

    /**
     * Метод инициализации компонентов интерфейса
     */
    private void initComponents() {
        // Создание основного контейнера с BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        
        // Создание панели для кнопок с FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout());
        
        // Создание кнопки для создания пользователей
        JButton createUsersButton = new JButton("Создать пользователей");
        
        // Добавление кнопок на панель
        buttonPanel.add(createUsersButton);
        buttonPanel.add(premiumButton);
        
        // Настройка текстовой области
        outputArea.setEditable(false); // Запрет редактирования
        JScrollPane scrollPane = new JScrollPane(outputArea); // Добавление прокрутки
        
        // Размещение компонентов на основной панели
        panel.add(buttonPanel, BorderLayout.NORTH); // Кнопки сверху
        panel.add(scrollPane, BorderLayout.CENTER); // Текстовая область в центре
        
        add(panel); // Добавление панели в окно
        
        // Назначение обработчиков событий для кнопок
        createUsersButton.addActionListener(e -> createUsers());
        premiumButton.addActionListener(e -> showPremiumUsers());
    }

    /**
     * Обработчик создания пользователей
     */
    private void createUsers() {
        // Вызов метода контроллера для создания пользователей
        controller.createUsers(premiumButton.getPublisher());
    }

    /**
     * Обработчик показа PREMIUM пользователей
     */
    private void showPremiumUsers() {
        // Добавление заголовка в текстовую область
        outputArea.append("\n=== PREMIUM ПОЛЬЗОВАТЕЛИ ===\n");
        
        // Публикация события для оповещения подписчиков
        premiumButton.getPublisher().publishEvent();
    }

    /**
     * Главный метод приложения
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        // Запуск в потоке обработки событий Swing
        SwingUtilities.invokeLater(() -> {
            UserApp app = new UserApp(); // Создание экземпляра приложения
            app.setVisible(true); // Отображение окна
        });
    }
}