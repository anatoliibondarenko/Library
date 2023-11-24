package base;

public enum Mode {
    ADD,
    EDIT,
    DELETE,
    DISPLAY,
    EXIT;

    public static String getListModes() {
        String result = "[";
        for (int i = 0; i < Mode.values().length - 1; i++) {
            result += Mode.values()[i].name() + " - " + (i + 1) + ", ";
        }
        return result += Mode.values()[Mode.values().length - 1].name() + " - 0]";
    }
}
