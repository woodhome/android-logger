package com.sb.logger.NetTransport;

import com.sb.logger.Transports.LogRecord;

/**
 * Created by WoodHome on 2015/12/27.
 */
public interface ILogUploader {
    public void upload(LogRecord record);
}
