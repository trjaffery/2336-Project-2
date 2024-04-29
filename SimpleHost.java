import java.util.HashMap;
import java.util.List;

public class SimpleHost extends Host {
    private int destAddr;
    private int pingTimerId;
    private int stopTimerId;

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
        System.out.println("Host received: " + msg);

        if ("PING_REQUEST".equals(msg.getMessage())) {
            System.out.println("[" + getCurrentTime() + "ts] Host " + getHostAddress() + ": Ping request from Host " + msg.getSrcAddress());
            Message response = new Message(getHostAddress(), msg.getSrcAddress(), "PING_RESPONSE");
            response.setInsertionTime(getCurrentTime());
            sendToNeighbor(response);
        } else if ("PING_RESPONSE".equals(msg.getMessage())) {
            System.out.println("[" + getCurrentTime() + "ts] Host " + getHostAddress() + ": Ping response from Host " + msg.getSrcAddress());
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
        System.out.println("Host " + eventId + ": Stopped sending pings");
        // create new timer

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
        // for the last timer, to stop making new timers
        System.out.println("[" + getCurrentTime() + "ts] Timer " + eventId + " cancelled.");
    }


    public void sendPings(int interval, int duration, int destAddr) {
        this.destAddr = destAddr;
        // Start the ping timer
        pingTimerId = this.newTimer(interval);

        // Start the stop timer to stop pinging after the duration
        stopTimerId = this.newTimer(duration);
    }
}