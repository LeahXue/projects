package byow.Core;

public class UnionFind {

    /* TODO: Add instance variables here. */
    public int[] union;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        // TODO: YOUR CODE HERE
        this.union = new int[N];
        for (int i = 0; i < N; i ++){
            union[i] = -1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        // TODO: YOUR CODE HERE
        int index = v;
        while (union[index] >= 0){
            index = union[index];
        }
        return -union[index];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        // TODO: YOUR CODE HERE
        return union[v];
    }

    /* Returns true if nodes V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO: YOUR CODE HERE
        if (v1 < 0 || v2 < 0){
            return false;
        }
        if (v1 == v2){
            return true;
        }
        return connected(parent(v1),v2) || connected(v1,parent(v2));
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        // TODO: YOUR CODE HERE
        if (v < 0 || v >= union.length){
            throw new IllegalArgumentException("index out of range");
        }
        if (union[v] < 0){
            return v;
        }
        int root = find(parent(v));
        union[v] = root;
        return root;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing a item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        // TODO: YOUR CODE HERE
        int root1 = find(v1);
        int root2 = find(v2);
        if (root1 == root2){
            return;
        }
        if (sizeOf(root1) > sizeOf(root2)){
            union[root1] = union[root1] + union[root2];
            union[root2] = root1;
        }else{
            union[root2] = union[root1] + union[root2];
            union[root1] = root2;
        }
    }
}
