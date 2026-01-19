package cn.foolishbird.tututool.anomaly.factory;

import cn.foolishbird.tututool.anomaly.AnomalyBridge;
import cn.foolishbird.tututool.anomaly.AnomalyState;

/**
 * @author foolish-bird
 */
public class RuntimeExceptionFactory<P extends AnomalyState> implements BsAssertExceptionFactory<RuntimeException, P> {

    static {
        AnomalyBridge.registerFactory(new RuntimeExceptionFactory<AnomalyState>());
    }

    @Override
    public IllegalArgumentException exception(P stateInfo) {
        return new IllegalArgumentException(stateInfo.stateMessage());
    }
}