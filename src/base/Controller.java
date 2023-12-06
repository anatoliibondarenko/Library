package base;

import utils.Validator;

public abstract class Controller {

     public void start() {
        Mode mode = selectMode();
        while (!mode.equals(Mode.EXIT)) {
            makeConcreteWork(mode);
            mode = selectMode();
        }
    }

    private void makeConcreteWork(Mode mode) {
        switch (mode) {
            case ADD:
                add();
                break;
            case REMOVE:
                remove();
                break;
            case DISPLAY: {
                display();
            }
        }
    }

    abstract public void display();

    abstract public void remove();

    abstract public void add();

    private Mode selectMode() {
        System.out.println("Select mode working:");
        System.out.println(Mode.getListModes() + ":");
        return Validator.validateMode();
    }
}
