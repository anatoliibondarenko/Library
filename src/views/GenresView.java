package views;

import base.Mode;
import models.Genre;
import utils.Validator;

import java.io.IOException;
import java.util.Arrays;

public class GenresView {

    private Genre model;

    public GenresView(Genre model) {
        this.model = model;
    }

    public void selectMode() {
        System.out.println("Select mode working:");
        System.out.println(Mode.getListModes() + ":\n");;


    }

    public void addGenre() {


        System.out.println("Input genre's name:");
        model.setName(Validator.validateString("Input genre's name:"));

        System.out.println("Input genre's description:");
        model.setDescription(Validator.validateString("Input genre's description:"));



    }
}
