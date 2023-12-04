package controllers;

import base.Controller;
import base.Mode;
import base.Repository;
import models.Author;
import models.Book;
import models.Genre;
import repositary.Authors;
import repositary.Books;
import repositary.Genres;
import views.BookView;

public class BookController implements Controller {

    private final BookView view;
    private final Books books;
    private final Authors authors;
    private final Genres genres;

    public BookController(Books repository, Authors authors, Genres genres) {
        view = new BookView();
        this.books = repository;
        this.authors = authors;
        this.genres = genres;
    }

    public void start() {
        Mode mode = view.selectMode();
        while (!mode.equals(Mode.EXIT)) {
            switch (mode) {
                case ADD:
                    Book book = new Book();

                    view.displayMessage("Chose author (input the number):");
                    book.setAuthor(selectAuthor());

                    view.inputName(book);
                    view.inputYearPublication();

                    view.displayMessage("Chose number of book's genre");
                    book.setGenre(selectGenre());

                    book.setDescription(view.inputDescription(book));

                    books.add(book);
                    break;

                case DELETE:
                    int id;
                    while (true) {
                        id = view.deleteModel();
                        if (id > 0 && id <= books.getSize()) {
                            break;
                        } else {
                            view.displayMessage("Invalid number of genre: " + id);
                        }
                    }
                    books.remove(id - 1);
                    view.displayMessage("Author " + (id - 1) + " was deleted successful.");
                    break;

                case DISPLAY: {
                    view.displayMessage(books.displayAll());
                }

            }
            mode = view.selectMode();
        }
    }

    private Genre selectGenre() {
        view.displayMessage(genres.displayAll());
        int id = selectNumber(genres);
        return genres.getModel(id - 1);

    }

    private Author selectAuthor() {
        view.displayMessage(authors.displayAll());
        int id = selectNumber(authors);
        return authors.getModel(id - 1);
    }

    private int selectNumber(Repository repository) {
        int id;
        while (true) {
            id = view.makeChoice("Input number ");
            if (id > 0 && id <= repository.getSize()) {
                return id;
            } else {
                view.displayMessage("Invalid number: " + id);
            }
        }
    }
}
