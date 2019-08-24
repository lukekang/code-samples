package com.lukekang.gcpsample;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.pubsub.core.PubSubOperations;
import org.springframework.cloud.gcp.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
public class GcpSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GcpSampleApplication.class, args);
	}
//
//	@Bean
//	public PubSubInboundChannelAdapter messageChannelAdapter(
//			@Qualifier("lukeTest") MessageChannel inputChannel,
//			PubSubOperations pubSubTemplate){
////		PubSubInboundChannelAdapter inbound = new
//		return null;
//
//	}
//
//
//
//	@Bean
//	public MessageChannel lukeTest() {
//		return new DirectChannel();
//	}
}

