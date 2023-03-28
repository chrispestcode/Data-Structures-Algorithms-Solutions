import java.util.*;

class LRUCache {
    private class Node {
        int key;
        int val;
        Node next = null;
        Node prev = null;
        public Node(final int key, final int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int key, final int val, final Node next, final Node prev) {
            this.key = key;
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private class DoublyLinkedList<T>{
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList() {
            this.head = this.tail = null;
            this.size = 0;
        }

        public void addToHead(Node node) {
            if(this.head == null) {
                this.tail = node;
            } else {
                Node head = this.head;
                head.prev = node;
                node.next = head;
            }
            this.head = node;
            this.size++;
        }

        public void addToTail(Node node) {
            if(this.tail == null) {
                this.head = node;
            } else {
                Node tail = this.tail;
                tail.next = node;
                node.prev = tail;
            }
            this.tail = node;
            this.size++;
        }

        public void removeFromTail() {
            Node tail = this.tail;
            if(tail != null && tail.prev != null) {
                tail.prev.next = null;
                this.tail = tail.prev;
            }
            this.size--;
        }
    }

    Map<Integer, Node> map = new HashMap<>();
    DoublyLinkedList<Integer> cache = new DoublyLinkedList<>();
    int capacity;
    public LRUCache(final int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node curr = this.cache.head;
        while(curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        if(this.map.containsKey(key)) {
           Node node = this.map.get(key);
           if(node.prev != null) {
            node.prev.next = node.next;
           }
           if(node.next != null) {
               node.next.prev = node.prev;
           }
            cache.addToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        while(this.cache.size >= this.capacity) {
            this.cache.removeFromTail();
        }
        Node node = new Node(key, value);
        this.map.put(key, node);
        this.cache.addToTail(node);
        //check size of list and if it's too big, remove tail
        //add new value to the front
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */