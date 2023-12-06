package controllers;

import base.Controller;
import models.Author;
import models.Book;
import models.Genre;
import repositary.Authors;
import repositary.Books;
import repositary.Genres;
import views.BookView;

public class BookController extends Controller {
    public static final BookController INSTANCE = new BookController();

    private final BookView view;
    private final Books books;
    private final Authors authors;
    private final Genres genres;

    public BookController() {
        view = new BookView();
        books = LibraryController.books;
        authors = LibraryController.authors;
        genres = LibraryController.genres;
    }

    public void add() {
        Book book = new Book();

        view.displayMessage("Chose author (input the number):");
        book.setAuthor(selectAuthor());

        book.setName(view.inputName());
        book.setYearPublication(view.inputYearPublication());

        view.displayMessage("Chose number of book's genre");
        book.setGenre(selectGenre());

        book.setDescription(view.inputDescription());

        books.add(book);
        addBookToAuthor(book);
    }

    public void remove() {
        int id;
        while (true) {
            id = view.deleteModel();
            if (id > 0 && id <= books.getSize()) {
                break;
            } else {
                view.displayMessage("Invalid number of book: " + id);
            }
        }
        books.remove(id - 1);
        view.displayMessage("Book " + id + " was deleted successful.");
    }

    public void display() {
        if (books.getSize() > 0) {
            view.displayMessage("Book: ");
        }
        view.displayMessage(books.displayAll());
    }

    private Author selectAuthor() {
        view.displayMessage(authors.displayAll());
        int id = view.getChoiceNumber("Input number of the author", authors.getSize());
        return authors.getModel(id - 1);
    }

    private Genre selectGenre() {
        view.displayMessage(genres.displayAll());
        int id = view.getChoiceNumber("Input number of the genre", authors.getSize());
        return genres.getModel(id - 1);
    }

    private void addBookToAuthor(Book book) {
        Author author = book.getAuthor();
        for (int i = 0; i < authors.getSize(); i++) {
            if (authors.getModel(i).equals(author)) {
                authors.getModel(i).getListBooks().add(book);
                break;
            }
        }
    }
}
