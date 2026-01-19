package cn.foolishbird.tututool.anomaly;

/**
 * @author foolishbird
 */
public class DefaultAnomalyState implements AnomalyState {

    private String state;

    private String stateMessage;


    @Override
    public String state() {
        return state;
    }

    @Override
    public String stateMessage() {
        return stateMessage;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }
}
