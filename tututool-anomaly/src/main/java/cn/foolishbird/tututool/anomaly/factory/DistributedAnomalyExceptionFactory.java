package cn.foolishbird.tututool.anomaly.factory;

import cn.foolishbird.tututool.anomaly.DistributedAnomalyState;
import cn.foolishbird.tututool.anomaly.exception.DistributedAnomalyException;

/**
 * @author foolishbird
 */
public class DistributedAnomalyExceptionFactory<P extends DistributedAnomalyState> implements BsAssertExceptionFactory<DistributedAnomalyException, P> {
    @Override
    public DistributedAnomalyException exception(P stateInfo) {
        return new DistributedAnomalyException(stateInfo.state(), stateInfo.stateMessage(), stateInfo.errorMessage());
    }
}
