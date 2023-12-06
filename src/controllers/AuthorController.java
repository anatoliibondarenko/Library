package controllers;

import base.Controller;
import models.Author;
import repositary.Authors;
import repositary.Books;
import views.AuthorView;

public class AuthorController extends Controller {

    public static final AuthorController INSTANCE = new AuthorController();

    private final AuthorView view;
    private final Authors repository;
    private final Books books;

    public AuthorController() {
        view = new AuthorView();
        repository = LibraryController.authors;
        books = LibraryController.books;
    }

    public void add() {
        Author author = new Author();
        view.addModel(author);
        repository.add(author);
    }

    public void remove() {
        int numberDeletedAuthor = view.getChoiceNumber("Input number of deleted author", repository.getSize());
        Author author = repository.getModel(numberDeletedAuthor - 1);
        int countBooks = countBooksByAuthor(author);
        if (countBooks > 0) {
            view.displayMessage("Library has " + countBooks + " by author: " + author.toString());
            if (view.isNeedRemoveLinkedBooks()) {
                books.remove(author);
            } else {
                return;
            }
        }
        repository.remove(numberDeletedAuthor - 1);
        view.displayMessage("Author " + numberDeletedAuthor + " was deleted successful.");
    }

    public void display() {
        if (repository.getSize() > 0) {
            view.displayMessage("Authors: ");
        }
        view.displayMessage(repository.displayAll());
    }

    private int countBooksByAuthor(Author author) {
        int count = 0;
        for (int i = 0; i < books.getSize(); i++) {
            if (books.getModel(i).getAuthor().equals(author)) {
                count++;
            }
        }
        return count;
    }
}
