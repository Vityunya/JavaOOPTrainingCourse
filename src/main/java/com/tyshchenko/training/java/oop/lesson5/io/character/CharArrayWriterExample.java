package com.tyshchenko.training.java.oop.lesson5.io.character;

import com.tyshchenko.training.java.oop.util.Constants;

import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Alexander Tyshchenko.
 */
public class CharArrayWriterExample {

    public static void main(String[] args) {
        CharArrayWriter f = new CharArrayWriter();
        String s = "This should end up in the array";
        char buf[] = new char[s.length()];

        s.getChars(0, s.length(), buf, 0);

        try {
            f.write(buf);
        } catch(IOException e) {
            System.out.println("Error Writing to Buffer");
            return;
        }

        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("Into array");

        char c[] = f.toCharArray();
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]);
        }

        System.out.println("\nTo a FileWriter()");

        // Use try-with-resources to manage the file stream.
        try ( FileWriter f2 = new FileWriter(Constants.FILE_PATH_LESSON_5 + "/CharArrayWriterExample.txt") )
        {
            f.writeTo(f2);
        } catch(IOException e) {
            System.out.println("I/O Error: " + e);
        }

        System.out.println("Doing a reset");
        f.reset();

        for (int i=0; i<3; i++) f.write('X');

        System.out.println(f.toString());
    }

}