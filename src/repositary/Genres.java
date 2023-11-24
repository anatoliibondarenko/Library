package repositary;

import models.Genre;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Genres implements Serializable {

    private final List<Genre> genres = new ArrayList<>();


    public void add(Genre genre) {
        genres.add(genre);
    }

    private void writeObject(java.io.ObjectOutputStream out) throws IOException {

    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {

    }
}
