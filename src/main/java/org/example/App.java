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
        System.out.println(random.nextInt(10));
        System.out.println(random.nextInt(1000,2000));

        System.out.println();


        String str[] = new String[10];
        String res = "";


        for(int i = 0; i < 10; i++)
        {
            int r = random.nextInt(10);
            str[i] = Integer.toString(r);
            res= res + str[i];
        }
        System.out.println("Phone number is " + res);
        System.out.println("Phone Number is " + str[0] + str[1] + str[2] + str[3] + str[4] + str[5] + str[6] + str[7] + str[8] + str[9] );


















    }
}
