package lab6;

import lab6.commands.Printer;
import lab6.controllers.MyController;
import lab6.interfaces.View;
import lab6.models.MyDate;
import lab6.models.MyTime;
import lab6.models.Watch;

import lab6.views.ViewDeath;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// за допомогою цієї анотації вказуємо, що клас є конфігурацією (контекстом)
@Configuration
public class SecondConfig {


    // В цій конфігурації прописані такі біни - розумні сінглтон-функції-об'єкти, які створює Спрінг.
    // Розумні, бо через рефлексію знаходять інші функції, де ці о'бєкти потрібні

    // Створюємо принтер за допомогою контролера.
    // Контролер,тобто параметр, АВТОМАТИЧНО знаходиться Спрінгом у цьому контексті (береться з метобу, що знаходиться нище)
    // Принтер створений для виведення інформації з контролеру.
    // Виводимо дані через прінтер в самому контексті, тож потрібно ЛИШЕ об'єкт контексту,
    // аби прінтер запрацював

    @Bean
    Printer getPrinter(MyController controller) {
        Printer printer = new Printer(controller);
        printer.Hello();
        printer.outDate();
        return printer;
    }

    // Створюємо бін котролеру, що складається з моделі Watch i виду View.
    // Цей бін запихається у функцію, що потребує цей тип даних (дивись функцію вище)

    @Bean
    MyController getController(Watch watch, View vb ) {
        return new MyController(vb, watch);
    }

    // Створюємо бін, що вертає ViewBirth.
    @Bean
    View getView() {
        return new ViewDeath();
    }

    // Створюємо бін, що вертає Watch.
    // Будуємо цей об'єкт, використовуючи патерн Builder ( .DateBuilder().setDay(12).setMonth(1).setYear(2199).build();)

    @Bean
    Watch getWatch() throws Exception {
        return new MyDate.DateBuilder().setDay(12).setMonth(1).setYear(2199).build();
    }

}
