package cn.foolishbird.tututool.anomaly;

/**
 * @author foolishbird
 */
public interface DistributedAnomalyState extends AnomalyState {

    /**
     * 错误信息
     *
     * @return 错误信息
     */
    String errorMessage();

}
