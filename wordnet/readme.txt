/******************************************************************************
 *  Name:Nate Heim     
 *
 *  Hours to complete assignment (optional):
 *
 ******************************************************************************/

Programming Assignment 3: WordNet


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/

I used a HashMap to store the information in synsets.txt. The keys are the nouns and the values are sets of synset IDs. This allows for efficient lookup of synsets for a given noun. I also used another HashMap to store the reverse mapping, from synset IDs to sets of nouns. This allows for efficient lookup of nouns for a given synset.

/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/

I used a Digraph to store the information in hypernyms.txt. The nodes represent the synsets and the edges represent the hypernym relationships between them. This allows for efficient traversal of the graph to find the shortest common ancestor of two synsets.

/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. For each method in the API, what
 *  is the order of growth of the worst-case running time as a function
 *  of the number of vertices V and the number of edges E in the digraph?
 *  For each method, what is the order of growth of the best-case running time?
 *
 *  If you use hashing, you may assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use something like a BreadthFirstDirectedPaths object, 
 *  don't forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description:

                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)                O(1)               O(V + E)

I mean...this should be obvious

ancestor(int v, int w)              O(1)               O(V + E)

In ShortestCommonAncestor I found that the worst-case running time is O(V + E), where V is the number of vertices and E is the number of edges in the digraph. The best-case running time is O(1) or O(h), where h is the height of the graph, which is at most V.

length(Iterable<Integer> v,    
       Iterable<Integer> w)         O(V + E)           O(V^2 * E)



ancestor(Iterable<Integer> v, 
         Iterable<Integer> w)      O(V + E)            O(V^2 * E)

Reasoning for last two:
    Best case: When the input subsets (v and w) are small and contain only one element each, the method only needs to traverse a single path in the graph, resulting in O(V + E) time complexity.
    Worst case: When the input subsets are large and contain many elements, the method needs to traverse the entire graph for each pair of vertices in the input subsets, resulting in O(V^2 * E) time complexity. This is because for each pair of vertices, the method needs to traverse the graph to find the shortest path, resulting in quadratic time complexity.

/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, but do include any 
 *  help from people (including course staff, TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Kyle, 

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
My PC's Pathing is all screwed up so i had to keep working on that till i got my program to run right


/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/

