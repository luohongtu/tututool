package cn.foolishbird.tututool.anomaly.exception;

/**
 * 基础异常类，所有自定义业务异常应继承此类
 * 统一维护异常码和异常描述信息
 *
 * @author foolishbird
 */
public class AnomalyException extends RuntimeException {

    static final long serialVersionUID = 4305694221993517496L;

    /**
     * 异常状态码（建议遵循HTTP状态码规范或业务自定义编码规则）
     */
    protected final String code;

    /**
     * 异常详细描述（用于内部调试或详细日志输出）
     */
    protected final String detail;

    /**
     * 构造基础异常
     *
     * @param code   异常码
     * @param detail 异常详细描述
     */
    public AnomalyException(String code, String detail) {
        super(detail); // 将详细描述作为父类message，便于日志输出
        this.code = code;
        this.detail = detail;
    }

    /**
     * 构造包含自定义消息和详细信息的异常
     *
     * @param message 异常概要消息（用于前端展示）
     * @param code    异常码
     * @param detail  异常详细描述（用于内部调试）
     */
    public AnomalyException(String message, String code, String detail) {
        super(message);
        this.code = code;
        this.detail = detail;
    }

    /**
     * 构造包含根因的异常（用于异常链追踪）
     *
     * @param message 异常概要消息
     * @param cause   根异常（原始异常）
     * @param code    异常码
     * @param detail  异常详细描述
     */
    public AnomalyException(String message, Throwable cause, String code, String detail) {
        super(message, cause);
        this.code = code;
        this.detail = detail;
    }

    /**
     * 仅包含根因的异常构造
     *
     * @param cause  根异常
     * @param code   异常码
     * @param detail 异常详细描述
     */
    public AnomalyException(Throwable cause, String code, String detail) {
        super(cause);
        this.code = code;
        this.detail = detail;
    }

    /**
     * 全参数构造（谨慎使用，一般用于特殊场景）
     *
     * @param message            异常概要消息
     * @param cause              根异常
     * @param enableSuppression  是否允许抑制异常
     * @param writableStackTrace 是否生成可写的堆栈跟踪
     * @param code               异常码
     * @param detail             异常详细描述
     */
    protected AnomalyException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace, String code, String detail) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
        this.detail = detail;
    }

    /**
     * 生成异常的简要信息（便于日志输出）
     */
    @Override
    public String toString() {
        return String.format("BaseException [code=%d, message=%s, detail=%s]",
                code, getMessage(), detail);
    }
}
    