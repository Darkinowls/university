package lab6;


import lab6.commands.Printer;
import lab6.controllers.MyController;
import lab6.interfaces.View;
import lab6.models.Watch;
import lab6.models.MyDate;
import lab6.models.MyTime;
import lab6.views.ViewBirth;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// за допомогою цієї анотації вказуємо, що клас є конфігурацією (контекстом)
@Configuration
public class Config {

    // В цій конфігурації прописані такі біни - розумні сінглтон-функції-об'єкти, які створює Спрінг
    // Розумні, бо через рефлексію знаходять інші функції, де ці о'бєкти потрібні

    // Створюємо принтер за допомогою контролера.
    // Контролер,тобто параметр, АВТОМАТИЧНО знаходиться Спрінгом у цьому контексті (береться з метобу, що знаходиться нище)
    // Принтер створений для виведення інформації з контролеру.
    @Bean
    Printer getPrinter(MyController controller) {
        return new Printer(controller);
    }

    // Створюємо бін котролеру, що складається з моделі Watch i виду View.
    // Цей бін запихається у функцію, що потребує цей тип даних (дивись функцію вище)
    @Bean
    MyController getController(Watch watch, View vb) {
        return new MyController(vb, watch);
    }

    // Створюємо бін, що вертає ViewBirth.
    // Він розпізнається Спрінгом як клас View, оскільки View батько ViewBirth
    @Bean
    ViewBirth getView() {
        return new ViewBirth();
    }


    // Створюємо бін, що вертає Watch.
    // Будуємо цей об'єкт використовуючи 2 патерни : Builder ( .DateBuilder() ) та Сhain of resposibility ( .add )
    // ЗАМІТКА об'єкт MyTime - це сінглтон. тож при використані декількох сінглтонів у Сhain of resposibility виникає
    // безкінечний цикл, оскільки об'єкт посилається сам на себе безкінечно разів.
    @Bean
    Watch getWatch() throws Exception {
        Watch w = new MyDate.DateBuilder().setDay(10).setMonth(4).setYear(2000).build();
        w.add(new MyDate.DateBuilder().setDay(15).setMonth(3).setYear(2020).build());
        w.add(new MyDate.DateBuilder().setDay(20).setMonth(8).setYear(1600).build());
        w.add(MyTime.getInstance(19, 10));

        return w;
    }
}
