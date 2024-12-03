﻿using System;

namespace RestaurantManagementSystem
{
    public class Dish : MenuItem
    {
        public override float GetCost()
        {
            return Price;
        }
    }

    public class Drink : MenuItem
    {

        public override float GetCost()
        {
            return Price;
        }
    }

    public class DecoratorOptionDish : MenuItem
    {
        private readonly MenuItem dish;
        public string Option { get; set; }

        public DecoratorOptionDish(MenuItem dish, string option)
        {
            this.dish = dish;
            Option = option;
        }

        public override float GetCost()
        {
            return dish.GetCost() + 2; //Увеличиваем стоимость, если добавляем какую-либо опцию к блюду
        }
    }

    public class DecoratorOptionDrink : MenuItem
    {
        private readonly MenuItem drink;
        public string Option { get; set; }

        public DecoratorOptionDrink(MenuItem drink, string option)
        {
            this.drink = drink;
            Option = option;
        }

        public override float GetCost()
        {
            return drink.GetCost() + 2;
        }
    }
}