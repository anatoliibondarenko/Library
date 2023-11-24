package controllers;

import models.Genre;

import repositary.Genres;
import views.GenresView;

// Controller
public class GenreController {

    Genre model;
    GenresView view;
    Genres repositary = new Genres();

    public GenreController(Genre model, GenresView view) {
        this.model = model;
        this.view = view;
    }

    public void runApp() {
        view.selectMode();
        view.addGenre();
        save(model);
    }

    private void save(Genre model) {
        repositary.add(model);
    }
}
