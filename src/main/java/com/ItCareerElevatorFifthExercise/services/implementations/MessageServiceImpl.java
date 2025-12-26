package com.ItCareerElevatorFifthExercise.services.implementations;

import com.ItCareerElevatorFifthExercise.DTOs.PersistMessageDTO;
import com.ItCareerElevatorFifthExercise.entitities.Message;
import com.ItCareerElevatorFifthExercise.repositories.MessageRepository;
import com.ItCareerElevatorFifthExercise.services.interfaces.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public void persistMessage(PersistMessageDTO persistMessage) {
        Message message = new Message(
                persistMessage.getSenderId(),
                persistMessage.getReceiverId(),
                persistMessage.getContent()
        );

        save(message);
    }

    @Override
    public Message save(Message message) {
        log.info("Persisting message from {} to {} to the database.", message.getSenderId(), message.getReceiverId());

        return messageRepository.save(message);
    }
}
