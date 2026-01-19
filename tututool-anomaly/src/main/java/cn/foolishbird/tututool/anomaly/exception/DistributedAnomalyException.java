package cn.foolishbird.tututool.anomaly.exception;

/**
 * 分布异常错误
 *
 * @author foolishbird
 */
public class DistributedAnomalyException extends AnomalyException {

    static final long serialVersionUID = 3305694221993517496L;

    /**
     * 错误信息
     */
    protected String errorMessage;

    public DistributedAnomalyException(String code, String detail, String errorMessage) {
        super(code, detail);
        this.errorMessage = errorMessage;
    }

    public DistributedAnomalyException(String message, String code, String detail, String errorMessage) {
        super(message, code, detail);
        this.errorMessage = errorMessage;
    }

    public DistributedAnomalyException(String message, Throwable cause, String code, String detail, String errorMessage) {
        super(message, cause, code, detail);
        this.errorMessage = errorMessage;
    }

    public DistributedAnomalyException(Throwable cause, String code, String detail, String errorMessage) {
        super(cause, code, detail);
        this.errorMessage = errorMessage;
    }

    public DistributedAnomalyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code, String detail, String errorMessage) {
        super(message, cause, enableSuppression, writableStackTrace, code, detail);
        this.errorMessage = errorMessage;
    }
}
