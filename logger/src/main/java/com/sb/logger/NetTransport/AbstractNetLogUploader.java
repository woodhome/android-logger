package com.sb.logger.NetTransport;

/**
 * Created by WoodHome on 2015/12/27.
 */
public abstract class AbstractNetLogUploader implements ILogUploader {
    protected INetUploader netUploader;

    public AbstractNetLogUploader(INetUploader uploader){
        netUploader = uploader;
    }

    public INetUploader getNetUploader() {
        return netUploader;
    }

    public void setNetUploader(INetUploader mNetUploader) {
        this.netUploader = mNetUploader;
    }
}
