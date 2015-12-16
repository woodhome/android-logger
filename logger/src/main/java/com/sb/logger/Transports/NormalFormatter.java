package com.sb.logger.Transports;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/12/15 0015.
 */
public class NormalFormatter extends Formatter {
    private static final String header = "***********************************************************************************";
    private static final String footer = "***********************************************************************************";
    private static final String begin ="*    ";

    public NormalFormatter(){
        super();
    }

    public NormalFormatter(int maxStackNumber){
        super(maxStackNumber);
    }

    @Override
    public String[] format(LogRecord record) {
        int stacklineNumber = getmMaxStackNumber();
        String[] objectStrings = formatObject(record.getMessage());
        stacklineNumber = record.getTraceElements().length > stacklineNumber ? stacklineNumber : record.getTraceElements().length;
        String[] logs = new String[3+objectStrings.length+stacklineNumber ];

        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        logs[0]=header;
        logs[1]=begin+ String.format("%s  version:%s", ss.format(new Date(record.getTimeStp())), record.getVersion());

        for (int i =0 ; i < objectStrings.length;i++){
            logs[2 + i] = objectStrings[i];
        }

        for (int i = 0; i < stacklineNumber;i++){
            StackTraceElement element = record.getTraceElements()[i];
            logs[i+3+objectStrings.length] = String.format("%s%s(%s:%d)",begin,element.getClassName(),element.getFileName(),element.getLineNumber());
        }
        logs[logs.length-1] = footer;
        return logs;
    }

    @Override
    public String[] formatObject(Object object) {
        String[] strs = new String[2];
        strs[0] = begin + object.getClass().getCanonicalName() + "\n";
        strs[1] = begin + object.toString();
        return strs;
    }
}
