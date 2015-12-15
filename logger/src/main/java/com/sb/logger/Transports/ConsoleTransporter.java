package com.sb.logger.Transports;

import android.util.Log;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class ConsoleTransporter implements ITransporter {
    IFormatter formatter = new NormalFormatter();

    @Override
    public void log(LogRecord record) {
        String[] logs = formatter.format(record);
        String s = "";
        for (int i = 0 ;i < logs.length; i++){
            s += logs[i] + "\n";
        }
        Log.e(record.getTag(),s);
    }
}
