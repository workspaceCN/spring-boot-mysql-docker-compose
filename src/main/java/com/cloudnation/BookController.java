package com.cloudnation;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookRepository repo;

    public BookController(BookRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/api/books")
    public List<Book> all() {
        return repo.findAll();
    }

    @PostMapping("/api/books")
    public Book add(@RequestBody Book book) {
        book.setId(null);
        return repo.save(book);
    }

    @DeleteMapping("/api/books/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @GetMapping("/api/info")
    public Map<String, String> info() throws Exception {
        Map<String, String> m = new LinkedHashMap<>();
        m.put("container", InetAddress.getLocalHost().getHostName());
        m.put("java", System.getProperty("java.version"));
        m.put("books", String.valueOf(repo.count()));
        m.put("time", LocalDateTime.now().withNano(0).toString());
        return m;
    }
}
