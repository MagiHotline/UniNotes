package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import java.util.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire la stringa da parsare: ");
        String input = sc.nextLine();

        CharStream cs = CharStreams.fromString(input); // or "(2 + (5 * 3))"

        MagiLexer lexer = new MagiLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MagiParser parser = new MagiParser(tokens);
        ParseTree tree = parser.main();

        System.out.println("Tree : " + tree.toStringTree(parser));

        // Interpreta i token in interi
        Interpreter interprete_int = new Interpreter();
        System.out.println(interprete_int.visit(tree));

        sc.close();
    }
}
