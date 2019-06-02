package com.service;

import java.io.IOException;

public interface FileWriterService {

    void write(String result, String fileName) throws IOException;
}
