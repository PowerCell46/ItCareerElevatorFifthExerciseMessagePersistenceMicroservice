package com.ItCareerElevatorFifthExercise.services.interfaces;

import com.ItCareerElevatorFifthExercise.DTOs.PersistMessageDTO;
import com.ItCareerElevatorFifthExercise.entitities.Message;

public interface MessageService {

    void persistMessage(PersistMessageDTO persistMessage);

    Message save(Message message);
}
