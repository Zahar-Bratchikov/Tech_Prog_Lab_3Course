namespace RestaurantManagementSystem
{
    public abstract class MenuItem
    {
        public string Name { get; set; }
        public string Type { get; set; }
        public float Price { get; set; }

        public abstract float GetCost();
    }

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

    public class MenuManager
    {
        private static readonly MenuManager? instance;
        private List<Dish> dishes = new();
        private List<Drink> drinks = new();

        private MenuManager() { }

        public static MenuManager? Instance => instance;

        public void AddDish(Dish dish) => dishes.Add(dish);
        public void AddDrink(Drink drink) => drinks.Add(drink);
        public void GetMenu()
        {
            Console.WriteLine("Menu: \n");
            dishes.ForEach(dish => Console.WriteLine(dish.Name + "........." + dish.Price + "руб."));
            drinks.ForEach(drink => Console.WriteLine(drink.Name + "........." + drink.Price + "руб."));
        }
    }
}