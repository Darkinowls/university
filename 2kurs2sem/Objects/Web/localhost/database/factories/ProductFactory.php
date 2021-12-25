<?php

namespace Database\Factories;

use App\Models\MyCase;
use App\Models\Platform;
use App\Models\Product;
use Illuminate\Database\Eloquent\Factories\Factory;

class ProductFactory extends Factory
{
    /**
     * The name of the factory's corresponding model.
     *
     * @var string
     */
    protected $model = Product::class;

    /**
     * Define the model's default state.
     *
     * @return array
     */
    public function definition()
    {

        return [
            'slug'=> $this->faker->unique()->domainWord,
            'price' => rand(100, 5000),
            'title' => $this->faker->unique()->word(),
            'description' => $this->faker->text(),
            'caseId' => MyCase::all()->random(),
            'photo' => 'https://drive.google.com/file/d/1juZJVpc-6URWc3Di86qCGhZkxEBMS5_n/view?usp=sharing',
            'platformId' => Platform::all()->random(),
            'date' => $this->faker->date('d.m.Y'),
        ];
    }
}
