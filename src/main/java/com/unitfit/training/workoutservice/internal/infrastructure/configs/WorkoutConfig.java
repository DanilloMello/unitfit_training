package com.unitfit.training.workoutservice.internal.infrastructure.configs;

import com.unitfit.training.workoutservice.internal.core.factories.WorkoutFactory;
import com.unitfit.training.workoutservice.internal.core.usecases.IWorkoutCreateUsercase;
import com.unitfit.training.workoutservice.internal.core.usecases.IWorkoutFindByIdUsercase;
import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutCreateUsercaseImpl;
import com.unitfit.training.workoutservice.internal.core.usecases.WorkoutFindByIdUsecaseImpl;
import com.unitfit.training.workoutservice.internal.infrastructure.presenters.WorkoutRestPresenter;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.ExerciseJPARepository;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.WorkoutJPADatabaseGateway;
import com.unitfit.training.workoutservice.internal.infrastructure.repositories.WorkoutJPARepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.WebApplicationContext;

@Configuration
@ComponentScan(basePackages = {"com.unitfit.training.workoutservice"})
public class WorkoutConfig {

    @Scope(WebApplicationContext.SCOPE_REQUEST)
    @Bean(autowireCandidate = false)
    public IWorkoutCreateUsercase workoutCreateUsecaseBean(
            HttpServletResponse httpServletResponse,
            MappingJackson2HttpMessageConverter jacksonConverter,
            WorkoutJPARepository workoutJPARepository,
            ExerciseJPARepository exerciseJPARepository) {
        return new WorkoutCreateUsercaseImpl(
                new WorkoutRestPresenter(
                        httpServletResponse,
                        jacksonConverter),
                new WorkoutFactory(
                        new WorkoutJPADatabaseGateway(workoutJPARepository)
                )
        );
    }

    @Scope(WebApplicationContext.SCOPE_REQUEST)
    @Bean(autowireCandidate = false)
    public IWorkoutFindByIdUsercase workoutFindByIdUsercaseBean(
            HttpServletResponse httpServletResponse,
            MappingJackson2HttpMessageConverter jacksonConverter,
            WorkoutJPARepository workoutJPARepository) {
        return new WorkoutFindByIdUsecaseImpl(
                new WorkoutRestPresenter(
                        httpServletResponse,
                        jacksonConverter),
                new WorkoutJPADatabaseGateway(workoutJPARepository)
        );
    }
//
//    @Scope(WebApplicationContext.SCOPE_REQUEST)
//    @Bean(autowireCandidate = false)
//    public IWorkoutFindByClientIdUsercase workoutFindByClientIdUsercaseBean(
//            HttpServletResponse httpServletResponse,
//            MappingJackson2HttpMessageConverter jacksonConverter,
//            WorkoutJPARepository workoutJPARepository) {
//        return new WorkoutFindByClientIdUsecaseImpl(
//                new WorkoutRestPresenter(
//                        httpServletResponse,
//                        jacksonConverter),
//                new WorkoutJPADatabaseGateway(workoutJPARepository)
//        );
//    }
}
