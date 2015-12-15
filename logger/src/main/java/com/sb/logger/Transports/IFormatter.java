package com.sb.logger.Transports;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public interface IFormatter {
    public String[] format(LogRecord record);
}
