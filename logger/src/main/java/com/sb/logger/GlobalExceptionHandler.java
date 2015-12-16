package com.sb.logger;

/**
 * Created by WoodHome on 2015/12/16 0016.
 */
public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    Thread.UncaughtExceptionHandler mDefaultHandler;

    public GlobalExceptionHandler(){
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Logger.log("RuntimeError",ex.getMessage(),ex.getStackTrace());
        mDefaultHandler.uncaughtException(thread,ex);
    }
}
