package com.sb.logger.Transports;

import android.util.Log;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class ConsoleTransporter implements ITransporter {
    IFormatter mFormatter;

    public ConsoleTransporter(IFormatter formatter){
        mFormatter = formatter;
    }

    @Override
    public void log(LogRecord record) {
        String[] logs = mFormatter.format(record);
        String s = "";
        for (int i = 0 ;i < logs.length; i++){
            s += logs[i] + "\n";
        }
        Log.e(record.getTag(),s);
    }
}
