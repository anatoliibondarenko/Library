package views;

import base.Mode;
import models.Genre;
import utils.Validator;

import java.util.List;

public class GenresView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public Mode selectMode() {
        System.out.println("Select mode working:");
        System.out.println(Mode.getListModes() + ":");;
        return Validator.validateMode();

    }


    public void inputGenre(Genre model) {
        //System.out.println("Input genre's name:");
        model.setName(Validator.validateString("Input genre's name:"));

       // System.out.println("Input genre's description:");
        model.setDescription(Validator.validateString("Input genre's description:"));
    }

    public void displayGenres(String str) {
        System.out.println(str);
    }

    public int deleteGenre() {
        return Validator.getIntNumber("Input number of deleted genre");
    }

    public boolean isNeedRemoveLinkedBooks(Genre genre) {
        displayMessage("Library has books with selected genres.");
        return Validator.getYesOrNo("Remove books - input (Y), fill removing genre of books by NULL - input (N).");
    }
}
