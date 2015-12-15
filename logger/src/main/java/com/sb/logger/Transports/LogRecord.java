package com.sb.logger.Transports;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class LogRecord {
    private String fileName;
    private int lineNumber;
    private String version;
    private String tag;
    private long timeStp;
    private String clsName;
    private String methodName;
    private StackTraceElement[] traceElements;
    private Object message;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTimeStp() {
        return timeStp;
    }

    public void setTimeStp(long timeStp) {
        this.timeStp = timeStp;
    }

    public StackTraceElement[] getTraceElements() {
        return traceElements;
    }

    public void setTraceElements(StackTraceElement[] traceElements) {
        this.traceElements = traceElements;
    }
    public String getClsName() {
        return clsName;
    }

    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
