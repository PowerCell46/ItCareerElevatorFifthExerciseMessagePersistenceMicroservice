package com.ItCareerElevatorFifthExercise.controllers;

import com.ItCareerElevatorFifthExercise.DTOs.ConversationSummaryResponseDTO;
import com.ItCareerElevatorFifthExercise.services.interfaces.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/conversations")
public class UserConversationController {

    private final MessageService messageService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ConversationSummaryResponseDTO>> getUserConversations(@PathVariable String userId) {
        log.info("---> GET request on /api/conversations/{}.", userId);

        var responseDTOs = messageService.getUserConversations(userId);

        return ResponseEntity.ok(responseDTOs);
    }
}
