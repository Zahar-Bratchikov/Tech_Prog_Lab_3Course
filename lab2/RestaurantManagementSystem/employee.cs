namespace RestaurantManagementSystem
{
    public abstract class Employee
    {
        public Employee? nextEmployee;

        public void SetNextEmployee(Employee next)
        {
            nextEmployee = next;
        }

        public abstract void PerformTask(string task);
    }

    public class Waiter : Employee
    {
        public override void PerformTask(string task)
        {
            if (task == "Serve Order")
            {
                Console.WriteLine("Waiter is serving the order");
            }
            else if (nextEmployee != null)
            {
                nextEmployee.PerformTask(task);
            }
        }
    }

    public class Manager : Employee
    {
        public override void PerformTask(string task)
        {
            if (task == "Manage menu")
            {
                Console.WriteLine("Manager is managing menu");
            }
            else if (nextEmployee != null)
            {
                nextEmployee.PerformTask(task);
            }
        }
    }

    public class Chef : Employee
    {
        public override void PerformTask(string task)
        {
            if (task == "Prepare Dish")
            {
                Console.WriteLine("Chef is Preparing the dish");
            }
            else if (nextEmployee != null)
            {
                nextEmployee.PerformTask(task);
            }
        }
    }
}
