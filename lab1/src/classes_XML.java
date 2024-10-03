class Address {
    private String city;
    String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "\n\t\t\tcity: " + city + " \n\t\t\tcountry: " + country ;
    }
}

class Publisher {
    String name;
    Address address;

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "\n\t\tname: " + name + " \n\t\taddress: " + address;
    }
}

class Price {
    private String currency;
    private double amount;

    public Price(String currency, double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\n\t\tcurrency: " + currency + " \n\t\tamount: " + amount;
    }
}

class Book {
    private String id;
    String title;
    String author;
    int year;
    String genre;
    Price price;
    String format;
    Publisher publisher;
    String translator;
    String isbn;
    String awards;

    public Book(String id, String title, String author, int year, String genre, Price price,
                String format, Publisher publisher, String translator, String isbn, String awards) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.genre = genre;
        this.price = price;
        this.format = format;
        this.publisher = publisher;
        this.translator = translator;
        this.isbn = isbn;
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Book:\n\tid: " + id + " \n\ttitle: " + title + " \n\tauthor: " + author + " \n\tyear: " + year +
               " \n\tgenre: " + genre + " \n\tprice: " + price + " \n\tformat: " + format + " \n\tpublisher: " + publisher +
               " \n\ttranslator: " + translator + " \n\tisbn: " + isbn + " \n\tawards: " + awards;
    }
}
