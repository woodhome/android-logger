package com.sb.logger.NetTransport;

import android.content.Context;

import com.sb.logger.Transports.LogRecord;

/**
 * Created by WoodHome on 2015/12/27.
 */
public class WifiCacheUploader extends AbstractNetLogUploader {

    Context mContext ;

    public WifiCacheUploader(Context context){
        super(new DefaultNetUploader());
        mContext = context;
    }

    @Override
    public void upload(LogRecord record) {

    }
}
