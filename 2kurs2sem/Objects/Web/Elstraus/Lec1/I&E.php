<?php

echo '    <br>/** <br>';
echo '<h3>     * EXPLODE & IMPLODE BLOCK<br></h3>';
echo '         */ <br>';

$String = "My favorite string";
$My = explode(" ", $String);

echo $My[0] . ' ' . $My[2] . '<br>';

print_r(explode(" ", $String, 2)); // виводить інфу про зміну
echo '<br>';
print_r(explode(" ", $String, -2));
echo '<br>';


echo implode($My) . '<br>';
echo implode(' ', $My) . '<br>';
echo implode(', ', $My) . '<br>';
echo '<hr>';