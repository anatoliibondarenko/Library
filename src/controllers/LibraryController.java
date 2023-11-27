package controllers;

import base.Controller;
import base.Subject;
import models.Book;
import repositary.Authors;
import repositary.Books;
import repositary.Genres;
import views.GenresView;
import views.LibraryView;

import java.io.*;

public class LibraryController {
    private Genres genres;
    private Authors authors;
    private Books books;

    private final File LIBRARY_DATA = new File("library.txt");

    LibraryView view = new LibraryView();

    public void start() {
        loadLibraryFromFile();

        Subject subject = view.selectSubject();
        Controller controller = null;
        while (!subject.equals(Subject.EXIT)) {
            switch (subject) {
                case AUTHORS:
                    controller = new AuthorController(authors);
                    break;
                case BOOKS:
                    controller = new BookController(books, authors, genres);
                    break;
                case GENRES:
                    controller = new GenreController(genres);
                    break;
               }

            controller.start();
            subject = view.selectSubject();
        }

        saveLibraryToFile();
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
