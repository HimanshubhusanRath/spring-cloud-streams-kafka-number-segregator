package com.hr.oddeven.producer;

import com.hr.commondtos.CustomNumber;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Supplier;

@Configuration
public class ProducerConfig
{
    @Bean
    public Supplier<Flux<CustomNumber>> numberProducer()
    {
        return () -> Flux.range(1,100)
                .map(i -> new CustomNumber(i))
                .delayElements(Duration.ofMillis(200));

    }
}
