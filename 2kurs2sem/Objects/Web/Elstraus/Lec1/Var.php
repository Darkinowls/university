<?php

echo '    <br>/** <br>';
echo '<h3>     * VAR BLOCK <br></h3>';
echo '         */ <br>';

// My comment
$str = 'Hello World';
echo "<h4>$str</h4>";
echo '<h4>$str</h4>';

$var = 'Another';
$$var = 'World';
echo $$var . ', ' . $var . ' ' . ${'Another'} . '<br>';

$varV = $var;
echo $varV . ' ' . $$varV;

echo '<hr>';

