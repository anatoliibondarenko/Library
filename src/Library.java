import controllers.GenreController;
import controllers.LibraryController;
import models.Genre;
import views.GenresView;

public class Library {

    public static void main(String[] args) {

//        LibraryController controller = new LibraryController();
//        controller.runApp();

        Genre model = new Genre();
        GenresView view = new GenresView(model);
        GenreController controller = new GenreController(model, view);


        controller.runApp();
    }
}
