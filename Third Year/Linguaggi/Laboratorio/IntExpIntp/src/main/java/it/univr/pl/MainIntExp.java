package it.univr.pl;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import java.util.*;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class MainIntExp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserire la stringa da parsare: ");
        String input = sc.nextLine();

        CharStream cs = CharStreams.fromString(input); // or "(2 + (5 * 3))"
        IntExpLexer lexer = new IntExpLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        IntExpParser parser = new IntExpParser(tokens);
        ParseTree tree = parser.main();

        System.out.println("Tree : " + tree);

        IntExpIntp interpreter = new IntExpIntp();
        System.out.println(interpreter.visit(tree));

        sc.close();
    }
}
