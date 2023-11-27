package base;

import models.Genre;

public class ModelController<E> {

    RepositoryCapable<E> repository;
    ModelView view;
    Model model;

    public ModelController(RepositoryCapable<E> repository, ModelView view) {
        this.repository = repository;
        this.view = view;
    }

    public void start() {

        Mode mode = view.selectMode();

        while (!mode.equals(Mode.EXIT)) {
            switch (mode) {
                case ADD:
                    Model model = (Model) new Genre();
                    view.addModel(model);
                    repository.add(null); // TODO
                    break;
                case DELETE:
                    // TODO
//                    int id;
//                    while (true) {
//                        id = view.deleteModel();
//                        if (id > 0 && id <= repositary.getGenres().size()) {
//                            break;
//                        } else {
//                            view.displayMessage("Invalid number of genre: " + id) ;
//                        }
//                    }
//                  //  repositary.getGenres().remove(id - 1);
                    break;
                case DISPLAY: {
                    // TODO

//                    String format = "%-20s%s%n";
//                    StringBuilder builder = new StringBuilder(String.format(format, "Genre", "Description"));
//                    for (int i = 0; i < repositary.getGenres().size(); i++) {
//                        Genre line = repositary.getGenres().get(i);
//                        builder.append(String.format(format, (i + 1) + ". " + line.getName(), line.getDescription()));
//                    }
//                    view.displayModels(builder.toString());

                }
            }
            mode = view.selectMode();
        }
    }
}
