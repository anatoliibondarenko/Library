package base;

import utils.Validator;
//
public abstract class ModelView {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public int getChoiceNumber(String message, int maxValue) {
        return Validator.getIntNumber(message, maxValue);
    }
}
