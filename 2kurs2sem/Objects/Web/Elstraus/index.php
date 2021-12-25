<?php

setcookie('userName', htmlspecialchars($_POST['name'] ?? $_COOKIE['userName']), time() + 86400);

setlocale(LC_ALL, 'UKR.UTF-8');

$categories = ['transport', 'moto', 'tricycle', 'scooter'];


if (in_array($s = $_GET['page'], $categories)) {

    require_once 'Containers/' . $s . '/' . $s . '.php';

} elseif (preg_match('/^[1-9][0-9]?$/i', $s = $_GET['id'])) {

    require_once 'Goods/good' . $s . '/good' . $s . '.php';

} elseif (!$_GET['page'] && !$_GET['id']) require_once 'lending.php';


else echo "<h1>Page's not found. ERROR 404</h1>";

