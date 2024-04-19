import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

public class WordNet {
    private final Map<String, Set<String>> nounToSynsets;
    private final Map<String, Set<String>> synsetToNouns;
    private final Digraph graph;

    public WordNet(String synsets, String hypernyms) throws IOException {
        nounToSynsets = new HashMap<>();
        synsetToNouns = new HashMap<>();

        // Read synsets file
        In in = new In(synsets);
        while (!in.isEmpty()) {
            String[] parts = in.readLine().split(",");
            String synsetId = parts[0];
            String[] synset = parts[1].split(" ");
            for (String noun : synset) {
                nounToSynsets.computeIfAbsent(noun, x -> new HashSet<>()).add(synsetId);
                synsetToNouns.computeIfAbsent(synsetId, x -> new HashSet<>()).add(noun);
            }
        }

        // Read hypernyms file
        in = new In(hypernyms);
        graph = new Digraph(nounToSynsets.size());
        while (!in.isEmpty()) {
            String[] parts = in.readLine().split(",");
            int v = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);
            graph.addEdge(v, w);
        }
    }

    // all WordNet nouns
    public Iterable<String> nouns() {
        return nounToSynsets.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        return nounToSynsets.containsKey(word);
    }

    // a synset (second field of synsets.txt) that is a shortest common ancestor
    // of noun1 and noun2
    public String sca(String noun1, String noun2) {
        Set<String> synsets1 = nounToSynsets.get(noun1);
        Set<String> synsets2 = nounToSynsets.get(noun2);

        // Find common ancestor with shortest distance
        String sca = null;
        int distance = Integer.MAX_VALUE;
        for (String synset1 : synsets1) {
            for (String synset2 : synsets2) {
                int d = distance(synset1, synset2);
                if (d < distance) {
                    distance = d;
                    sca = synset1;
                }
            }
        }
        return sca;
    }

    // distance between noun1 and noun2

    public int distance(String noun1, String noun2) {
        Set<String> synsets1 = nounToSynsets.get(noun1);
        Set<String> synsets2 = nounToSynsets.get(noun2);

        ShortestCommonAncestor sca = new ShortestCommonAncestor(graph);
        return sca.length(Integer.parseInt(synsets1.iterator().next()), Integer.parseInt(synsets2.iterator().next()));
    }

   /* private int distance(String synset1, String synset2) {
        BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(graph, Integer.parseInt(synset1));
        return bfs.distTo(Integer.parseInt(synset2));
    }
    */


    // do unit testing of this class
    public static void main(String[] args) throws IOException {
        WordNet wnet = new WordNet("synsets.txt", "hypernyms.txt");
        // Test the methods
        System.out.println(wnet.nouns());
        System.out.println(wnet.isNoun("dog"));
        System.out.println(wnet.sca("dog", "cat"));
        System.out.println(wnet.distance("dog", "cat"));
    }
}