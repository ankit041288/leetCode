import java.util.HashMap;

class LRUCache {
    private class Node{
        int value;
        int key;
        Node next;
        Node prev;
        Node(int k, int v){
            this.key=k;
            this.value=v;
        }
    }
    HashMap<Integer,Node> map = new HashMap<>();
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node curr = map.get(key);
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next=head.next;
        head.next.prev=curr;
        head.next=curr;
        curr.prev=head;
        return curr.value;

    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            curr.value=value;
            get(key);

        }
        else{
            Node n = new Node(key,value);
            head.next.prev=n;
            n.next=head.next;
            head.next=n;
            n.prev=head;
            if(map.size()==capacity){
                int k=tail.prev.key;
                tail.prev.prev.next=tail;
                tail.prev=tail.prev.prev;
                map.remove(k);
            }
            map.put(key,n);

        }

    }
}
