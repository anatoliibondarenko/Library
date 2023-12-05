package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Author implements Serializable {

    private String name;
    private String lastName;
    private List<Book> listBooks;

    public Author() {
        listBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return  "Name: " + name + ", lastname: " + lastName;
    }
}
