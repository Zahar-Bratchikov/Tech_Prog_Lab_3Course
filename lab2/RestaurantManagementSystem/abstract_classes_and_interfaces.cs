using System;

namespace RestaurantManagementSystem
{
    public abstract class MenuItem
    {
        public string Name { get; set; }
        public string Type { get; set; }
        public float Price { get; set; }

        public abstract float GetCost();
    }
}