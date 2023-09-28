package com.example.demo;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;

public class PriceSerializer extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
        // Using writNumber and removing toString make sure the output is number but not String.
        jgen.writeNumber(String.format("%.2f", value));
    }
}
