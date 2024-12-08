namespace RestaurantManagementSystem
{
    public abstract class Reservation
    {
        public DateTime Date { get; set; }
        public int NumberOfPeople { get; set; }

        public abstract void ReserveTable();
    }

    public class StandardReservation : Reservation
    {
        public override void ReserveTable()
        {
            Console.WriteLine($"Стандартное резервирование на {Date}, кол-во людей: {NumberOfPeople}");
        }
    }

    public class VIPReservation : Reservation
    {
        public override void ReserveTable()
        {
            Console.WriteLine($"VIP резервирование на {Date}, кол-во людей: {NumberOfPeople}");
        }
    }

    public class BanquetetReservation : Reservation
    {
        public override void ReserveTable()
        {
            Console.WriteLine($"Банкет на {Date}, кол-во людей: {NumberOfPeople}");
        }
    }

    public class ReservationFactory
    {
        public static Reservation CreateReservation(string type, DateTime date, int numberOfPeople)
        {
            Reservation reservation = type switch
            {
                "Standard" => new StandardReservation(),
                "VIP" => new VIPReservation(),
                "Banquete" => new BanquetetReservation(),
                _ => throw new ArgumentException("Unknown reservation type")
            };

            reservation.Date = date;
            reservation.NumberOfPeople = numberOfPeople;
            return reservation;
        }
    }
}
