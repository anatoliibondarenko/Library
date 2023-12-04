package views;

import base.Mode;
import models.Author;
import utils.Validator;

public class AuthorView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public Mode selectMode() {
        System.out.println("Select mode working:");
        System.out.println(Mode.getListModes() + ":");;
        return Validator.validateMode();
    }

    public void displayModels(String str) {
        displayMessage(str);
    }

    public int deleteModel() {
        return Validator.getIntNumber("Input number of author to delete ");
    }

    public void addModel(Author model) {
        System.out.println("Input author's name:");
        model.setName(Validator.validateString("Input author's name:"));

        System.out.println("Input author's lastname:");
        model.setLastName(Validator.validateString("Input author's lastname:"));
    }
}
