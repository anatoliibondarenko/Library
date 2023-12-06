package controllers;

import base.Controller;
import models.Genre;
import repositary.Books;
import repositary.Genres;
import views.GenresView;

public class GenreController extends Controller {

    public static final GenreController INSTANCE = new GenreController();

    private final GenresView view;
    private final Genres repository;
    private final Books books;

    public GenreController() {
        view = new GenresView();
        repository = LibraryController.genres;
        books = LibraryController.books;
    }

    public void add() {
        Genre genre = new Genre();
        view.inputGenre(genre);
        repository.add(genre);
        view.displayMessage("Genre " + genre.toString() + " was added.");
    }

    public void remove() {
        int numberDeletedGenre = view.getChoiceNumber("Input number of deleted genre", repository.getSize());
        processLinkedBooks(numberDeletedGenre);
        repository.remove(numberDeletedGenre - 1);
        view.displayMessage("Genre " + numberDeletedGenre + " was deleted successful.");
    }

    public void display() {
        if (repository.getSize() > 0) {
            view.displayMessage("Genres: ");
        }
        view.displayMessage(repository.displayAll());
    }

    private void processLinkedBooks(int numberDeletedGenre) {
        Genre genre = repository.getModel(numberDeletedGenre - 1);
        if (countBooksByGenre(genre) > 0) {
            if (view.isNeedRemoveLinkedBooks()) {
                books.remove(genre);
            } else {
                books.setNulls(genre);
            }
        }
    }

    private int countBooksByGenre(Genre genre) {
        int count = 0;
        for (int i = 0; i < books.getSize(); i++) {
            if (books.getModel(i).getGenre() != null && books.getModel(i).getGenre().equals(genre)) {
                count++;
            }
        }
        return count;
    }
}
