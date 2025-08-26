import java.util.TreeMap;

public class PhraseAnalyzer {
    public static TreeMap<String, Integer> wordCount (String sentence){
        sentence = sentence.toLowerCase().replaceAll("[?.!]", " ");
        String[] words = sentence.split("\\s+");

        TreeMap<String, Integer> map = new TreeMap<>();

        for (String word:words){
            if (!word.isEmpty()){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return map;
    }
    
}
