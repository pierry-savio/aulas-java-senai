package org.example;

import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "library") // Cria a tag principal no xml
public class Library {
    @JacksonXmlElementWrapper(localName = "books") // Cria as tags livros do xml
    @JacksonXmlProperty(localName = "book") // Cria as tags livro no xml
    private List<Book> books = new ArrayList<>();

    public Library(){}

    public Library(List<Book> books){
        this.books = books;
    }

    public List<Book> getBooks(){
        return books;
    }

    public void setBooks(List<Book> books){
        this.books = books;
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void removeBookByIndex(int index){
        books.remove(index);
    }

    public void removeBookByTitle(String title){
        for (int i = 0; i<books.size(); i++){
            if (books.get(i).getTitle().equals(title)){
                books.remove(i);
            }
        }
    }
}
