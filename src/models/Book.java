package models;

import java.io.Serializable;

public class Book implements Serializable {

    private Author author;
    private String name;
    private int yearPublication;
    private Genre genre;
    private String description;

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Author = [" + author +
                "], book's name = " + "'" + name + "'" +
                ", year of publication = " + "'" + yearPublication + "'" +
                ", genre = [" + genre +
                "], book's description = " + "'" + description + "'";
    }
}
