package base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Repository<T> implements Serializable {

    private final List<T> models;

    public Repository() {
        this.models = new ArrayList<>();
    }

    public void add(T t) {
        models.add(t);
    }

    public void remove(int id) {
        models.remove(id);
    }

    public int getSize() {
        return models.size();
    }

    public T getModel(int id) {
        return models.get(id);
    }

    public String displayAll() {
        String string;
        if (getSize() > 0) {
            string = getModelsString();
        } else {
            string = "Nothing to display.";
        }
        return string;
    }

    private String getModelsString() {
        String string;
        StringBuilder builder = new StringBuilder();
        int i;
        for (i = 0; i < getSize() - 1; i++) {
            builder.append(i + 1).append(". ").append(getModel(i).toString()).append("\n");
        }
        builder.append(i + 1).append(". ").append(getModel(i).toString());
        string = builder.toString();
        return string;
    }
}
