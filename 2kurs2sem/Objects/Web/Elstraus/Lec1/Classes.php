<?php

echo '    <br>/** <br>';
echo '<h3>     * CLASS BLOCK<br></h3>';
echo '         */ <br>';

class Person{
    private $name;
    private $surname;

    public function setName($name)
    {
        $this->name = $name;
    }

    public function getName()
    {
        return $this->name;
    }


    public function getSurname()
    {
        return $this->surname;
    }


    public function setSurname($surname)
    {
        $this->surname = $surname;
    }

    public function __construct($name , $surname)
    {
        $this->setName($name);
        $this->setSurname($surname);

    }

    public function __destruct()
    {
        echo 'That\'s all. Object is destroyed' . '<br>';
    }


}


$object = new Person('Denis' , 'Chernousov');

echo $object->getSurname() . ' ' . $object->getName() . '<br>';

$object->setName('Solomia');
$object->setSurname($object->getSurname() . 'a');

echo $object->getSurname() . ' ' . $object->getName()  . '<br>';

unset($object);



class Patient extends Person {
    private $age;
    private $number;


    public function __construct($age, $number , $name , $surname)
    {
        parent::__construct($name, $surname);
        $this->age = $age;
        $this->number = $number;
    }

    public function getAge()
    {
        return $this->age;
    }

    public function getNumber()
    {
        return $this->number;
    }

    public function __toString()
    {
        return $this->getAge() . ' ' . $this->getNumber() . ' ' . $this->getSurname() . ' ' . $this->getName() . '<br>' ;
    }



}

$P1 = new Patient(20 , 123 , 'Denis' , 'Chernousov');

echo $P1;

unset($P1);

echo '<hr>';

