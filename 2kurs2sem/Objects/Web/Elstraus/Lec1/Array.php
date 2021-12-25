<?php

echo '    <br>/** <br>';
echo '<h3>     * ARRAY BLOCK <br></h3>';
echo '         */ <br>';

$arr = [1, 2, 3];

echo $arr[2] + 1000 . '<br/>';

$arrS = ["first", "second", 3];

for ($i = 0; $i < sizeof($arrS); $i++) {
    echo "$i -> $arrS[$i]" . '<br>';
}

$hashArr = array(
    2 => 'My',
    4 => 'Hash',
    6 => 'Table'
);

foreach ($hashArr as $el) {
    echo $el . '<br>';
}


$myArr = [
    'act' => "Fly",
    'person' => 'Polly',
    'to' => [
        'to School',
        'to Island',
        'to Church'
    ]
];

$String = '<br>' . $myArr['person'] . ' ' . $myArr['act'] . ' ' . $myArr['to'][0] . '<br>' . '<br>';

echo $String;

foreach ($myArr as $el) {
    echo $el . '<br>';
}

echo '<hr>';