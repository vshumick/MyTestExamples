package testTasks210516;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a text file, find the top n frequent words from the text;
 * if there is a tie, output the words in the order of appearance in text.
 *
 * print top 2 words from below text
 *
 * +--------+--------------+
 * | line # | text in line |
 * +--------+--------------+
 * |      1 | a b          |
 * |      2 | c d e f g    |
 * +--------+--------------+
 *
 * Expected output for above should be: a, b
 *
 */


class Solution2 {

    public class WordFreq implements Comparable<WordFreq> {
        int frequency = 0;
        String word = "";

        public WordFreq(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(WordFreq o) {
            if(frequency > o.frequency){
                return -1;
            } else {
                return 1; //if there is a tie, output the words in the order of appearance in text
            }
        }
    }

    private Collection<WordFreq> getTopWords(File f, int n) throws Exception {
        Collection<WordFreq> collection = new LinkedList<WordFreq>();

        FileReader file = new FileReader(f);
        BufferedReader br = new BufferedReader(file);

        Map<String, Integer> map = new LinkedHashMap<>();
        String line = "";

        while((line = br.readLine()) != null) {
            String string[] = line.toLowerCase().split("([,.;!?\\s]+)");
            for(String s : string){
                map.put(s, map.containsKey(s) ? map.get(s) + 1 : 1);
            }
        }

        Set<WordFreq> set = new TreeSet();

        map.entrySet().forEach( entry -> {set.add(new WordFreq(entry.getKey(), entry.getValue()));
        });

        collection = set.stream().limit(n).collect(Collectors.toList());

        return collection;
    }

    private void printCollection(Collection<WordFreq> collection) {
        for(WordFreq wordFreq: collection) {
            System.out.println(wordFreq.word + ":" + wordFreq.frequency);
        }
    }

    public static void main(String[] args) throws Exception {
        Solution2 topFreq = new Solution2();

        File f = new File("C:\\Users\\viktor.shumik\\IdeaProjects\\TestProject\\src\\sample.txt");
        Collection<WordFreq> collection = topFreq.getTopWords(f, 3);

        topFreq.printCollection(collection);
    }
}