package views;

import base.ModelView;
import models.Genre;
import utils.Validator;

public class GenresView extends ModelView {

    public void inputGenre(Genre model) {
        model.setName(Validator.validateString("Input genre's name:"));
        model.setDescription(Validator.validateString("Input genre's description:"));
    }

    public boolean isNeedRemoveLinkedBooks() {
        displayMessage("Library has books with selected genres.");
        return Validator.getYesOrNo("Remove books - input (Y), fill removing genre of books by NULL - input (N).");
    }
}
