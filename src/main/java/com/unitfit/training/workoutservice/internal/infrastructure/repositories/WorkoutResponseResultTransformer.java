package com.unitfit.training.workoutservice.internal.infrastructure.repositories;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.ExerciseDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.SetDTO;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import org.hibernate.query.ResultListTransformer;
import org.hibernate.query.TupleTransformer;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class WorkoutResponseResultTransformer implements TupleTransformer<WorkoutFindByIdResponse>, ResultListTransformer<WorkoutFindByIdResponse>{

    private final Map<UUID, WorkoutFindByIdResponse> workoutMap = new LinkedHashMap<>();
    private final Map<UUID, ExerciseDTO> exerciseMap = new LinkedHashMap<>();

    @Override
    public WorkoutFindByIdResponse transformTuple(Object[] tuples, String[] aliases) {
        List<String> aliasList = Arrays.asList(aliases);
        Map<String, Object> tupleMap = aliasList.stream()
                .collect(Collectors.toMap(
                        a -> a,
                        a -> tuples[aliasList.indexOf(a)]));
        WorkoutFindByIdResponse workoutDTO = workoutMap
                .computeIfAbsent(
                        (UUID) tupleMap.get("workout_id"),
                        id -> new WorkoutFindByIdResponse(
                                (String) tupleMap.get("workout_name"),
                                new HashSet<>()));
        ExerciseDTO exerciseDTO = exerciseMap
                .computeIfAbsent(
                        (UUID) tupleMap.get("exercise_id"),
                        id -> new ExerciseDTO(
                                (String) tupleMap.get("exercise_name"),
                                new ArrayList<>()));
        exerciseDTO.sets().add(new SetDTO(
                                (Integer) tupleMap.get("set_order"),
                                (Integer) tupleMap.get("repetition"),
                                Duration.ofSeconds(((BigDecimal) tupleMap.get("repetition_by_time")).longValue()),
                                (String) tupleMap.get("cadence"),
                                Duration.ofSeconds(((BigDecimal) tupleMap.get("rest_between_exercises")).longValue()),
                                Duration.ofSeconds(((BigDecimal) tupleMap.get("rest_between_sets")).longValue()),
                                (Integer) tupleMap.get("weight"),
                                (Integer) tupleMap.get("range_of_motion")
                        ));
        workoutDTO.exercises().add(exerciseDTO);
        return workoutDTO;
    }

    @Override
    public List<WorkoutFindByIdResponse> transformList(List list) {
        return new ArrayList<>(workoutMap.values());
    }
}
