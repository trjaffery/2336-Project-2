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
        // TODO
    }

    /**
     * @param destAddr destination address of host to send ping requests.
     *
     * @param interval amount of time to wait between sending ping requests.
     * For example, if this is 10, then send a ping request to the destination address every 10 simulation time
     * units (starting at time 10).
     *
     * @param duration total amount of time in which the host will send ping requests
     * For example, if this is 35, then send pings until 35 simulation time units have passed.
     *
     * The sendPings method will be called at the beginning of a simulation when the simulation time is 0. Thus, an
     * example of using sendPings with destAddr=5, interval=10, and duration=35. At simulation time 10,
     * send ping request, at time 20, send ping request, at time 30 send ping request, at time 35 stop sending ping
     * requests.
     *      You may want to use timers for this – the Host class has methods to work with timers on your behalf.
     */
    public void sendPings(int destAddr, int interval, int duration) {
        // TODO
    }
}
