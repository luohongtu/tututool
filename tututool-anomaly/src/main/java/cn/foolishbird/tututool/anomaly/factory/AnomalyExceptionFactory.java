package cn.foolishbird.tututool.anomaly.factory;

import cn.foolishbird.tututool.anomaly.exception.AnomalyException;
import cn.foolishbird.tututool.anomaly.AnomalyState;

/**
 * @author foolishbird
 */
public class AnomalyExceptionFactory<P extends AnomalyState> implements BsAssertExceptionFactory<AnomalyException, P> {
    @Override
    public AnomalyException exception(P stateInfo) {
        return new AnomalyException(stateInfo.state(), stateInfo.stateMessage());
    }
}
