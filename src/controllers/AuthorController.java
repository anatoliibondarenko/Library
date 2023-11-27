package controllers;

import base.Controller;
import base.Mode;
import base.Repository;
import models.Author;
import repositary.Authors;
import views.AuthorView;

public class AuthorController implements Controller {

    private final AuthorView view;
    private final Authors repository;


    public AuthorController(Authors repository) {
        view = new AuthorView();
        this.repository = repository;
    }

    public void start() {
        Mode mode = view.selectMode();
        while (!mode.equals(Mode.EXIT)) {
            switch (mode) {
                case ADD:
                    Author author = new Author();
                    view.addModel(author);
                    repository.add(author);
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

                    StringBuilder builder = new StringBuilder("Authors\n");
                    for (int i = 0; i < repository.getSize(); i++) {
                        Author author1 = repository.getModel(i);
                        builder.append(i + 1).append(". ")
                                .append(author1.getName()).append(" ")
                                .append(author1.getLastName()).append("\n");
                    }
                    view.displayModels(builder.toString());

                }

            }
            mode = view.selectMode();
        }
    }


}
