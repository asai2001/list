package com.simft.simft.encryption;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class Caesar64Serializer extends JsonSerializer<Caesar64> {
    @Override
    public void serialize(Caesar64 caesar64, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        // Serialize Caesar64 object as needed
        // For example, you can convert it to a String and write it to the JSON generator.
        jsonGenerator.writeString(caesar64.toString());
    }
}
