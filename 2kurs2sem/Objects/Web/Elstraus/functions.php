<?php


function showBlock($id)
{
    require 'Goods/Good' . $id . '/block' . $id . '.php';
}

function createBlock($order, $id, $linkCat, $cat, $name, $price)
{
    echo '<div class="block' . $order . '">' .
        '<a href="?id=' . $id . '"><img class="bike" src="Imgs/Lending/' . $name . '.png"/></a>' .
        '<div class="markers"><a href="?page=transport">#Електротранспорт</a>' .
        ' <a href="?page=' . $linkCat . '">#' . $cat . '</a></div>' .
        '<a class="name" href="?id=' . $id . '">' . $name . '</a>' .
        '<div class="money">' . $price . '₴</div>' .
        '<button class="button" type="button">Замовити</button>' .
        '</div>';

}

function createComment($name, $text){



    $name = htmlspecialchars($name);
    $text = htmlspecialchars($text);

    if ($name && $text) {

        echo '<div class="comment">' .
            '<img class="pers" src="../../Imgs/Lending/Person.png"/>' .
            '<div class="content">' .
            '<div class="name">' . $name . ' <span>' . strftime('%e %B %Y') . '</span></div>' .
            '<div class="text">' . $text . '</div>' .
            '</div>' .
            '</div>';
    }

}





