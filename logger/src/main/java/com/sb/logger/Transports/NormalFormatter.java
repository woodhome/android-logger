package com.sb.logger.Transports;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/15 0015.
 */
public class NormalFormatter implements IFormatter {
    private static final String header = "***********************************************************************************";
    private static final String footer = "***********************************************************************************";
    private static final String begin ="*    ";
    @Override
    public String[] format(LogRecord record) {
        String[] logs = new String[4+record.getTraceElements().length ];

        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logs[0]=header;
        logs[1]=begin+ String.format("%s  version:%s",ss.format(new Date(record.getTimeStp())),record.getVersion());
        logs[2]=begin+record.getMessage().toString();
        for (int i = 0; i < record.getTraceElements().length ;i++){
            StackTraceElement element = record.getTraceElements()[i];
            logs[i+3] = String.format("%s%s(%s:%d)",begin,element.getClassName(),element.getFileName(),element.getLineNumber());
        }
        logs[logs.length-1] = footer;
        return logs;
    }
}
