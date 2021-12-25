package lab6;

import lab6.commands.Printer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Lab6Application {

    public static void main(String[] args) {

        // Створюємо контекст на основі конфігурації Config
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        //З цього контексту можемо дістати будьякі біни що там є.
        // Дістаємо бін принтера
        Printer printer = context.getBean(Printer.class);

        // Використовуємо прінтер
        printer.Hello();
        printer.outAll();

        // Створюємо контекст на основі конфігурації SecondConfig
        // Команди для виведення ВЖЕ прописані в конфігурації, тож немає сенсу ініціалізовувати об'єкт
        new AnnotationConfigApplicationContext(SecondConfig.class);

    }

}