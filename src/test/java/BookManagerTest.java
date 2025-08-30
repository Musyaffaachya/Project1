import org.example.Book;
import org.example.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book buku = new Book("Pemrograman", "Andi", 2020);
        bookManager.addBook(buku);
        assertEquals(1, bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book buku = new Book("Basis Data", "Erlangga", 2021);
        bookManager.addBook(buku);

        boolean removed = bookManager.removeBook("Basis Data");
        assertTrue(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    // Melengkapi Unit Test dibawah untuk buku yang memang tidak terdapat pada list
    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        // Menambahkan satu buku sebagai data awal
        bookManager.addBook(new Book("Buku A", "Penulis A", 2021));
        // Mencoba menghapus buku yang tidak ada dalam daftar
        boolean removed = bookManager.removeBook("Buku Fiksi");
        // Memastikan method removeBook mengembalikan false dan jumlah buku tidak berkurang
        assertFalse(removed);
        assertEquals(1, bookManager.getBookCount());
    }

    // Melengkapi Unit Test dibawah untuk mencari buku berdasarkan penulis
    @Test
    @DisplayName("Test mencari buku berdasarkan author")
    void testFindBooksByAuthor() {
        // Menambahkan beberapa buku
        bookManager.addBook(new Book("Java Dasar", "Andi", 2022));
        bookManager.addBook(new Book("Python Lanjut", "Budi", 2023));
        bookManager.addBook(new Book("Java Lanjut", "Andi", 2024));

        // Mencari buku berdasarkan penulis "Andi"
        List<Book> andiBooks = bookManager.findBooksByAuthor("Andi");
        // Memastikan ada 2 buku yang ditemukan
        assertEquals(2, andiBooks.size());
    }

    // Melengkapi Unit Test dibawah untuk mendapatkan semua buku yang ada di dalam list
    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        // Menambahkan beberapa buku
        Book book1 = new Book("Buku Satu", "Penulis A", 2021);
        Book book2 = new Book("Buku Dua", "Penulis B", 2022);
        bookManager.addBook(book1);
        bookManager.addBook(book2);

        // Mendapatkan semua buku
        List<Book> allBooks = bookManager.getAllBooks();
        // Memastikan jumlah buku adalah 2 dan berisi buku yang telah ditambahkan
        assertEquals(2, allBooks.size());
        assertTrue(allBooks.contains(book1));
        assertTrue(allBooks.contains(book2));
    }
}