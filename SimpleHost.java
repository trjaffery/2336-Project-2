import java.util.HashMap;
import java.util.List;

public class SimpleHost extends Host {
    private int destAddr;
    private int intervalTimer;
    private int durationTimer;
    private int duration;
    private int interval;
    private int lastCancelledTimer;
    private int currentTime;

    public SimpleHost(int address, FutureEventList fel) {
        super();
        setHostParameters(address, fel);
    }

    /**
     * This is called when a host receives a Message event from a neighboring host.
     *
     * @param msg the Message event received
     */
    @Override
    protected void receive(Message msg) {
        // Handle receiving a message
        // switch statement
        int rtt = msg.getArrivalTime() - currentTime;
        if ("PING_REQUEST".equals(msg.getMessage())) {
            System.out.println("[" + getCurrentTime() + "ts] Host " + getHostAddress() + ": Ping request from Host " + msg.getSrcAddress());
            Message response = new Message(getHostAddress(), msg.getSrcAddress(), "PING_RESPONSE");
            response.setInsertionTime(getCurrentTime());
            sendToNeighbor(response);
        } else if ("PING_RESPONSE".equals(msg.getMessage())) {
            System.out.println("[" + getCurrentTime() + "ts] Host " + getHostAddress() + ": Ping response from Host " + msg.getSrcAddress() + " (RTT = " + rtt + "ts)");
        }
    }

    /**
     * This is called after a Timer event expires, and enables you to write code to do something upon timer
     * expiry.  A timer expires when the duration set for the timer is reached.
     *
     * @param eventId the event id of the Timer event which expired
     */
    @Override
    protected void timerExpired(int eventId) {
        // Timer expired handling logic
        // For example, you might send a new ping request if the timer corresponds to the ping interval

        if (eventId == intervalTimer) { // if the current intervalTimer expires
//            if (interval >= duration) { // if interval time reaches/exceeds the total duration time of simulation
//                cancelTimer(intervalTimer);
//                timerCancelled(intervalTimer);
//                intervalTimer = durationTimer;
//            }
            this.currentTime = getCurrentTime();

            if (this.currentTime <= duration) {
                currentTime = getCurrentTime();
                System.out.println("[" + getCurrentTime() + "ts] Host " + getHostAddress() + ": Sent ping to Host " + destAddr);
            }
            // create the message
            Message request = new Message(getHostAddress(), destAddr, "PING_REQUEST");

            // send the message
            sendToNeighbor(request);

            // create new intervalTimer for next interval
            this.intervalTimer = newTimer(interval);
        }
        else if (eventId == durationTimer && eventId != lastCancelledTimer) {
            // if the current durationTimer expires

            System.out.println("[" + duration + "ts] Host " + getHostAddress() + ": Stopped sending pings");
            // cancel interval timers and end program
            cancelTimer(intervalTimer);

            lastCancelledTimer = intervalTimer;
        }

    }

    /**
     * This is called after a Timer event is cancelled, and enables you to write code to do something upon timer
     * cancellation.
     *
     * @param eventId the event id of the Timer event which was cancelled
     */
    @Override
    protected void timerCancelled(int eventId) {
        // Timer cancelled handling logic
    }


    public void sendPings(int interval, int duration, int destAddr) {
        this.destAddr = destAddr;
        this.interval = interval;
        this.duration = duration;
        // Start the ping timer
        this.intervalTimer = this.newTimer(interval);

        // Start the stop timer to stop pinging after the duration
        this.durationTimer = this.newTimer(duration);
    }
}