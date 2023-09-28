package com.example.demo;

import java.io.InputStream;

public class DummyService {

    public void doSomething(InputStream in){
        InputStream inputStream = PGPUtils.getStream(in);
    }
}
