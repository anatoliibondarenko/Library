package views;

import base.ModelView;
import utils.Validator;

public class BookView extends ModelView {

    public int deleteModel() {
        return Validator.getIntNumber("Input number of deleted book");
    }

    public String inputName() {
        return Validator.validateString("Input book's name:");
    }

    public int inputYearPublication() {
        return Validator.validateYearPublication();
    }

    public String inputDescription() {
        return Validator.validateString("Input book`s description:");
    }
}
