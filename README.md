# Algorithm-in-Java

Progress:
* 5/1 Go over basic data structure in Java
* 7/18 LC 60
* 7/30 LC 100
* 8/5 LC 117
* 8/9 LC 130
* 8/14 LC 147


Notes:
7/30/18

### Implement BinaryIndexedTree. 
* [Tutorial link](https://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/)
* [Pracetice Question Leetcode 307](https://leetcode.com/problems/range-sum-query-mutable/discuss/75766/Java-Binary-Indexed-Tree)

7/31/18
### Bit manipulation.
* Need more understanding
* Question [LC397](https://leetcode.com/problems/integer-replacement/discuss/87920/A-couple-of-Java-solutions-with-explanations)
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

Dynamic programming
* [LC 64](https://leetcode.com/problems/minimum-path-sum/description/)
* [LC 95/96](https://leetcode.com/problems/unique-binary-search-trees-ii/description/) **Not sure about the answer**
* **Reading tutorial** [This Link](https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/tutorial/)


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
