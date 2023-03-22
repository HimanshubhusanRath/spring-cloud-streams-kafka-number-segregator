# Odd-Even Number Segregator using Spring Cloud Streams with Kafka

There are 5 sub modules in this project:
-------------------------------
* common-dtos --> Contains the common dto, serializers, deserializers, serdes
* number-producer ---> <b>[SUPPLIER]</b> Producer which produces numbers from 1 to 100 to a kafka topic (number.input)
* number-segregator --><b>[FUNCTION]</b> Streams processor which segregates the odd and even numbers and pushes those to different kafka topics. (number.out.odd & number.out.even)
* even-number-consumer --> <b>[CONSUMER]</b> Consumer which consumes the messages from the even number kafka topic (number.out.even)
* odd-number-consumer --> <b>[CONSUMER]</b> Consumer which consumes the messages from the odd number kafka topic (number.out.odd)


Key points of the project:
---------------------------
* CustomNumber --> Custom value object for kafka topic
* CustomNumberSerializer --> Serializer for the above custom object.
* CustomNumberDeserializer --> Deserializer for the above custom object.
* CustomNumberSerde --> Serde for the above custom object to be used for stream processing.


Note on configuring the Serializer/Deserializer for kafka:
---------------------------
* If we are using 'spring-cloud-stream-binder-kafka' in classpath, then use <b>spring.cloud.stream.kafka.bindings.<binding-name>.[producer/consumer].configuration.[key/value].[serializer/deserializer]</b>
* If we are using 'spring-cloud-stream-binder-kafka-streams' in classpath, then use <b>spring.cloud.stream.kafka.streams.bindings.<binding-name>.[producer/consumer].[keySerde/valueSerde]</b>
