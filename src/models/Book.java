package models;

import java.io.Serializable;

public class Book implements Serializable {

    private Author author;
    private String name;
    private int yearPublication;
    private Genre genre;
    private String description;


}
