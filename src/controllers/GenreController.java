package controllers;

import base.Mode;
import models.Genre;
import repositary.Genres;
import views.GenresView;

// Controller
public class GenreController {

  //  Genre model;
    GenresView view;
    Genres repositary = new Genres();

    public GenreController(GenresView view) {
      //  this.model = model;
        this.view = view;
    }

    public void start() {
        Mode mode = view.selectMode();
        while (!mode.equals(Mode.EXIT)) {
            switch (mode) {
                case ADD:
                    Genre genre = new Genre();
                    view.inputGenre(genre);
                    repositary.add(genre);
                    break;
                case EDIT:
                    System.out.println(Mode.EDIT);
                case DELETE:
                    System.out.println(Mode.DELETE);
                case DISPLAY:
                    view.displayAll(repositary.getGenres());

            }
            mode = view.selectMode();
        }
//        view.addGenre();
//        save(model);
    }

    private void save(Genre model) {
        repositary.add(model);
    }
}
