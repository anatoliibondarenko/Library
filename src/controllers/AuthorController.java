package controllers;

import base.Controller;
import base.Mode;
import models.Author;
import models.Genre;
import repositary.Authors;
import views.AuthorView;

public class AuthorController implements Controller {

    public static final AuthorController INSTANCE = new AuthorController();

    private final AuthorView view;
    private final Authors repository;

    public AuthorController() {
        view = new AuthorView();
        repository = LibraryController.authors;
    }


    public void start() {
        Mode mode = view.selectMode();
        while (!mode.equals(Mode.EXIT)) {
            switch (mode) {
                case ADD:
                    addAuthor();
                    break;
                case DELETE:
                    deleteAuthor();
                    break;
                case DISPLAY: {
                    displayAuthors();
                }
            }
            mode = view.selectMode();
        }
    }

    private void displayAuthors() {
        String str;
        if (repository.getSize() > 0) {
            StringBuilder builder = new StringBuilder("Authors\n");
            builder.append(repository.displayAll());
//            int i;
//            Author author;
//            for (i = 0; i < repository.getSize() - 1; i++) {
//                author = repository.getModel(i);
//                builder.append(i + 1).append(". ")
//                        .append(author.getName()).append(" ")
//                        .append(author.getLastName()).append("\n");
//            }
//            author = repository.getModel(i);
//            builder.append(i + 1).append(". ")
//                    .append(author.getName()).append(" ")
//                    .append(author.getLastName());

            str = builder.toString();
        } else {
            str = "Nothing to display.";
        }

        view.displayMessage(str);
    }

    private void deleteAuthor() {
        int id;
        while (true) {
            id = view.deleteModel();
            if (id > 0 && id <= repository.getSize()) {
                break;
            } else {
                view.displayMessage("Invalid number of author: " + id);
            }
        }
        repository.remove(id - 1);
        view.displayMessage("Author " + id + " was deleted successful.");
    }

    private void addAuthor() {
        Author author = new Author();
        view.addModel(author);
        repository.add(author);
    }
}
