package com.ItCareerElevatorFifthExercise.services.interfaces;

import com.ItCareerElevatorFifthExercise.DTOs.ConversationSummaryResponseDTO;
import com.ItCareerElevatorFifthExercise.DTOs.PersistMessageDTO;
import com.ItCareerElevatorFifthExercise.entitities.Message;

import java.util.List;

public interface MessageService {

    void persistMessage(PersistMessageDTO persistMessage);

    Message save(Message message);

    List<ConversationSummaryResponseDTO> getUserConversations(String userId);
}
