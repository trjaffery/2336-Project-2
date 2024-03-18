public class SimpleHost extends Host {

    /**
     * This is called when a host receives a Message event from a neighboring host.
     *
     * @param msg the Message event received
     */
    @Override
    protected void receive(Message msg) {

    }

    /**
     * This is called after a Timer event expires, and enables you to write code to do something upon timer
     * expiry.  A timer expires when the duration set for the timer is reached.
     *
     * @param eventId the event id of the Timer event which expired
     */
    @Override
    protected void timerExpired(int eventId) {

    }

    /**
     * This is called after a Timer event is cancelled, and enables you to write code to do something upon timer
     * cancellation.
     *
     * @param eventId the event id of the Timer event which was cancelled
     */
    @Override
    protected void timerCancelled(int eventId) {

    }
}
