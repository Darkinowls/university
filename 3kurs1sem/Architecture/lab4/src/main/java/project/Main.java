package project;


import project.commands.Printer;
import project.controllers.MyController;
import project.controllers.ProxyController;
import project.interfaces.Controller;
import project.models.Watch;
import project.models.MyDate;
import project.models.MyTime;
import project.views.ViewBirth;
import project.views.ViewDeath;

public class Main {

    // Реалізовані такі патерни:
    //
    // 1. MVC (За минулою лаб. роботою. Моделі в пакеті models, контролери - controllers, шаблони(види) - views)
    //
    // 2. Chain of Responsibility (абстрактний клас Watch і його наслідники MyDate, MyTime)
    //
    // 3. Proxy ( Інтерфейс Controller. Клас ProxyController, що включає клас MyController)
    //
    // 4. Command (Інтерфейс Command. Класи, що реалізують інтерфейс: HelloCommand, OutAllCommand, OutDateCommand,
    // OutTimeCommand. Виконує ці команди клас Printer)
    //
    // 5. Singleton (Клас-одинак MyTime)
    //
    // 6. Builder (Клас-будівник DateBuilder всередині класу MyTime )

    public static void main(String[] args) throws Exception {

        //Ініціалізуємо абстрактний клас, який заповнемо наслідником
        Watch myData1;

        //Будуємо об'єкт через статичний клас DateBuilder в класі MyDate (патерн Builder)
        myData1 = new MyDate.DateBuilder(2000, 3 , 14).build();

        //Ініціалізуємо сінглтон
        MyTime single = MyTime.getInstance(20, 48);
        single.setHour(12);

        //ініціалізуємо наступний об'єкт для chain of Responsibility, який є Singleton'ом
        myData1.next = single;

//        myData1.next.next = single;

        //Ініціалізуємо контролер
        Controller controller = new MyController(new ViewBirth(), myData1);

        //Ініціалізуємо принтер для виводу даних з контролеру
        Printer printer1 = new Printer(controller);

        //використовуємо команди (патерн Command)
        printer1.Hello();
        printer1.outAll();

        //встановлюємо новий вид ViewDeath
        controller.setView(new ViewDeath());

        // Контролер в принтері не треба оновлювати, оскільки ми посилаємося на єдиний об'єкт
        printer1.outAll();

        //Будуємо нові об'єкти
        Watch myData2 = new MyDate.DateBuilder().setDay(20).setMonth(4).setYear(2011).build();
        myData2.next = new MyDate.DateBuilder(2090, 6, 30).build();
        myData2.next.next = new MyDate.DateBuilder(2100, 11, 4).build();

        // Ініціалізування нового проксі контролер
        Controller proxyController = new ProxyController(myData2);
        // Ініціалізування нового принтеру для виводу даних з проксі контролера
        Printer printer2 = new Printer(proxyController);

        // Нова вюшка не буде встановлена, оскільки її блокує проксі клас.
        proxyController.setView(new ViewDeath());

        // Виводимо усі дати через патерн Command
        printer2.outDate();

    }
}
