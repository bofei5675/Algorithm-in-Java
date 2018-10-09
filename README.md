# Algorithm-in-Java

Progress:
* 5/1 Go over basic data structure in Java
* 7/18 LC 60
* 7/30 LC 100
* 8/5 LC 117
* 8/9 LC 130
* 8/14 LC 147
* 9/9 LC 176

Notes:
7/30/18

### Implement BinaryIndexedTree. 
* [Tutorial link](https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/)
* [Pracetice Question Leetcode 307](https://leetcode.com/problems/range-sum-query-mutable/discuss/75766/Java-Binary-Indexed-Tree)

7/31/18
### Bit manipulation.
* Need more understanding
* Question [LC397](https://leetcode.com/problems/integer-replacement/discuss/87920/A-couple-of-Java-solutions-with-explanations)
* LC 401
```java
Integer.countBits(h * 64 + m) == num // count 1 bits in the integer
```

* **Do some more reading (TO DO)**
  * [detail explaination of bit manupulation 8/2](https://leetcode.com/problems/sum-of-two-integers/discuss/84278/A-summary:-how-to-use-bit-manipulation-to-solve-problems-easily-and-efficiently)
  * [Java Bit Operator 8/2](https://www.vojtechruzicka.com/bit-manipulation-java-bitwise-bit-shift-operations/)
  * [Binary Arithmetic](https://ryanstutorials.net/binary-tutorial/binary-arithmetic.php)
* LC 389 and LC 138 Find single number
  * if one element only shown at once but others show twice
  * we should use **XOR** to deal with this problem
  
### Priority Queue (Heap)
* Data Structure, [Implementation](https://www.geeksforgeeks.org/priority-queue-set-1-introduction)
* Understand [Java Comparator](https://www.geeksforgeeks.org/implement-priorityqueue-comparator-java/)
* Question [LC 451](https://leetcode.com/problems/sort-characters-by-frequency/discuss/93420/Java-O(n)-Bucket-Sort-Solution-O(nlogn)-PriorityQueue-Solution-easy-to-understand) and LC 347

8/18
### fibonacci problem **Need better understanding**
* [LC 70](https://leetcode.com/problems/climbing-stairs/discuss/)

### Dynamic programming
* [LC 64](https://leetcode.com/problems/minimum-path-sum/description/)
* [LC 95/96](https://leetcode.com/problems/unique-binary-search-trees-ii/description/) **Not sure about the answer**
* **Reading tutorial** [This Link](https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/)
* Coin change problem Coin Change I and II.

### Sort 
* LC 179
* Learn to use Java Comparator Class
```java
Comparator<String> comp = new Comparator<String>(){
  @Override
  public int compare(String s1,String s2){
    return (s2 + s1).compare(s1 + s2);
  }
};

Arrays.sort(arr,comp);
```
* In the version of java 8 and after, we have a better way for the pointer. From LC 658 Binary Tree Search
```java
 Collections.sort(arr, (a,b) -> a == b ? a - b : Math.abs(a-x) - Math.abs(b-x));
```
* String builder is faster and robust

### Topological Sort BFS/DFS
* [LC 207](https://leetcode.com/problems/course-schedule/discuss/58523/JAVA-Easy-Version-To-UnderStand!!!!!!!!!!!!!!!!!)
* Kahn's Algorithm
```
L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edge
while S is non-empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S
if graph has edges then
    return error   (graph has at least one cycle)
else 
    return L   (a topologically sorted order)
```
* DFS (In practice, DFS is shown slower than BFS)
```
L ← Empty list that will contain the sorted nodes
while there are unmarked nodes do
    select an unmarked node n
    visit(n) 
    
function visit(node n)
    if n has a permanent mark then return
    if n has a temporary mark then stop   (not a DAG)
    mark n temporarily
    for each node m with an edge from n to m do
        visit(m)
    mark n permanently
    add n to head of L
```

### Trie (Prefix Tree)
* [Tutorial](https://leetcode.com/articles/implement-trie-prefix-tree/)
* Implement Trie Tree in this Repo
* Various applications


### Lexicographical Order
* LC 386
* [Definition](http://mathworld.wolfram.com/LexicographicOrder.html)

### Math Problem
* LC 415 Add String
* Compute number from String
* StringBuilder.reverse()
```Java
int x = num1.charAt(i) - '0';
```

### Reservoir Sampling
* LC 382 Count sample size within constructor is much faster than reservoir sampling. But reservoir sampling does not require the size of the sample
* [Blog Reading](https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling)
* LC 398 Pick up an index.
```java
// how the possibility works
Random rand = new Random();
if( rand.nextInt(countOfItem) == 0 ) // pick this one;
```


### Iterator Design
* LC 284
* Make use of Java iterator

### Window Sliding
* [LC 567](https://leetcode.com/problems/permutation-in-string/discuss/102588/Java-Solution-Sliding-Window)
* Create sliding window substring to identify permutation
```java
int[] map = new int[26];
        
for(int i = 0 ; i < s1.length(); i ++){
    map[s1.charAt(i) - 'a'] ++;    
    map[s2.charAt(i) - 'a'] --;
}
if(allZeroes(map)) return true;
for(int i = 0; i < s2.length() - windowSize; i ++){
    map[s2.charAt(i + windowSize) - 'a'] --;
    map[s2.charAt(i) - 'a'] ++;
    if(allZeroes(map)) return true;
}
```

### Greedy Algorithm
* [LC 452](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/discuss/93703/Share-my-explained-Greedy-solution-as-the-highest-voted-java-solution-right-now-is-not-ideal)

### Sort
* Insertion sort O(n) -> O(n^2)
* Selection sort O(n^2)
* Merge sort ***divide and conqueor*** Implemented
* Quick sort, **randomized algorithm**, applied expectation and random variable to solve the running time.
* Heap sort Implemented 
* Stability of a sorting algorithm read this [post](https://stackoverflow.com/questions/1517793/what-is-stability-in-sorting-algorithms-and-why-is-it-important)
* Linear time sort O(n)
 * Counting sort - required previous knowledge the range of array
 * Bucket sort - Review for the random variable. Assume the uniform distribution. Proof by **Linearity of Expectation**
* Patience sort - find minimum number of ascending subsequence from an array. Implement by the priority queue.  
### Hash Table
* LC 560 Store the cumulative sum and number of appearance 
