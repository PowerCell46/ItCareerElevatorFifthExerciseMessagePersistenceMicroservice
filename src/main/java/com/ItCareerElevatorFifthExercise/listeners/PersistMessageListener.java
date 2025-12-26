package com.ItCareerElevatorFifthExercise.listeners;

import com.ItCareerElevatorFifthExercise.DTOs.PersistMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersistMessageListener {

//    private final MessageService messageService;

    @KafkaListener(
            topics = "${spring.kafka.topic.persist-message:persistMessage}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "persistMessageKafkaListenerContainerFactory"
    )
    public void handlePersistMessage(PersistMessageDTO persistMessage) {
        log.info("---> Handling message in the Kafka topic.");

        if (persistMessage == null || persistMessage.getSenderId() == null || persistMessage.getReceiverId() == null) {
            log.error("Invalid persistMessageDTO received: {}.", persistMessage);
            return; // TODO: Should anything else happen?
        }

        log.info("Received data from Kafka: {}.", persistMessage);
//        messageService.persistMessage(persistMessage);
    }
}
