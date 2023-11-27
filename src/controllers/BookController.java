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
    private final Books repository;
    private final Authors authors;
    private final Genres genres;

    public BookController(Books repository, Authors authors, Genres genres) {
        view = new BookView();
        this.repository = repository;
        this.authors = authors;
        this.genres = genres;
    }

    public void start() {
        Mode mode = view.selectMode();
        while (!mode.equals(Mode.EXIT)) {
            switch (mode) {
                case ADD:
                    view.displayMessage("Chose number of book's author");
                   // authors.
                    Book book = new Book();
                    view.addModel(book);
                    repository.add(book);
                    break;

                case DELETE:
                    int id;
                    while (true) {
                        id = view.deleteModel();
                        if (id > 0 && id <= repository.getSize()) {
                            break;
                        } else {
                            view.displayMessage("Invalid number of genre: " + id);
                        }
                    }
                    repository.remove(id - 1);
                    view.displayMessage("Author "+ (id - 1) + " was deleted successful.");
                    break;

                case DISPLAY: {
//
//                    StringBuilder builder = new StringBuilder("Authors\n");
//                    for (int i = 0; i < repository.getSize(); i++) {
//                        Author author1 = repository.getModel(i);
//                        builder.append(i + 1).append(". ")
//                                .append(author1.getName()).append(" ")
//                                .append(author1.getLastName()).append("\n");
//                    }
//                    view.displayModels(builder.toString());

                }

            }
            mode = view.selectMode();
        }
    }


}
