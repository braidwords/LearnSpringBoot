package my.learning.project.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksService {

    @Autowired
    private BookRepository bookRepository;

/*    private List<Book> books = new ArrayList<>();
    BooksService() {
        books.add(new Book("Fiction", 1));
        books.add(new Book("Comedy", 2));
        books.add(new Book("Romance", 3));
        books.add(new Book("Sci-fi", 4));
    }*/

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book get_book(int i) {
        for (Book book : getAllBooks()) {
            if (i == book.getId()) {
                return book;
            }
        }
        return null;
    }

    public Book add_book(Book book) {
        return bookRepository.save(book);
    }

    public Book get_id(String name) {
        for (Book book : getAllBooks()) {
            if (name.equals(book.getName())) {
                return book;
            }
        }
        return null;
    }

/*    public void update_book(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (book.getName().equals(books.get(i).getName())) {
                books.set(i, book);
                return;
            }
        }
    }*/

/*    public void delete_book(String name) {
        for (Book book : return_all()) {
            if (book.getName().equals(name))
                books.remove(book);
        }
    }*/
}

