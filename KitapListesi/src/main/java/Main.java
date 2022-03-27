import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        addBooks();

        bookList.stream().forEach(book -> map.put(book.getName(), book.getAuthor()));

        for(String bookName : map.keySet()){
            System.out.println("Book Name: " + bookName + " \t\t | Author: " + map.get(bookName));
        }

        System.out.println("--------------------------------------------");

        List<Book> bookOver100Page = bookList.stream().filter(book -> book.getPageNumber() > 100).collect(Collectors.toList());

        bookOver100Page.forEach(book -> System.out.println("Book Name: " + book.getName() + " \t\t | Page Num: " + book.getPageNumber()));

    }

    public static void addBooks(){


        Book book1 = new Book("Kabadayı", 80, "Ömer Sarıbıyık", LocalDate.of(2009, 8, 23));
        Book book2 = new Book("Martin Eden", 489, "Jack London", LocalDate.of(2012, 6, 22));
        Book book3 = new Book("Suskunlar", 350, "Durmuş Emmi", LocalDate.of(2003, 6, 3));
        Book book4 = new Book("Teşkilat", 90, "Soner Yalçın", LocalDate.of(2013, 11, 14));
        Book book5 = new Book("Ökkeş Okulda", 135, "Peyami Sefa", LocalDate.of(2008, 1, 29));
        Book book6 = new Book("Fatma Gül'ün Suçu Ne?", 680, "Reşat Nuri Güntekin", LocalDate.of(2007, 4, 14));
        Book book7 = new Book("Yaprak Dökümü", 495, "Reşat Nuri Güntekin", LocalDate.of(2012, 4, 19));
        Book book8 = new Book("Sefiller", 750, "Victor Hugo", LocalDate.of(1918, 7, 13));
        Book book9 = new Book("Tutunamayanlar", 825, "Dostoyoveski", LocalDate.of(1865, 11, 11));
        Book book10 = new Book("Kumarbaz", 65, "Dostoyoveski", LocalDate.of(1903, 6, 3));

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);
        bookList.add(book6);
        bookList.add(book7);
        bookList.add(book8);
        bookList.add(book9);
        bookList.add(book10);
    }
}
