package base;

import models.Genre;
import utils.Validator;

public abstract class ModelView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public Mode selectMode() {
        System.out.println("Select mode working:");
        System.out.println(Mode.getListModes() + ":");;
        return Validator.validateMode();
    }


    public abstract void addModel(Model model);

    public void displayModels(String str) {
        System.out.println(str);
    }

    public int deleteModel() {
        return Validator.getIntNumber("Input number of deleted genre");
    }
}
