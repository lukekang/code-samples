package com.lukekang.gcpsample;


import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@AllArgsConstructor

@RestController
@RequestMapping(value = "translation")
public class TranslatorController {


    private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//    private TranslatorService translator;

    /**
     * Message - change event
     * Channel - dataChangedChannel
     * Channel Adapter - PubSub Adapter
     * Service Activator - DataChangedService
     *
     */

    @PostMapping(value = "/translate")
    public Translations translate(@RequestBody String text){
        return null;

//        return translator.translate(text);
//        return Translations.builder()
//                .text(text)
//                .transalatedTexts(
//                        range(0, 2)
//                                .mapToObj(i -> Pair.with(Locale.US, text + i))
//                                .collect(toSet())
//                )
//                .build();

    }

//    @Bean
//    public
//
//    private PubsubOutboundGateway outGateway;
//
//    public WebAppController(PubsubOutboundGateway outGateway) {
//        this.outGateway = outGateway;
//    }
//
//    @PostMapping(value = "/publish")
//    public void publish() {
//        // TODO
//        LOG.info("hello");
//        outGateway.publish("hello! here's a timestamp: " + Instant.now().toEpochMilli());
//
//    }
//
//
////    @Bean
////    public IntegrationFlow receiveHttpPost() {
////        return IntegrationFlows.from(Http.inboundChannelAdapter("/receive")
////                .mappedRequestHeaders("*"))
////                .transform(new ObjectToStringTransformer())
////                .channel(httpInAdapterPubSubChannel())
////                .get();
////    }
//
//    @Bean
//    public IntegrationFlow
//
//    @Bean
//
//    IntegrationFlow publishViaPost() {
//        return IntegrationFlows.from(Http.)
//    }
//
//
//    @Bean
//    SubscribableChannel httpInAdapterPubSubChannel() {
//        return MessageChannels.publishSubscribe("lukeTest").get();
//    }
//
//
//    @MessagingGateway(defaultRequestChannel = "lukeTest")  // to abstract out messaging service provider
//    public interface PubsubOutboundGateway {
//        void publish(String text);
//    }
//
//
//    @Bean
//    MessageChannel pubsubLukeTest() {
//        return MessageChannels.publishSubscribe("lukeTest").get();
//    }
}