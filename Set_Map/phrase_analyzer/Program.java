 import java.util.TreeMap;

    public class Program {
        public static void main(String[] args) {
            TreeMap<String, Integer> phraseCount1 = PhraseAnalyzer.wordCount("Three dishes of wheat for three sad tigers");
            TreeMap<String, Integer> phraseCount2 = PhraseAnalyzer.wordCount("Let go of the aunt, lizard! Lizard, let go of the aunt!");
            TreeMap<String, Integer> phraseCount3 = PhraseAnalyzer.wordCount("Stack of straw and old tile. Straw in the stack and old tile. Stack of tile and old straw.");
            TreeMap<String, Integer> phraseCount4 = PhraseAnalyzer.wordCount("Under the sink, there is a chick that chirps, the more the sink drips, the more the chick chirps!");

            System.out.println(phraseCount1);
            System.out.println(phraseCount2);
            System.out.println(phraseCount3);
            System.out.println(phraseCount4);
        }    
    }