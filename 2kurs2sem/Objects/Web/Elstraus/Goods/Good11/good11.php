<!DOCTYPE html>
<html lang="en">

<?php

require 'Goods\head.php' ?>

<?php require 'Styles\Header\header.php' ?>

<body onload="ShowFilter()">

<div class="Title">Електромотоцикл ES-11</div>

<div class="window">

    <div class="Imgs">
        <div class="main"><img src="../../Imgs/Lending/Електроскутер ES-11.png"/></div>
        <div class="less">
            <img src="../../Imgs/Lending/Електроскутер ES-11.png"/>
            <img src="../../Imgs/Lending/Електроскутер ES-11.png"/>
            <img src="../../Imgs/Lending/Електроскутер ES-11.png"/>
            <img src="../../Imgs/Lending/Електроскутер ES-11.png"/>
        </div>
    </div>

    <div class="Desc">
        <div class="head">Оснащення моделі</div>
        <div class="text">
            <p>Максимальне навантаження: 180 кг</p>
            <p> Світлодіодні фари</p>
            <p> Сучасний корпус</p>
            <p> Переносна батарея</p>
            <p> Габаритні ліхтарі</p>
            <p> Подвійні гідравлічні дискові гальма</p>
            <p> Подвійне сидіння</p>
            <p> Сигналізація зі зворотнім зв’язком</p>
            <p> Світлодіодний монітор</p>
            <p> Гідравлічні амортизатори</p>
            <p> Розмір: 2050 * 700 * 1150 мм</p>
            <p> Гарантія 24 місяців.</p>
            <p> Безкоштовна доставка !</p>
        </div>
    </div>
</div>

<div class="MySearch">
    <div class="Buttons">
        <button id="FilterDropper" onclick="ShowFilter()" class="FilterDropper">Базова комплектація</button>
        <button id="SorterDropper" onclick="ShowSorter()" class="SorterDropper">Створити комплектацію</button>
    </div>
    <div id="FilterDropped" class="FilterDropped">
        <table>
            <tr>
                <th>Комплектація</th>
                <th>Вага</th>
                <th>Ціна</th>
            </tr>
            <tr>
                <td>Корпус + оснащення моделі</td>
                <td>94 кг</td>
                <td>29 990 ₴</td>
            </tr>
            <tr>
                <td>Акумулятори: 72 В, 20 А*год, Li</td>
                <td>10 кгг</td>
                <td>9 000 ₴</td>
            </tr>
            <tr>
                <td>Двигун потужністю 5 кВт</td>
                <td>10 кг</td>
                <td>9 000 ₴</td>
            </tr>
            <tr>
                <td>Переднє колесо: 110 / 70-17</td>
                <td>5 кг</td>
                <td>1 000 ₴</td>
            </tr>
            <tr>
                <td>Заднє колесо: 140 / 70-16</td>
                <td>5 кг</td>
                <td>1 000 ₴</td>
            </tr>
            <tr>
                <td></td>
                <th>124 кг</th>
                <th>49 990 ₴</th>
            </tr>

        </table>
        <button class="button">Замовити</button>
    </div>
    <div id="SorterDropped" class="SorterDropped">
        <table>
            <tr>
                <th>Комплектація</th>
                <th>Вага</th>
                <th>Ціна</th>
            </tr>
            <tr>
                <td>
                    <div class="choose">
                        <select name="feature1" id="Corpus">
                            <option value="Corpus">Корпус + оснащення моделі</option>
                        </select>
                        <div class="arrow">
                            <div class="l1"></div>
                            <div class="l2"></div>
                        </div>
                    </div>
                </td>
                <td>94 кг</td>
                <td>29 990 ₴</td>
            </tr>
            <tr>
                <td>
                    <div class="choose">
                        <select name="feature1" id="Accum">
                            <option value="Accum1">Акумулятори: 72 В, 20 А*год, Li</option>
                            <option value="Accum2">Акумулятори: 80 В, 20 А*год, Li</option>
                        </select>
                        <div class="arrow">
                            <div class="l1"></div>
                            <div class="l2"></div>
                        </div>
                    </div>
                </td>
                <td>10 кг</td>
                <td>9 000 ₴</td>
            </tr>
            <tr>
                <td>
                    <div class="choose">
                        <select name="feature1" id="Engine">
                            <option value="Engine1">Двигун потужністю 5 кВт</option>
                            <option value="Engine2">Двигун потужністю 6 кВт</option>
                            <option value="Engine3">Двигун потужністю 7 кВт</option>
                        </select>
                        <div class="arrow">
                            <div class="l1"></div>
                            <div class="l2"></div>
                        </div>
                    </div>
                </td>
                <td>10 кг</td>
                <td>9 000 ₴</td>
            </tr>
            <tr>
                <td>
                    <div class="choose">
                        <select name="feature1" id="frontWheel">
                            <option value="frontWheel1">Переднє колесо: 110 / 70-17</option>
                            <option value="frontWheel2">Переднє колесо: 100 / 70-17</option>
                        </select>
                        <div class="arrow">
                            <div class="l1"></div>
                            <div class="l2"></div>
                        </div>
                    </div>
                </td>
                <td>5 кг</td>
                <td>1 000 ₴</td>
            </tr>
            <tr>
                <td>
                    <div class="choose">
                        <select name="feature1" id="backWheel">
                            <option value="backWheel1">Заднє колесо: 140 / 70-16</option>
                            <option value="backWheel2">Заднє колесо: 120 / 70-16</option>
                        </select>
                        <div class="arrow">
                            <div class="l1"></div>
                            <div class="l2"></div>
                        </div>
                    </div>
                </td>
                <td>5 кг</td>
                <td>1 000 ₴</td>
            </tr>
            <tr>
                <td></td>
                <th>124 кг</th>
                <th>49 990 ₴</th>
            </tr>

        </table>
        <button class="button">Замовити</button>
    </div>
</div>

<div class="about">
    <div class="title">Опис</div>
    <div class="blockBlue">
        <div class="text">
            <div> Важить спортбайк від 110 до 140 кг в залежності від ємності й типу акумуляторних батарей. В базовій
                комплектації на електромотоцикл монтується свинцево-кислотна батарея типу AGM на 72В 20А. Вона
                складається з
                6 тягових акумуляторів 6DZM20 (12v 20Ah). Кількість циклів заряду-розряду свинцево-кислотних
                акумуляторів
                500. Корпус акумуляторів повністю водонепроникний виконаний з литого пластику. Всередині міститься вся
                електронна система управління зарядки. Спортбайк заряджається за допомогою зарядного пристрою від
                звичайної
                побутової розетки.
            </div>
            <div>Seo-текст ...</div>
        </div>
    </div>
</div>

<div class="Comments">

    <?php

    require 'Goods\comment.php';

    require 'functions.php';

    createComment($_POST['name'], $_POST['text']);
    ?>

    <div class="comment">
        <img class="pers" src="../../Imgs/Lending/Person.png"/>
        <div class="content">
            <div class="name">Вася <span>2 серпня 2020</span></div>
            <div class="text">Супер. Сподобався</div>
        </div>
    </div>
    <div class="comment">
        <img class="pers" src="../../Imgs/Lending/Person.png"/>
        <div class="content">
            <div class="name">Вася <span>4 квітня 2020</span></div>
            <div class="text">Як вибрати іншу комплектацію?</div>
        </div>
    </div>
    <div class="comment">
        <img class="Arr" src="../../Imgs/Lending/Arr.png"/>
        <img class="pers" src="../../Imgs/Lending/Person.png"/>
        <div class="content">
            <div class="name">Адмін <span>4 квітня 2020</span></div>
            <div class="text">Виберіть вкладку “створити комлектацію”</div>
        </div>
    </div>


</div>

</body>

<?php require 'Styles\Footer\footer.php' ?>

</html>