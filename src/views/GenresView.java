package views;

import base.Mode;
import models.Genre;
import utils.Validator;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GenresView {

    public Mode selectMode() {
        System.out.println("Select mode working:");
        System.out.println(Mode.getListModes() + ":");;
        return Validator.validateMode();

    }


    public void inputGenre(Genre model) {
        System.out.println("Input genre's name:");
        model.setName(Validator.validateString("Input genre's name:"));

        System.out.println("Input genre's description:");
        model.setDescription(Validator.validateString("Input genre's description:"));
    }

    public void displayAll(List<Genre> list) {
        System.out.println(list.toString());
    }
}
