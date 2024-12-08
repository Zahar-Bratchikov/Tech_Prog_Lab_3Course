namespace RestaurantManagementSystem
{
    public interface IClientObserver
    {
        void UpdateStatus(OrderStatus status);
    }

    public enum OrderStatus
    {
        Created, Preparing, Completed, Cancelled
    }

   public class Order
    {
        private List<MenuItem> orderItems = new();
        private OrderStatus status;
        private List<IClientObserver> observers = new();

        private void notifyClients()
        {
            foreach (var observer in observers)
            {
                observer.UpdateStatus(status);
            }
        }

        public Order()
        {
            status = OrderStatus.Created;
        }

        public void addMemuItem(MenuItem item) 
        {
            orderItems.Add(item);
        }

        public void removeMemuItem(MenuItem item)
        {
            orderItems.Remove(item);
        }

        public void changeStatus(OrderStatus newStatus)
        {
            status = newStatus;
            notifyClients();
        }

        public void attach(IClientObserver observer)
        {
            observers.Add(observer);
        }

        public void displayOrder()
        {
            Console.WriteLine("Ordered items:");
            foreach (var item in orderItems)
            {
                Console.WriteLine($"{item.Name}: {item.GetCost()} c.u.");
            }
        }

        public OrderStatus Status => status;
    }

    public class Client : IClientObserver
    {
        public string name { get; set; }
        public string contactInfo { get; set; }

        public void createOrder()
        {
            Console.WriteLine($"{name} create order");
        }

        public void UpdateStatus(OrderStatus status)
        {
            Console.WriteLine($"Уведомление для клиента {name}: Статус заказа изменен на {status}.");
        }
    }
}
