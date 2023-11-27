package base;

public enum Mode {
    ADD,
    DELETE,
    DISPLAY,
    EXIT;

    public static String getListModes() {
        StringBuilder result = new StringBuilder("[");
        int i;
        for (i = 0; i < Mode.values().length - 1; i++) {
            result.append(Mode.values()[i].name())
                    .append(" - ")
                    .append(i + 1)
                    .append(", ");
        }
        return result + (Mode.values()[Mode.values().length - 1].name() + " - " + (i + 1) + "]");
    }
}
