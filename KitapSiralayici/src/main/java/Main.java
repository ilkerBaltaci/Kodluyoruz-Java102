import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Fatma Gül'ün Suçu Ne?", 352);
        Book book2 = new Book("Patasana", 567);
        Book book3 = new Book("Istanbul Hatırası", 734);
        Book book4 = new Book("Efendi", 256);
        Book book5 = new Book("Kara Şovalye", 496);

        TreeSet<Book> hashSetName = new TreeSet<>();

        hashSetName.add(book1);
        hashSetName.add(book2);
        hashSetName.add(book3);
        hashSetName.add(book4);
        hashSetName.add(book5);

        for (Book book : hashSetName) {
            System.out.println("Name: " + book.getName() + " --- " + "Page Number: " + book.getPageNumber());
        }

        System.out.println("-------------------------");

        TreeSet<Book> hashSetPageNumber = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPageNumber() - o2.getPageNumber();
            }
        });

        hashSetPageNumber.add(book1);
        hashSetPageNumber.add(book2);
        hashSetPageNumber.add(book3);
        hashSetPageNumber.add(book4);
        hashSetPageNumber.add(book5);

        for (Book book : hashSetPageNumber) {
            System.out.println("Name: " + book.getName() + " --- " + "Page Number: " + book.getPageNumber());
        }

    }
}
