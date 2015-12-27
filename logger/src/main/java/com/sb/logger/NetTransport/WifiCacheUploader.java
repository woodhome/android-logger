package com.sb.logger.NetTransport;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;

import com.sb.logger.Transports.LogRecord;

import java.util.ArrayList;

/**
 * Created by WoodHome on 2015/12/27.
 */
public class WifiCacheUploader extends AbstractNetLogUploader implements Runnable {

    private static final int time_interval = 60 * 1000;
    private static final int cache_count = 10;

    Context mContext ;
    Handler mHandler;
    ArrayList<LogRecord> logRecords = new ArrayList<>();

    public WifiCacheUploader(Context context){
        super(new DefaultNetUploader());
        mContext = context;
        mHandler = new Handler();
        mHandler.postDelayed(this,time_interval);
    }

    @Override
    public void upload(LogRecord record) {
        logRecords.add(record);
    }

    private static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    @Override
    public void run() {
        if(logRecords.size() > cache_count && isWifi(mContext)){
            getNetUploader().upload(logRecords);
            logRecords.clear();
        }
        mHandler.postDelayed(this,time_interval);
    }
}
