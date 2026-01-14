package cn.foolishbird.tututool.anomaly;

import cn.foolishbird.tututool.anomaly.factory.BsAssertExceptionFactory;
import cn.foolishbird.tututool.anomaly.factory.RuntimeExceptionFactory;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 业务断言
 *
 * @author foolish-bird
 */
public class AnomalyBridge {

    /**
     * List of registered AssertExceptionFactory
     */
    private static final CopyOnWriteArrayList<BsAssertExceptionFactory<? extends RuntimeException, ? extends AnomalyState>> REGISTERS = new CopyOnWriteArrayList<>();

    /**
     * 注册异常工厂
     *
     * @param factory 异常工厂
     */
    @SuppressWarnings("unchecked")
    public static <T extends RuntimeException, P extends AnomalyState> void registerFactory(BsAssertExceptionFactory<T, P> factory) {
        if (null == factory) {
            throw new NullPointerException();
        }
        REGISTERS.add(factory);
    }

    /**
     * 生成业务异常对象
     *
     * @param stateInfo 异常状态信息
     * @param <P>       异常信息
     * @return 异常
     */
    @SuppressWarnings("unchecked")
    public static <P extends AnomalyState> RuntimeException exception(P stateInfo) {
        for (BsAssertExceptionFactory<? extends RuntimeException, ? extends AnomalyState> f : REGISTERS) {
            RuntimeException e = ((BsAssertExceptionFactory<RuntimeException, P>) f).exception(stateInfo);
            if (Objects.nonNull(e)) {
                return e;
            }
        }
        //默认用参数异常类型
        return new RuntimeExceptionFactory<AnomalyState>().exception(stateInfo);
    }
}