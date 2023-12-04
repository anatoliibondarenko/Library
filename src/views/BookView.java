package views;

import base.Mode;
import models.Book;
import utils.Validator;

public class BookView {


    public void displayMessage(String message) {
        System.out.println(message);
    }

    public Mode selectMode() {
        System.out.println("Select mode working:");
        System.out.println(Mode.getListModes() + ":");;
        return Validator.validateMode();

    }

    public void inputAuthor(Book model) {
//
//        System.out.println("Input author's name:");
//        model.setName(Validator.validateString("Input author's name:"));
//
//        System.out.println("Input author's lastname:");
//        model.setLastName(Validator.validateString("Input author's lastname:"));
    }

    public void displayModels(String str) {
        System.out.println(str);
    }

    public int deleteModel() {
        return Validator.getIntNumber("Input number of deleted genre");
    }

    public int makeChoice(String message) {
        return Validator.getIntNumber(message);
    }

    public void addModel(Book book) {


    }

    public void inputName(Book book) {
        // System.out.println("Input book's name:");
        book.setName(Validator.validateString("Input book's name:"));
    }

    public int inputYearPublication() {
        return Validator.validateYearPublication();
    }

    public String inputDescription() {

    }
}
