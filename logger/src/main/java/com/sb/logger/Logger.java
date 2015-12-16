package com.sb.logger;

import android.content.Context;

import com.sb.logger.Transports.ConsoleTransporter;
import com.sb.logger.Transports.ITransporter;
import com.sb.logger.Transports.LogRecord;
import com.sb.logger.Transports.NormalFormatter;

import java.util.ArrayList;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class Logger {

    static ArrayList<ITransporter> transporters = new ArrayList<>();
    static {
        new GlobalExceptionHandler();
    }

    public static void init(Context context){
        RecordGenerator.init(context);
    }

    public static  void e(String tag ,Object message){
        log(tag,message, LogRecord.LogLevel.ERROR);
    }

    public static void e(Object message){
        log(message, LogRecord.LogLevel.ERROR);
    }

    public static  void i(String tag ,Object message){
        log(tag,message, LogRecord.LogLevel.INFO);
    }

    public static void i(Object message){
        log(message, LogRecord.LogLevel.ERROR);
    }

    public static  void d(String tag ,Object message){
        log(tag,message, LogRecord.LogLevel.DEBUG);
    }

    public static void d(Object message){
        log(message, LogRecord.LogLevel.DEBUG);
    }

    public static  void w(String tag ,Object message){
        log(tag,message, LogRecord.LogLevel.WARNING);
    }

    public static void w(Object message){
        log(message, LogRecord.LogLevel.WARNING);
    }

    private static void log(String tag,Object message,LogRecord.LogLevel level){
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        StackTraceElement[] realStack = new StackTraceElement[traceElements.length-4];
        System.arraycopy(traceElements,4,realStack,0,realStack.length);
        log(tag, message, realStack,level);
    }

    private static void log(Object message,LogRecord.LogLevel level){
        StackTraceElement[] traceElements = Thread.currentThread().getStackTrace();
        StackTraceElement[] realStack = new StackTraceElement[traceElements.length-4];
        System.arraycopy(traceElements,4,realStack,0,realStack.length);
        log("", message, realStack,level);
    }

    public static void addTransport(ITransporter transporter){
        transporters.add(transporter);
    }

    protected static void log(String tag,Object message,StackTraceElement[] traceElements,LogRecord.LogLevel level){
        LogRecord record = RecordGenerator.newRecord(tag,message,traceElements,level);
        if(transporters.isEmpty()){
            addTransport(new ConsoleTransporter(new NormalFormatter()));
        }
        for (int i = 0; i < transporters.size();i++){
            transporters.get(i).log(record);
        }
    }
}
