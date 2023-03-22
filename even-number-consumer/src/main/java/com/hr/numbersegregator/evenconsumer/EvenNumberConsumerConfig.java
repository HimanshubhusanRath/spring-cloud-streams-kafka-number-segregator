package com.hr.numbersegregator.evenconsumer;

import com.hr.commondtos.CustomNumber;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class EvenNumberConsumerConfig
{
    @Bean
    public Consumer<KStream<String, CustomNumber>> consumeEvenNumbers()
    {
        return stream -> stream.foreach((key, val) -> System.out.println("Even Number >>> "+val.getNumber()));
    }
}
