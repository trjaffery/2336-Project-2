public class Node {
    private final Event item;
    public Node next;
    public Node prev;

    public Node(Event item) {
        this.item = item;
        this.next = null;
        this.prev = null;
    }

    public Event getEvent() {
        return this.item;
    }
}