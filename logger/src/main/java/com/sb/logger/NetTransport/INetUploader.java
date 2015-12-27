package com.sb.logger.NetTransport;

import com.sb.logger.Transports.LogRecord;

import java.util.ArrayList;

/**
 * Created by WoodHome on 2015/12/27.
 */
public interface INetUploader {
    public void upload(ArrayList<LogRecord> records);
}
