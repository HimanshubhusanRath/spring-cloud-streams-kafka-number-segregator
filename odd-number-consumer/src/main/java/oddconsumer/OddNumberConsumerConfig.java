package oddconsumer;

import com.hr.commondtos.CustomNumber;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OddNumberConsumerConfig
{
    @Bean
    public Consumer<KStream<String, CustomNumber>> consumeOddNumbers()
    {
        return stream -> stream.foreach((key, val) -> System.out.println("Odd Number >>> "+val.getNumber()));
    }
}
