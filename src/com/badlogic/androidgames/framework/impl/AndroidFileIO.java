package com.badlogic.androidgames.framework.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import com.badlogic.androidgames.framework.FileIO;

public class AndroidFileIO implements FileIO {
    AssetManager assets;
    String externalStoragePath;
    String internalStoragePath;

    public AndroidFileIO(AssetManager assets, Context context) {
        this.assets = assets;
        this.externalStoragePath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator;
        this.internalStoragePath = context.getFilesDir()
        		.getAbsolutePath() + File.separator;
    }

    @Override
    public InputStream readAsset(String fileName) throws IOException {
        return assets.open(fileName);
    }

    @Override
    public InputStream readExternalFile(String fileName) throws IOException {
        return new FileInputStream(externalStoragePath + fileName);
    }
    
    public InputStream readInternalFile(String fileName) throws IOException {
        return new FileInputStream(internalStoragePath + fileName);
    }

    @Override
    public OutputStream writeExternalFile(String fileName) throws IOException {
        return new FileOutputStream(externalStoragePath + fileName);
    }
    
    @Override
    public OutputStream writeInternalFile(String fileName) throws IOException {
        return new FileOutputStream(internalStoragePath + fileName);
    }
}
