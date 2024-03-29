package com.unitfit.training.workoutservice.internal.infrastructure.configs;

import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutCreateUseCase;
import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutInputPort;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutRestPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.ExerciseJPADatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.ExerciseJPARepository;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.WorkoutJPADatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.WorkoutJPARepository;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.factories.WorkoutFactory;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
@ComponentScan(basePackages = {"com.unitfit.training.workoutservice"})
public class WorkoutConfig {
    @Bean(autowireCandidate = false, name = "workoutCreateUsecase")
    @Scope("request")
    public WorkoutInputPort workoutCreateUsecaseBean(
            HttpServletResponse httpServletResponse,
            MappingJackson2HttpMessageConverter jacksonConverter,
            WorkoutJPARepository workoutJPARepository,
            ExerciseJPARepository exerciseJPARepository) {
        return new WorkoutCreateUseCase(
                new WorkoutRestPresenter(
                        httpServletResponse,
                        jacksonConverter),
                new WorkoutFactory(
                        new WorkoutJPADatabaseGateway(workoutJPARepository),
                        new ExerciseJPADatabaseGateway(exerciseJPARepository)
                )
        );
    }
}
