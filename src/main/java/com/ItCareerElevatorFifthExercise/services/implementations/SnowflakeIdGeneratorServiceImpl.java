package com.ItCareerElevatorFifthExercise.services.implementations;

import cn.hutool.core.lang.Snowflake;
import com.ItCareerElevatorFifthExercise.services.interfaces.SnowflakeIdGeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SnowflakeIdGeneratorServiceImpl implements SnowflakeIdGeneratorService {

    private final Snowflake snowflake;

    @Override
    public long nextId() {
        return snowflake.nextId();
    }
}
