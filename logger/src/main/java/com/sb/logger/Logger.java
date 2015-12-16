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

    public static void log(String tag,Object message){
        log(tag, message, Thread.currentThread().getStackTrace());
    }

    public static void log(Object message){
        log("",message,Thread.currentThread().getStackTrace());
    }

    public static void addTransport(ITransporter transporter){
        transporters.add(transporter);
    }

    public static void log(String tag,Object message,StackTraceElement[] traceElements){
        LogRecord record = RecordGenerator.newRecord(tag,message,traceElements);
        if(transporters.isEmpty()){
            addTransport(new ConsoleTransporter(new NormalFormatter()));
        }
        for (int i = 0; i < transporters.size();i++){
            transporters.get(i).log(record);
        }
    }
}
