package com.sb.logger;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.sb.logger.Transports.LogRecord;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class RecordGenerator {

    static String version="invoke Logger.init(context) in application onCreate to gen version!";

    public static void init(Context context){
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(context.getPackageName(), 0);
        version = packageInfo.versionName;
    }

    public static  LogRecord newRecord(String tag,Object message,StackTraceElement[] traceElements){
        StackTraceElement element = traceElements[3];
        LogRecord record = new LogRecord();
        record.setVersion(version);
        record.setTag(tag);
        record.setTimeStp(System.currentTimeMillis());
        record.setTraceElements(traceElements);
        record.setLineNumber(element.getLineNumber());
        record.setFileName(element.getFileName());
        record.setClsName(element.getClassName());
        record.setMethodName(element.getMethodName());
        record.setMessage(message);
        return record;
    }
}
