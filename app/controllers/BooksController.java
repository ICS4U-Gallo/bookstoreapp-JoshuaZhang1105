package controllers;
import Models.Book;
import com.google.inject.Inject;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import java.util.*;
import views.html.Books.*;

public class BooksController extends Controller{

    @Inject
    FormFactory formFactory;

    public Result index(){
        Set<Book> books = Book.allBooks();
        return ok(index.render(Collections.singleton(books)));
    }
    public Result create(){
        Form<Book> bookForm = formFactory.form(Book.class);
        return ok(create.render(bookForm));
    }
    public Result save(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
        Book book = bookForm.get();
        Book.add(book);
        return redirect(routes.BooksController.index());
    }
    public Result edit(Integer id){
        Book book = Book.findById(id);
        if(book==null){
            return notFound("book not found")
        }
        Form<Book> bookForm = formFactory.form(Book.class).fill(book);
        return ok(edit.render(bookForm));
    }
    public Result update(){
        Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
         Book book = bookForm.get();
         Book oldBook = Book.findById(book.id);
         if(oldBook == null){
             return notFound("Book not Found");
         }
         oldBook.title = book.title;
         oldBook.author = book.author;
         oldBook.price = book.price;

        return redirect(routes.BooksController.index());
    }
    public Result destory(Integer id){
        return TODO;
    }

    public Result show(Integer id){
        return TODO;
    }
}
