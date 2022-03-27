import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i=1; i<1001; i++){
            numbers.add(i);
        }

        List<Integer> subList1 = numbers.subList(0, 250);
        List<Integer> subList2 = numbers.subList(250, 500);
        List<Integer> subList3 = numbers.subList(500, 750);
        List<Integer> subList4 = numbers.subList(750, 1000);

        System.out.println("Sublist1 Length: " + subList1.size());
        System.out.println("Sublist2 Length: " + subList2.size());
        System.out.println("Sublist3 Length: " + subList3.size());
        System.out.println("Sublist4 Length: " + subList4.size());

        TreeSet<Integer> evenNumberList = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        TreeSet<Integer> oddNumberList = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        OddEvenFinder evenFinder1 = new OddEvenFinder(evenNumberList, subList1);
        evenFinder1.even = true;
        OddEvenFinder evenFinder2 = new OddEvenFinder(evenNumberList, subList2);
        evenFinder2.even = true;
        OddEvenFinder evenFinder3 = new OddEvenFinder(evenNumberList, subList3);
        evenFinder3.even = true;
        OddEvenFinder evenFinder4 = new OddEvenFinder(evenNumberList, subList4);
        evenFinder4.even = true;

        Thread thread1 = new Thread(evenFinder1);
        Thread thread2 = new Thread(evenFinder2);
        Thread thread3 = new Thread(evenFinder3);
        Thread thread4 = new Thread(evenFinder4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Even number list size: " + evenNumberList.size());
        for(int a : evenNumberList){
            System.out.print(a + " ");
        }

        OddEvenFinder oddFinder1 = new OddEvenFinder(oddNumberList, subList1);
        oddFinder1.odd = true;
        OddEvenFinder oddFinder2 = new OddEvenFinder(oddNumberList, subList2);
        oddFinder2.odd = true;
        OddEvenFinder oddFinder3 = new OddEvenFinder(oddNumberList, subList3);
        oddFinder3.odd = true;
        OddEvenFinder oddFinder4 = new OddEvenFinder(oddNumberList, subList4);
        oddFinder4.odd = true;

        thread1 = new Thread(oddFinder1);
        thread2 = new Thread(oddFinder2);
        thread3 = new Thread(oddFinder3);
        thread4 = new Thread(oddFinder4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n Odd number list size: " + oddNumberList.size());
        for(int a : oddNumberList){
            System.out.print(a + " ");
        }
    }
}
