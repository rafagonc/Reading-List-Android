package goncalves.com.readinglist.Factories.Entities.Concrete;

import android.app.Activity;

import com.google.inject.Inject;

import goncalves.com.readinglist.DAOs.Abstract.AuthorDataAccessObject;
import goncalves.com.readinglist.DAOs.Abstract.BookDataAccessObject;
import goncalves.com.readinglist.Entities.Abstract.Author;
import goncalves.com.readinglist.Entities.Abstract.Book;
import goncalves.com.readinglist.Entities.Abstract.TransientBook;
import goncalves.com.readinglist.Factories.Entities.Abstract.AuthorFactory;
import goncalves.com.readinglist.Factories.Entities.Abstract.BookFactory;

/**
 * Created by rafagonc on 1/5/16.
 */
public class BookFactoryImpl implements BookFactory {

    @Inject BookDataAccessObject bookDataAccessObject;
    @Inject AuthorFactory authorFactory;
    @Inject AuthorDataAccessObject authorDataAccessObject;


    public BookFactoryImpl() {
    }

    @Override
    public Book newBook() {
        Book newBook = (Book)this.bookDataAccessObject.insert();
        return newBook;
    }

    @Override
    public Book newBookFromTransientBook(TransientBook transientBook, Activity activity) {
        Book book = newBook();
        book.setName(transientBook.getName());
        Author author = authorDataAccessObject.findByName(transientBook.getAuthorString());
        book.setAuthor(author != null ? author : authorFactory.newAuthor(transientBook.getAuthorString()));
        book.setFilename(transientBook.createFilenameForSavedCoverImage(activity));
        return book;
    }
}
