package com.sb.logger.Transports;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class FileTransporter implements ITransporter {

    String mLogFolderPath;
    Formatter mFormatter;

    public FileTransporter(String logFolderPath,Formatter formatter){
        mFormatter = formatter;
        mLogFolderPath = logFolderPath;
    }

    @Override
    public void log(LogRecord record) {
        OutputStream logOutput = createLogOutputStream();
        if(logOutput!=null){
            String[] logs = mFormatter.format(record);
            String s = "";
            for (int i = 0 ;i < logs.length; i++){
                s += logs[i] + "\n";
            }
            try {
                logOutput.write(s.getBytes());
                logOutput.flush();
                logOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private OutputStream createLogOutputStream(){
        SimpleDateFormat ss = new SimpleDateFormat("yyyy_MM_dd");
        String fileName = String.format("%s.log.txt",ss.format(new Date()));
        try {
            return new FileOutputStream(mLogFolderPath + "/" + fileName, true);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}
