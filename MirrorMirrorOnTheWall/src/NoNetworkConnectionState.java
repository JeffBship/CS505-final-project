
import cs505.group1.state.ButtonState;

/*
 * This state represents what is displayed when there is no network connection.
All widgets, that utilize network connectivity, will be ulitizing this state.
 */

/**
 *
 * @since 11/12/2017
 * @version 2017.11.12.0
 * @author melmulcahy
 */
public class NoNetworkConnectionState implements ButtonState {

    @Override
    public ButtonState singlePress() {
        System.out.println("No network: SINGLE PRESS.");
        return this;
    }

    @Override
    public ButtonState doublePress() {
        System.out.println("No network: DOUBLE PRESS.");
        return this;
    }

    @Override
    public ButtonState longPress() {
        System.out.println("No network: LONG PRESS.");
        return this;
    }
    
}
