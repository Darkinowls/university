<!DOCTYPE html>
<html lang="en">


<?php

require 'Containers\head.php';

require 'Styles\Header\header.php'

?>

<body>

<div class="Search">
    <div class="Title">Електротранспорт</div>
    <div class="MySearch">
        <div class="Buttons">
            <button id="FilterDropper" onclick="ShowFilter()" class="FilterDropper">Фільтрувати за</button>
            <button id="SorterDropper" onclick="ShowSorter()" class="SorterDropper">Сортувати за</button>
        </div>
        <div id="FilterDropped" class="FilterDropped">
            <div class="line">
                <div class="choose">
                    <select name="feature1" id="feature1">
                        <option value="Price">Ціна базової комплектації</option>
                        <option value="char1">Характеристика 1</option>
                        <option value="char2">Характеристика 2</option>
                        <option value="char3">Характеристика 3</option>
                    </select>
                    <div class="arrow">
                        <div class="l1"></div>
                        <div class="l2"></div>
                    </div>
                </div>
                <div class="write">від<input>до<input></div>
            </div>
            <div class="line">
                <div class="choose">
                    <select name="feature2" id="feature2">
                        <option value="Price">Ціна базової комплектації</option>
                        <option value="char1">Характеристика 1</option>
                        <option value="char2">Характеристика 2</option>
                        <option value="char3">Характеристика 3</option>
                    </select>
                    <div class="arrow">
                        <div class="l1"></div>
                        <div class="l2"></div>
                    </div>
                </div>
                <div class="write">від<input>до<input></div>
            </div>
            <div class="line">
                <div class="choose">
                    <select name="feature1" id="feature3">
                        <option value="Price">Ціна базової комплектації</option>
                        <option value="char1">Характеристика 1</option>
                        <option value="char2">Характеристика 2</option>
                        <option value="char3">Характеристика 3</option>
                    </select>
                    <div class="arrow">
                        <div class="l1"></div>
                        <div class="l2"></div>
                    </div>
                </div>
                <div class="write">від<input>до<input></div>
            </div>
            <div class="line">
                <div class="choose">
                    <select name="feature1" id="feature4">
                        <option value="Price">Ціна базової комплектації</option>
                        <option value="char1">Характеристика 1</option>
                        <option value="char2">Характеристика 2</option>
                        <option value="char3">Характеристика 3</option>
                    </select>
                    <div class="arrow">
                        <div class="l1"></div>
                        <div class="l2"></div>
                    </div>
                </div>
                <div class="write">від<input>до<input></div>
            </div>
            <button class="button">Фільтрувати</button>
        </div>
        <div id="SorterDropped" class="SorterDropped">
            <div class="line">
                <div class="choose">
                    <select name="Price" id="Price">
                        <option value="PriceIn">За збільшенням ціни</option>
                        <option value="PriceDe">За зменшенням ціни</option>
                    </select>
                    <div class="arrow">
                        <div class="l1"></div>
                        <div class="l2"></div>
                    </div>
                </div>
                <div class="choose">
                    <select name="Mass" id="Mass">
                        <option value="MassIn">За збільшенням ваги</option>
                        <option value="MassDe">За зменшенням ваги</option>
                    </select>
                    <div class="arrow">
                        <div class="l1"></div>
                        <div class="l2"></div>
                    </div>
                </div>
                <div class="choose">
                    <select name="Pop" id="Pop">
                        <option value="PopIn">За збільшенням популярності</option>
                        <option value="PopDe">За зменшенням популярності</option>
                    </select>
                    <div class="arrow">
                        <div class="l1"></div>
                        <div class="l2"></div>
                    </div>
                </div>
            </div>
            <button class="button">Сортувати</button>
        </div>
    </div>
</div>


<?php

require 'Containers\pages.php';
require 'Functions.php';
for ($i = 0; $i < 4; $i++) {
    echo '<div class="slide"> <div class="line">';

    showBlock(11);
    showBlock(12);
    showBlock(24);


    echo '</div> </div>';
}

require 'Containers\pages.php';


?>


</body>

<?php require 'Styles\Footer\footer.php' ?>

</html>
