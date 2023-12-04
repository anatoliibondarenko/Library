package base;

public interface RepositoryCapable<E> {
    void add(E e);

    void remove(int id);

    int getSize();

    E getModel(int id);
}
