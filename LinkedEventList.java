public class LinkedEventList implements FutureEventList {
    // doubly linked list
    private Node head;
    private Node next;
    private Node prev;
    private int size; // same as capacity
    int simTime;


    public LinkedEventList() {
        this.head = null;
        this.next = null;
        this.prev = null;
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
        return null;
    }

    /**
     * Remove the Event e from the list, if it exists.
     *
     * @param e an Event to remove from the list
     * @return true if Event present in the list, false otherwise
     */
    @Override
    public boolean remove(Event e) {
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
        if (size == 0) {
            this.head = e;
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
