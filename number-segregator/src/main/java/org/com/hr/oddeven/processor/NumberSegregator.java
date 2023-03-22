package org.com.hr.oddeven.processor;

import com.hr.commondtos.CustomNumber;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class NumberSegregator {

    @Bean
    public Function<KStream<String, CustomNumber>, KStream<String, CustomNumber>> oddNumberSegregator()
    {
        return kstream -> kstream
                .filter((key,val) -> (val.getNumber() % 2 == 1));
    }

    @Bean
    public Function<KStream<String, CustomNumber>, KStream<String, CustomNumber>> evenNumberSegregator()
    {
        return kstream -> kstream
                .filter((key,val) -> (val.getNumber() % 2 == 0));
    }
}
