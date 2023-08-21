package org.example;

import com.github.javafaker.Artist;
import com.github.javafaker.Book;
import com.github.javafaker.Faker;
import java.util.Random;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Faker f = new Faker();

        System.out.println( "Hello World!........." );
        System.out.println(f.name());
        System.out.println(f.address().city());
        Book book = f.book();
        System.out.println(book.author());
        System.out.println(book.title());
        System.out.println(book);
        Artist artist = f.artist();
        System.out.println(artist.name());
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(1000,2000));





    }
}
