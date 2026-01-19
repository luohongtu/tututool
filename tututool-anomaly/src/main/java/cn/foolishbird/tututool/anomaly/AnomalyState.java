package cn.foolishbird.tututool.anomaly;

/**
 * 异常状态
 *
 * @author foolishbird
 */
public interface AnomalyState {

    /**
     * 状态
     *
     * @return 状态
     */
    String state();

    /**
     * 状态说明
     *
     * @return 状态说明
     */
    String stateMessage();

}
