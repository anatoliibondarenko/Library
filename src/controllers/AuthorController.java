package controllers;

import base.Controller;
import base.Mode;
import models.Author;
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
        StringBuilder builder = new StringBuilder("Authors\n");
        for (int i = 0; i < repository.getSize(); i++) {
            Author author1 = repository.getModel(i);
            builder.append(i + 1).append(". ")
                    .append(author1.getName()).append(" ")
                    .append(author1.getLastName()).append("\n");
        }
        view.displayModels(builder.toString());
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
