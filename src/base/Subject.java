package base;

public enum Subject {
    AUTHORS,
    BOOKS,
    GENRES,
    EXIT;

    public static String getListSubjects() {
        String str = "[";
        int i;
        for (i = 0; i < Subject.values().length - 1; i++) {
            str += Subject.values()[i].name() + " - " + (i + 1) + ", ";
        }
        return str += Subject.values()[Subject.values().length - 1].name() + " - " + (i + 1) + "]";
    }
}
