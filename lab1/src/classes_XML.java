class Address {
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "\n\t\t\tcity: " + city + " \n\t\t\tcountry: " + country;
    }
}

class Publisher {
    String name;
    Address address;

    public Publisher(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount){
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

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre){
        this.genre = genre;
    }

    public Price getPrice(){
        return price;
    }

    public void setPrice(Price price){
        this.price = price;
    }

    public String getFormat(){
        return format;
    }

    public void setFormat(String format){
        this.format = format;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    @Override
    public String toString() {
        return "Book:\n\tid: " + id + " \n\ttitle: " + title + " \n\tauthor: " + author +
                " \n\tyear: " + year + " \n\tgenre: " + genre + " \n\tprice: " + price +
                " \n\tformat: " + format + " \n\tpublisher: " + publisher +
                " \n\ttranslator: " + translator + " \n\tisbn: " + isbn +
                " \n\tawards: " + awards;
    }
}
