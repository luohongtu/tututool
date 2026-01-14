package cn.foolishbird.tututool.anomaly;

/**
 * @author foolishbird
 */
public class DefaultDistributedAnomalyState extends DefaultAnomalyState implements DistributedAnomalyState {

    private String errorMessage;

    @Override
    public String errorMessage() {
        return errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
