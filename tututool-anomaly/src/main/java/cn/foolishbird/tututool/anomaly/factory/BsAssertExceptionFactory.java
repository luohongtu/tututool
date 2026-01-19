package cn.foolishbird.tututool.anomaly.factory;

import cn.foolishbird.tututool.anomaly.AnomalyState;

/**
 * @author foolish-bird
 */
public interface BsAssertExceptionFactory<T extends RuntimeException, P extends AnomalyState> {

    /**
     * 获取一个业务异常类型
     *
     * @param code 异常code
     * @return 返回一个异常类型
     */
    /**
     * 获取一个业务异常类型
     *
     * @param stateInfo 异常信息
     * @return 返回一个常常信息
     */
    T exception(P stateInfo);

}
