package com.sb.logger.Transports;

/**
 * Created by WoodHome on 2015/12/15 0015.
 */
public abstract class Formatter {
    int mMaxStackNumber = Integer.MAX_VALUE;

    public abstract String[] format(LogRecord record);
    public abstract String[] formatObject(Object object);

    public  Formatter(){

    }

    public Formatter(int maxStackNumber){
        mMaxStackNumber = maxStackNumber;
    }

    public int getmMaxStackNumber() {
        return mMaxStackNumber;
    }

    public void setmMaxStackNumber(int mMaxStackNumber) {
        this.mMaxStackNumber = mMaxStackNumber;
    }

}
