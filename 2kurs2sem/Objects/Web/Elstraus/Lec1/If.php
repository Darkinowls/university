<?php

echo '    <br>/** <br>';
echo '<h3>     * IF BLOCK <br></h3>';
echo '         */ <br>';

$r = 500;
$l = 100;

if ($r != $l) {
    echo "$r != $l" . '<br>';
}

if (is_numeric($r) || is_numeric($l) || is_numeric('str')) {
    echo 'At least one of them ($r, $l , \'str\') is number<br>';
}

if (!0 && $r <= $l) {
    echo $r . $l . "<br>";
    echo ($r + $l) . "<br>";
    echo $r + $l * 2 . "<br>";
    echo ($r + $l) * 2 . "<br>";

} else {
    echo "Bruuu".'<br>';
}

$a = $_GET['a'] ?? 'default' . '<hr>';

echo $a;
