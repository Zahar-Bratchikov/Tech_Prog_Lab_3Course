import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class XML_parser {
    private List<Book> books = new ArrayList<>();

    public void parse(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Book currentBook = null;
            Publisher currentPublisher = null;
            Address currentAddress = null;
            Price currentPrice = null;
            String awards = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("<book")) {
                    String id = line.replaceAll(".*id=\"|\">", "").trim();
                    currentBook = new Book(id, "", "", 0, "", null, "", null, "", "", "");
                } else if (line.startsWith("<title>")) {
                    String title = line.replaceAll("<title>|</title>", "").trim();
                    currentBook.title = title;
                } else if (line.startsWith("<author>")) {
                    String author = line.replaceAll("<author>|</author>", "").trim();
                    currentBook.author = author;
                } else if (line.startsWith("<year>")) {
                    int year = Integer.parseInt(line.replaceAll("<year>|</year>", "").trim());
                    currentBook.year = year;
                } else if (line.startsWith("<genre>")) {
                    String genre = line.replaceAll("<genre>|</genre>", "").trim();
                    currentBook.genre = genre;
                } else if (line.startsWith("<price")) {
                    String currency = line.replaceAll(".*currency=\"([^\"]+)\".*", "$1").trim();
                    double amount = Double.parseDouble(line.replaceAll("<price\\s+currency=\"[^\"]+\">|</price>", "").trim());
                    currentPrice = new Price(currency, amount);
                } else if (line.startsWith("<format>")) {
                    String format = line.replaceAll("<format>|</format>", "").trim();
                    currentBook.format = format;
                } else if (line.startsWith("<isbn>")) {
                    String isbn = line.replaceAll("<isbn>|</isbn>", "").trim();
                    currentBook.isbn = isbn;
                } else if (line.startsWith("<translator>")) {
                    String translator = line.replaceAll("<translator>|</translator>", "").trim();
                    currentBook.translator = translator;
                } else if (line.startsWith("<publisher>")) {
                    currentPublisher = new Publisher("", null);
                } else if (line.startsWith("<name>") && currentPublisher != null) {
                    String name = line.replaceAll("<name>|</name>", "").trim();
                    currentPublisher.name = name;
                } else if (line.startsWith("<city>")) {
                    String city = line.replaceAll("<city>|</city>", "").trim();
                    currentAddress = new Address(city, "");
                } else if (line.startsWith("<country>")) {
                    String country = line.replaceAll("<country>|</country>", "").trim();
                    currentAddress.country = country;
                } else if (line.startsWith("</address>") && currentPublisher != null) {
                    currentPublisher.address = currentAddress;
                } else if (line.startsWith("</publisher>")) {
                    currentBook.publisher = currentPublisher;
                } else if (line.startsWith("<awards>")) {
                    awards = "";
                } else if (line.startsWith("<award>")) {
                    awards += line.replaceAll("<award>|</award>", "").trim() + ", ";
                } else if (line.startsWith("</awards>")) {
                    currentBook.awards = awards != null ? awards.replaceAll(", $", "") : null;
                } else if (line.startsWith("</book>")) {
                    if (currentBook != null) {
                        currentBook.price = currentPrice;
                        books.add(currentBook);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
