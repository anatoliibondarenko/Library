package views;

import base.Subject;
import utils.Validator;

public class LibraryView {

    public Subject selectSubject() {
        System.out.println("Select subject to working:");
        System.out.println(Subject.getListSubjects() + ":");
        return Validator.validateSubject();
    }
}
