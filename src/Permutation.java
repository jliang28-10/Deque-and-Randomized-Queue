import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Card Dealer: deal k distinct random cards from a deck of strings read from standard input.
 */
public class Permutation {

    /**
     * Deal exactly k cards uniformly at random from the deck supplied on standard input.
     * Read card names with a Scanner and print each dealt card at most once.
     * @param args command-line arguments; args[0] is the number k of cards to deal
     */
    public static void main(String[] args) throws FileNotFoundException {
        int k = Integer.parseInt(args[0]);

        Scanner scan = new Scanner(new File("src/cards.txt"));
        RandomizedQueue<String> deck = new RandomizedQueue<>();
        while(scan.hasNext()){
            String card = scan.next();
            deck.enqueue(card);
        }
        if(k>deck.size()){
            throw new Error("more cards requested than there are in deck");
        }
        Iterator<String> g = deck.iterator();
        for(int i=0; i<k;i++){
            System.out.println(g.next());
        }
        // TODO: Act as the card dealer: read the deck from standard input and deal k random cards.
        // Hint: use a Scanner to read card names: Scanner scanner = new Scanner(System.in);
        //       then use scanner.next() to read each card, and System.out.println() to print dealt cards.
    }
}
