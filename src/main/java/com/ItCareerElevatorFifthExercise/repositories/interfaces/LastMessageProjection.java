package com.ItCareerElevatorFifthExercise.repositories.interfaces;

import java.time.LocalDateTime;

public interface LastMessageProjection {

    String getSenderId();

    String getReceiverId();

    String getContent();

    LocalDateTime getCreatedAt();
}
