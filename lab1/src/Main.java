public class Main {
    public static void main(String[] args) {
        XML_parser parser = new XML_parser();
        parser.parse("random_structure_4.xml");

        for (Book book : parser.getBooks()) {
            System.out.println(book.toString());
        }
    }
}
