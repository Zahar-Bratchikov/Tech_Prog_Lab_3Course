import java.util.List;

public class Main {
    public static void main(String[] args) {
        XML_parser parser = new XML_parser();
        parser.parse("random_structure_4.xml");

        List<Book> books = parser.getBooks();
        for (int i = 0; i < books.size(); i++){
            Book book = books.get(i);
            System.out.println(book);
        }

        System.out.println("-------------------");

        Book book = books.get(1);
        System.out.println(book.getId());
        System.out.println(book.getTitle());
        System.out.println(book.getGenre());
        System.out.println(book.getAuthor());
    }
}
