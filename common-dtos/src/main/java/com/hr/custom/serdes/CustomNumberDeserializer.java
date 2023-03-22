package com.hr.custom.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.commondtos.CustomNumber;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Base64;
import java.util.Map;

public class CustomNumberDeserializer implements Deserializer<CustomNumber> {

    final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey)
    {

    }

    @Override
    public CustomNumber deserialize(String topic, byte[] data)
    {
        try
        {
            if(null==data)
            {
                System.out.println("NULL in deserializing");
                return null;
            }
            return objectMapper.readValue(new String(Base64.getDecoder().decode(data),"UTF-8"), CustomNumber.class);
        }
        catch(Exception e)
        {
            throw new SerializationException("Exception in deserializing");
        }
    }

    @Override
    public void close() {

    }
}
