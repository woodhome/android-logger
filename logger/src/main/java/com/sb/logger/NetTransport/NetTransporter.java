package com.sb.logger.NetTransport;

import android.content.Context;

import com.sb.logger.Transports.ITransporter;
import com.sb.logger.Transports.LogRecord;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class NetTransporter implements ITransporter {

    private LogRecord.LogLevel[] levelFilters;
    private ILogUploader mLogUploader;

    public NetTransporter(Context context,LogRecord.LogLevel[] filters){
        levelFilters = filters;
        mLogUploader = new WifiCacheUploader(context);
    }

    @Override
    public void log(LogRecord record) {
        if(!inFilter(record.getLevel())){
            return;
        }
        if(null!=mLogUploader){
            mLogUploader.upload(record);
        }
    }

    private boolean inFilter(LogRecord.LogLevel logLevel){
        if(null == levelFilters){
            return false;
        }
        for (int i = 0; i < levelFilters.length; i++){
            if(logLevel.equals(levelFilters[i])){
                return true;
            }
        }
        return false;
    }
}
