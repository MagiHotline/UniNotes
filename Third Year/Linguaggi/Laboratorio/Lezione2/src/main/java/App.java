import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    System.out.println("Inserisci la stringa da parsare: ");
    String input = scan.nextLine();

    // Create a CharStream from the input string
    CharStream cs = CharStreams.fromString(input);

    // Create a TokenSource from the CharStream using the BinWords grammar
    NatLexer lexer = new NatLexer(cs);

    // Obtain the tokens from the TokenSource as a TokenStream
    CommonTokenStream tokens = new CommonTokenStream(lexer);

    // Create a parser that parses the BinWords grammar
    NatParser parser = new NatParser(tokens);

    // Execute the grammar from the 'main' nonterminal symbol
    ParseTree tree = parser.main();
  }


}
