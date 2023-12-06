package repositary;

import base.Repository;
import models.Author;
import models.Book;
import models.Genre;

import java.io.Serializable;

public class Books extends Repository<Book> implements Serializable {

    public void remove(Genre genre) {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (getModel(i).getGenre().equals(genre)) {
                remove(i);
                size--;
            }
        }
    }

    public void setNulls(Genre genre) {
        for (int i = 0; i < getSize(); i++) {
            if (getModel(i).getGenre().equals(genre)) {
                getModel(i).setGenre(null);
            }
        }
    }

    public void remove(Author author) {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            if (getModel(i).getAuthor().equals(author)) {
                remove(i);
                size--;
            }
        }
    }
}
