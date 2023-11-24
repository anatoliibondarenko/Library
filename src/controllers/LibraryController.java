package controllers;

import base.Subject;
import views.GenresView;
import views.LibraryView;

public class LibraryController {
    LibraryView view = new LibraryView();

    public void start() {
        Subject subject = view.selectSubject();
        while (!subject.equals(Subject.EXIT)) {
            switch (subject) {
                case AUTHORS:
                    System.out.println(Subject.AUTHORS);
                case BOOKS:
                    System.out.println(Subject.BOOKS);
                case GENRES:
                    GenresView view = new GenresView();
                    GenreController controller = new GenreController(view);
                    controller.start();
            }
            subject = view.selectSubject();
        }
    }
}
