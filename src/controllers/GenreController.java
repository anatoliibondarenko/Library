package controllers;

import base.Controller;
import base.Mode;
import models.Genre;
import repositary.Genres;
import views.GenresView;

public class GenreController implements Controller {

    public static final GenreController INSTANCE = new GenreController();

    private final GenresView view;
    private final Genres repository;

    public GenreController() {
        view = new GenresView();
        repository = LibraryController.genres;
    }

    public void start() {
        Mode mode = view.selectMode();
        while (!mode.equals(Mode.EXIT)) {
            makeConcreteWork(mode);
            mode = view.selectMode();
        }
    }

    private void makeConcreteWork(Mode mode) {
        switch (mode) {
            case ADD:
                addGenre();
                break;
            case DELETE:
                deleteGenre();
                break;
            case DISPLAY: {
                displayGenres();
            }
        }
    }

    private void addGenre() {
        Genre genre = new Genre();
        view.inputGenre(genre);
        repository.add(genre);
    }

    private void deleteGenre() {
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
        view.displayMessage("Genre "+ id + " was deleted successful.");
    }

    private void displayGenres() {
        String format = "%-20s%s%n";
        StringBuilder builder = new StringBuilder(String.format(format, "Genre", "Description"));
        for (int i = 0; i < repository.getSize(); i++) {
            Genre line = repository.getModel(i);
            builder.append(String.format(format, (i + 1) + ". " + line.getName(), line.getDescription()));
        }
        view.displayGenres(builder.toString());
    }
}
