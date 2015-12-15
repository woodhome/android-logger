package com.sb.logger.Transports;

import android.util.Log;

import com.sb.logger.Transports.ITransporter;
import com.sb.logger.Transports.LogRecord;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class ConsoleTransporter implements ITransporter {

    @Override
    public void log(LogRecord record) {
        Log.e(record.getTag(),record.getClsName()+"\n"+record.getLineNumber() + "\n"+record.getFileName());
    }
}
