package org.example;

public class Book {
    private final String Judul_Buku;
    private final String penulis;
    private final int Tahun;

    public Book(String Judul_Buku, String penulis, int tahun) {
        if (Judul_Buku == null || Judul_Buku.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul harus diisi");
        }

        if (penulis == null || penulis.trim().isEmpty()) {
            throw new IllegalArgumentException("Author harus diisi");
        }

        if (tahun < 2000 || tahun > 2100) {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
        }

        this.Judul_Buku = Judul_Buku.trim();
        this.penulis = penulis.trim();
        this.Tahun = tahun;
    }

    public String getJudul_Buku() {
        return Judul_Buku;
    }

    public String getPenulis() {
        return penulis;
    }

    public int getTahun() {
        return Tahun;
    }

    @Override
    public String toString() {
        return String.format("%s by %s (%d)", Judul_Buku, penulis, Tahun);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return Tahun == book.Tahun &&
                Judul_Buku.equals(book.Judul_Buku) &&
                penulis.equals(book.penulis);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(Judul_Buku, penulis, Tahun);
    }
}