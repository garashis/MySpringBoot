package com.example.demo;

import java.io.*;

public class PGPService {
    private final InputStream in;

    public PGPService(InputStream in) {
        this.in = in;
    }

    public int operation(InputStream in) throws IOException {
        return in.available();
    }

}
