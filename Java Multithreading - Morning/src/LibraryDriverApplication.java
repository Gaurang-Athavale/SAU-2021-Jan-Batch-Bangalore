import com.assignment.library.entity.Book;
import com.assignment.library.entity.Student;
import com.assignment.library.bookOperations.*;
import java.util.ArrayList;

public class LibraryDriverApplication {
    private static ArrayList<Student> studentList =new ArrayList<Student>();
    private static ArrayList<Book> bookList = new ArrayList<Book>();
    public static void main(String[] args) {
        initStudents();
        BlockedQueue blockedQueue = new BlockedQueue();
        initBooks(blockedQueue);

        bookList = blockedQueue.listBooks();

        String[] booksToBeBought = {"100"};
        Thread transaction1 = new Thread(new BookCart(blockedQueue, studentList.get(0), findBookByISBN(booksToBeBought)));
        transaction1.run();

        booksToBeBought = new String[]{"300", "200"};
        System.out.println("\nBOOKS ADDED TO THE SHOPPING CART: ");
        Thread transaction2 = new Thread(new BookCart(blockedQueue, studentList.get(4), findBookByISBN(booksToBeBought)));
        transaction2.run();

        addNewBooks(blockedQueue);

        booksToBeBought = new String[]{"100", "200"};
        Thread transaction3 = new Thread(new BookCart(blockedQueue, studentList.get(4), findBookByISBN(booksToBeBought)));
        transaction3.run();
        blockedQueue.listBooks();

        String[] bookToBeReviewed = {"300"};
        Thread transaction4 = new Thread(new ReviewBooks(blockedQueue, studentList.get(2), findBookByISBN(bookToBeReviewed)));
        transaction4.run();

        System.out.println("\nISSUED BOOKS:");
        for (Student student : studentList) {
            student.getBoughtBooks();
            student.getReviewBooks();
            System.out.println();
        }
        blockedQueue.listBooks();
    }

    private static ArrayList<Book> findBookByISBN(String[] isbnList) {
        ArrayList<Book> books = new ArrayList<Book>();
        for(String isbn : isbnList) {
            for(int i = 0; i < bookList.size();i++) {
                if(bookList.get(i).getISBN() == isbn && !bookList.get(i).getInReview() && !bookList.get(i).getInCart()) {
                    books.add(bookList.get(i));
                    break;
                }
            }
        }
        return books;
    }
    private static void initBooks(BlockedQueue bbq) {
        String name[] = {"A","B","C","D","A","B","C","D","C","B"};
        int id[] = {1 ,2 ,1 ,2 ,3 ,1 ,2 ,3 ,3 ,1};
        String ISBN[] = {"100","200","100","200","300","100","200","300","300","100"};
        Boolean isOwned[] = {false,false,false,false,false,false,false,false,false,false};
        Boolean isInCart[] = {false,false,false,false,false,false,false,false,false,false};
        Thread initializingBookList = new Thread(new AddBooks(bbq,name,id,ISBN,isOwned,isInCart));
        initializingBookList.run();
    }

    public static void addNewBooks(BlockedQueue blockedQueue) {
        String[] nameNew = {"E"};
        int[] idNew = {5};
        String[] ISBNNew= {"500"};
        Boolean [] isOwnedNew = {false};
        Boolean [] isInCart = {false};
        Thread addNewBookList = new Thread(new AddBooks(blockedQueue,nameNew,idNew,ISBNNew,isOwnedNew, isInCart));
        addNewBookList.run();

        System.out.println("AVAILABLE BOOKS: ");
        blockedQueue.listBooks();
    }

    public static void initStudents() {
        String name[] = {"V","W","X","Y","Z","Q","R","S","T","U"};
        int id[] = { 1 , 2 , 1 , 2 , 3 , 1 , 1 , 2 , 3 , 4 };
        String department[] = {"CS","CS","IT","CS","MECH","CS","MECH","IT","IT","CS"};

        for(int i=0;i<10;i++) {
            Student b = new Student(name[i], id[i], department[i]);
            studentList.add(b);
        }
    }
}
