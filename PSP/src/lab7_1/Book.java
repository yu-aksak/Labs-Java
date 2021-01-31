package lab7_1;

public class Book {
    private int ID, year;
    private String author, title, genre;

    public Book(){ }

    public Book(int ID, String author, int year, String title, String genre){
        this.ID = ID;
        this.author = author;
        this.year = year;
        this.title = title;
        this.genre = genre;
    }

    public int getID() {
        return ID;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getTitle() {
        return title;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
