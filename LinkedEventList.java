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
        // if list is empty
        if (this.size == 0) {
            return null;
        }
        // if list has events
        Event removedEvent = this.head.getEvent();
        Node newHead = this.head.next;
        this.head = newHead;
        newHead.prev = null;
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
        // if size is 0
        if (this.size == 0) {
            return false;
        }
        if (this.head.getEvent() == e) {
            // node to remove is the first one
            this.head = this.head.next;
            this.head.prev = null;

            this.size--;
            return true;
        }



        Node transverse = this.head.next;
        while (transverse != null) {
            if (transverse.getEvent().equals(e)) {
                transverse.prev.next = transverse.next;
                transverse.next.prev = transverse.prev;
                this.size--;
                return true;
            }
            transverse = transverse.next;
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
        if (this.size == 0) {
            this.head = newNode;
            return;
        }
        Node transverse = this.head;
        while (transverse != null) {
            if (transverse.getEvent().arrivalTime > transverse.next.getEvent().arrivalTime) {

            }
        }

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
