package com.hr.custom.serdes;

import com.hr.commondtos.CustomNumber;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

public class CustomNumberSerde extends Serdes.WrapperSerde<CustomNumber>
{
    public CustomNumberSerde()
    {
        super(new CustomNumberSerializer(), new CustomNumberDeserializer());
    }

}
