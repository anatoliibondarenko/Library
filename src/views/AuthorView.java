package views;

import base.ModelView;
import models.Author;
import utils.Validator;

public class AuthorView extends ModelView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void addModel(Author model) {
        model.setName(Validator.validateString("Input author's name:"));
        model.setLastName(Validator.validateString("Input author's lastname:"));
    }

    public boolean isNeedRemoveLinkedBooks() {
        displayMessage("Library has books with selected author. Books will be removed too.");
        return Validator.getYesOrNo("Remove author - input (Y), discard removing  - input (N).");
    }
}
