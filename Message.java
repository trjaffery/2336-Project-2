public class Message extends Event {
    /**
     * Sets the insertion time and arrival time for this Event.
     * <br>
     * It is assumed that any information needed to compute the arrival time from the insertion time is passed into
     * the Event's constructor (for example a duration).  This method should be called from within the FutureEventList's
     * insert method.
     *
     * @param currentTime the current simulation time
     */
    @Override
    public void setInsertionTime(int currentTime) {

    }

    /**
     * Cancel the Event.
     * <br>
     * This occurs after the Event has been removed from the future event list, probably before the arrival time has
     * been reached.
     */
    @Override
    public void cancel() {

    }

    /**
     * Handle (or execute) the Event.
     * <br>
     * This occurs after the Event has been removed from the future event list, due to the arrival time being reached.
     * For example, if this Event represents a network message, then calling handle() will 'process' the message at the
     * destination host.  If the Event is a Timer, then this will execute whatever needs to be done upon timer expiry.
     */
    @Override
    public void handle() {

    }

    // returns a string representing the network message - we'll call this the string message
    public String getMessage() {
        return "";
    }

    // returns an int representing the source address (sender host) of this message
    public int getSrcAddress() {
        return 0;
    }

    // returns an int representing the destination address (receiving host) of this message
    // source/destination hosts will be neighbors
    public int getDestAddress() {
        return 0;
    }


    // setNextHop: this method has two parameters: the destination Host instance, and the distance between source
    // and destination host. This is used by the sendToNeighbor method in the Host class. To simplify things, we assume
    // that 1 distance = 1 simulation time (ie, if two connected hosts are a distance of 5 from each other, it’ll take
    // 5 simulation times units for a message to traverse from one to the other).
    public void setNextHop(Host destination, int distance) {

    }
}
