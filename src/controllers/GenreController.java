package controllers;

import base.Controller;
import base.Mode;
import models.Genre;
import repositary.Books;
import repositary.Genres;
import views.GenresView;

public class GenreController implements Controller {

    public static final GenreController INSTANCE = new GenreController();

    private final GenresView view;
    private final Genres repository;
    private final Books books;

    public GenreController() {
        view = new GenresView();
        repository = LibraryController.genres;
        books = LibraryController.books;
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
                removeGenre();
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

    private void removeGenre() {
        int numberDeletedGenre = getNumberDeletedGenre();
        verifyLinkedBooks(numberDeletedGenre);
        repository.remove(numberDeletedGenre - 1);
        view.displayMessage("Genre " + numberDeletedGenre + " was deleted successful.");
    }

    private void verifyLinkedBooks(int numberDeletedGenre) {
        Genre genre = repository.getModel(numberDeletedGenre - 1);
        if (countBooksByGenre(genre) > 0) {
            if (view.isNeedRemoveLinkedBooks(genre)) {
                books.remove(genre);
            } else {
                books.setNulls(genre);
            }
        }
    }

    private int countBooksByGenre(Genre genre) {
        int count = 0;
        for (int i = 0; i < books.getSize(); i++) {
            if (books.getModel(i).getGenre().equals(genre)) {
                count++;
            }
        }
        return count;
    }

    private int getNumberDeletedGenre() {
        int id;
        while (true) {
            id = view.deleteGenre();
            if (id > 0 && id <= repository.getSize()) {
                break;
            } else {
                view.displayMessage("Invalid number of genre: " + id);
            }
        }
        return id;
    }

    public void displayGenres() {
        String str;
        if (repository.getSize() > 0) {
            StringBuilder builder = new StringBuilder("Genres\n");
            builder.append(repository.displayAll());
//            String format = "%-20s%s%n";
//            StringBuilder builder = new StringBuilder(String.format(format, "Genre", "Description"));
//            int i = 0;
//            for (i = 0; i < repository.getSize() - 1; i++) {
//                Genre line = repository.getModel(i);
//                builder.append(String.format(format, (i + 1) + ". " + line.getName(), line.getDescription()));
//            }
//            format = "%-20s%s";
//            Genre line = repository.getModel(i);
//            builder.append(String.format(format, (i + 1) + ". " + line.getName(), line.getDescription()));
            str = builder.toString();
        } else {
            str = "Nothing to display.";
        }
        view.displayGenres(str);
    }
}
