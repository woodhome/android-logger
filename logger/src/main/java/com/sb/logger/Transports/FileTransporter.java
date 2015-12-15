package com.sb.logger.Transports;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public class FileTransporter implements ITransporter {

    String mLogFolderPath;

    public FileTransporter(String logFolderPath){
        mLogFolderPath = logFolderPath;
    }

    @Override
    public void log(LogRecord record) {

    }
}
