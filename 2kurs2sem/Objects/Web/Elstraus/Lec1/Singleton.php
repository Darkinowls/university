<?php

echo '    <br>/** <br>';
echo '<h3>     * SINGLETON BLOCK<br></h3>';
echo '         */ <br>';

class Singleton{

    private static $single;

    public $name = "it's singleton<br>";

    public static function getSingle()
    {
        if (self::$single === null) {
            self::$single = new Singleton();

        }
        return self::$single;
    }

    private function __construct()
    {
    }

    private function __clone()
    {
    }

    private function __wakeup()
    {
    }


}

var_dump(Singleton::getSingle());

$s1 = Singleton::getSingle();
var_dump($s1);

$s1->name = 'new string<br>';
var_dump($s1);

$s2 = Singleton::getSingle();
var_dump($s2);

if ($s1 === $s2) {
    echo "Yes, it's singleton!";
} else {
    echo "ERROR IN SINGLETON";
}


