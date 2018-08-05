package pl.coderslab.workshop5krk03.service;

import org.springframework.stereotype.Service;
import pl.coderslab.workshop5krk03.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemoryBookService {
    private static long lastId;
    private List<Book> list;

    public MemoryBookService() {
        lastId = 3;
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public void deleteBook(long id) {
        int index = list.indexOf(new Book(id, "", "", "", "", ""));
        System.out.println(index);
        if (index != -1) {
            list.remove(list.get(index));
        }
        System.out.println(list);
    }

    public long addBook (String isbn, String title, String author, String publisher, String type)  {
        long id = (lastId += 1);
        this.list.add(new Book (id, isbn, title, author, publisher, type));
        return id;
    }

    public long addBook (Book book) {
        long id = (lastId += 1);
        book.setId(id);
        this.list.add(book);
        return id;
    }

    public Book getById (long id) {
        return list.stream()
                .filter(v -> v.getId() == id)
                .collect(Collectors.toList()).get(0);
    }
}
