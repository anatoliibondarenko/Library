package controllers;

import base.Controller;
import base.Subject;
import repositary.Authors;
import repositary.Books;
import repositary.Genres;
import views.LibraryView;

import java.io.*;

public class LibraryController {
    public static Genres genres;
    public static Authors authors;
    public static Books books;

    private LibraryView view = new LibraryView();
    private final File LIBRARY_DATA = new File("library.txt");

    public void start() {
        loadLibraryFromFile();

        Subject subject = view.selectSubject();
        while (!subject.equals(Subject.EXIT)) {
            selectController(subject).start();
            subject = view.selectSubject();
        }

        saveLibraryToFile();
    }

    private Controller selectController(Subject subject) {
        Controller controller = null;
        switch (subject) {
            case AUTHORS:
                controller = AuthorController.INSTANCE;
                break;
            case BOOKS:
                controller = BookController.INSTANCE;
                break;
            case GENRES:
                controller = GenreController.INSTANCE;
                break;
           }
        return controller;
    }

    private void loadLibraryFromFile() {

        if (LIBRARY_DATA.exists()) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(LIBRARY_DATA))) {

                authors = (Authors) objectInputStream.readObject();
                books = (Books) objectInputStream.readObject();
                genres = (Genres) objectInputStream.readObject();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            books = new Books();
            authors = new Authors();
            genres = new Genres();
        }

    }

    private void saveLibraryToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(LIBRARY_DATA))) {

            objectOutputStream.writeObject(authors);
            objectOutputStream.writeObject(books);
            objectOutputStream.writeObject(genres);
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
