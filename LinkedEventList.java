public class LinkedEventList implements FutureEventList {
    // doubly linked list
    private Node head;
    private int size; // same as capacity
    int simTime;


    public LinkedEventList() {
        this.head = null;

        this.size = 0;
        this.simTime = 0;
    }

    /**
     * Remove and return the Event at the front of the list.
     * <br>
     * The FutureEventList is sorted by arrival time, so the Event at the front of the list will be the one with the
     * smallest arrival time.
     *
     * @return the Event at the front of the list
     */
    @Override
    public Event removeFirst() {
        if (this.size == 0) {
            return null;
        }
        Event removedEvent = this.head.getEvent();
        this.head = this.head.next;
        if (this.head != null) {
            this.head.prev = null;
        }
        simTime = removedEvent.getArrivalTime();
        this.size--;
        return removedEvent;
    }

    /**
     * Remove the Event e from the list, if it exists.
     *
     * @param e an Event to remove from the list
     * @return true if Event present in the list, false otherwise
     */
    @Override
    public boolean remove(Event e) {
        if (this.size == 0) {
            return false;
        }
        Node current = this.head;
        while (current != null) {
            if (current.getEvent().equals(e)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    // If current is the head
                    this.head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                }
                simTime = e.getArrivalTime();
                this.size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /**
     * Insert an Event into the list.
     * <br>
     * The FutureEventList maintains an ordering of Events based on arrival time.
     *
     * @param e an Event to insert into the list
     */
    @Override
    public void insert(Event e) {
        Node newNode = new Node(e);
        e.setInsertionTime(simTime);
        if (this.head == null) {
            // The list is empty, set head to the new node

            this.head = newNode;

            this.size++;
            return;
        }

        Node current = this.head;

        // Special case: Insert at the beginning if the new node's arrival time is the smallest
        if (newNode.getEvent().arrivalTime < this.head.getEvent().arrivalTime) {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
            this.size++;
            return;
        }

        // Find the correct position for insertion (just before the first larger element)
        while (current.next != null && current.next.getEvent().arrivalTime < e.arrivalTime) {
            current = current.next;
        }

        // Insert new node after 'current' (could be in the middle or at the end)
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        }
        current.next = newNode;
        newNode.prev = current;

        this.size++;
    }

    /**
     * Return the list size (number of Events in the list).
     *
     * @return the number of Events in the list
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Return the list capacity (total number of Events the list can store before having to resize it).
     *
     * @return total number of Events the list can store before having to resize it
     */
    @Override
    public int capacity() {
        return this.size;
    }

    /**
     * Return the current simulation time (arrival time of last Event)
     *
     * @return the current simulation time
     */
    @Override
    public int getSimulationTime() {
        return simTime;
    }
}
