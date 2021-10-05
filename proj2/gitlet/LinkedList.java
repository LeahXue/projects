package gitlet;

public class LinkedList {
    private Node HEAD;
    private Node Master;
    public class Node{
        private Node prev;
        private Commit item;
        public Node(Node prev, Commit item) {
            this.prev = prev;
            this.item = item;
        }

        public Node getPrev(){
            return this.prev;
        }

        public Commit getCommit(){
            return this.item;
        }
    }

    public LinkedList(){
        this.HEAD = null;
        this.Master = null;
    }

    public void add(Commit commit){
        this.HEAD = new Node(this.HEAD, commit);
    }
}
