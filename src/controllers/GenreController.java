package controllers;

import base.Controller;
import base.Mode;
import base.Repository;
import models.Author;
import models.Genre;
import repositary.Genres;
import views.AuthorView;
import views.GenresView;

public class GenreController implements Controller {

    private final GenresView view;
    private final Genres repository;

    public GenreController(Genres repository) {
        this.view = new GenresView();
        this.repository = repository;
    }


    public void start() {
        Mode mode = view.selectMode();
        while (!mode.equals(Mode.EXIT)) {
            switch (mode) {
                case ADD:
                    Genre genre = new Genre();
                    view.inputGenre(genre);
                    repository.add(genre);
                    break;
                case DELETE:
                    int id;
                    while (true) {
                        id = view.deleteGenre();
                        if (id > 0 && id <= repository.getSize()) {
                            break;
                        } else {
                            view.displayMessage("Invalid number of genre: " + id) ;
                        }
                    }
                    repository.remove(id - 1);
                    view.displayMessage("Genre "+ (id - 1) + " was deleted successful.");
                    break;
                case DISPLAY: {
                    String format = "%-20s%s%n";
                    StringBuilder builder = new StringBuilder(String.format(format, "Genre", "Description"));
                    for (int i = 0; i < repository.getSize(); i++) {
                        Genre line = repository.getModel(i);
                        builder.append(String.format(format, (i + 1) + ". " + line.getName(), line.getDescription()));
                    }
                    view.displayGenres(builder.toString());

                }
            }
            mode = view.selectMode();
        }
    }

}
