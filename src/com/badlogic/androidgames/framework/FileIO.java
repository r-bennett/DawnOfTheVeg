package com.badlogic.androidgames.framework;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface FileIO {
    public InputStream readAsset(String fileName) throws IOException;

    public InputStream readExternalFile(String fileName) throws IOException;
    
    public InputStream readInternalFile(String fileName) throws IOException;

    public OutputStream writeExternalFile(String fileName) throws IOException;
    
    public OutputStream writeInternalFile(String fileName) throws IOException;
}
