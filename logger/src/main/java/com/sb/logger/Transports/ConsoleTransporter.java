package com.sb.logger.Transports;

import android.util.Log;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class ConsoleTransporter implements ITransporter {
    Formatter mFormatter;

    public ConsoleTransporter(Formatter formatter){
        mFormatter = formatter;
    }

    @Override
    public void log(LogRecord record) {
        String[] logs = mFormatter.format(record);
        String s = "";
        for (int i = 0 ;i < logs.length; i++){
            s += logs[i] + "\n";
        }
        switch (record.getLevel()){
            case DEBUG:
                Log.d(record.getTag(),s);
                break;
            case INFO:
                Log.i(record.getTag(),s);
                break;
            case ERROR:
                Log.e(record.getTag(),s);
                break;
            case WARNING:
                Log.w(record.getTag(),s);
                break;
            default:
                Log.e(record.getTag(),s);
        }
    }
}
