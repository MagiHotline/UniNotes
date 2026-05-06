package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {

        String path, input = "";

        // Read the file if given
        if (args.length > 0) {
            path = args[0];
            File src = new File(path);

            try (Scanner myReader = new Scanner(src)) {
              while (myReader.hasNextLine()) {
                input += myReader.nextLine();
              }
            } catch (FileNotFoundException e) {
              System.out.println("File was not found");
              e.printStackTrace();
            }
        } else  {
            Scanner sc = new Scanner(System.in);
            System.out.println("Inserire la stringa da parsare: ");
            input = sc.nextLine();
            sc.close();
        }

        System.out.println("CODE: \n" + input);

        CharStream cs = CharStreams.fromString(input);
        MagiLexer lexer = new MagiLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MagiParser parser = new MagiParser(tokens);
        ParseTree tree = parser.main();

        System.out.println("Tree : " + tree.toStringTree(parser));

        // Interpreta i token in interi
        Interpreter interpreter = new Interpreter();
        System.out.println(interpreter.visit(tree));

    }
}
