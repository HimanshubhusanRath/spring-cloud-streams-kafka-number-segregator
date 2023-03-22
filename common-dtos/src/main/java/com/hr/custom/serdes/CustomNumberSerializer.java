package com.hr.custom.serdes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hr.commondtos.CustomNumber;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Base64;
import java.util.Map;

public class CustomNumberSerializer implements Serializer<CustomNumber>
{
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, CustomNumber data)
    {
        try
        {
            if(null==data)
            {
                System.out.println("NULL in Serializing");
                return null;
            }
            return Base64.getEncoder().encode(objectMapper.writeValueAsBytes(data));
        }
        catch(Exception e)
        {
            throw new SerializationException("Exception in Serializing");
        }

    }

    @Override
    public void close() {

    }
}
