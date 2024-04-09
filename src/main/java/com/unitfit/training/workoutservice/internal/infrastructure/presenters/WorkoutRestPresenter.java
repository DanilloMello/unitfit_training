package com.unitfit.training.workoutservice.internal.infrastructure.presenters;

import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByClientIdResponse;
import com.unitfit.training.workoutservice.internal.infrastructure.utils.dtos.WorkoutFindByIdResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class WorkoutRestPresenter implements WorkoutOutputPortPresenter {
    private final HttpServletResponse httpServletResponse;
    private final MappingJackson2HttpMessageConverter jacksonConverter;

    @Override
    public void presentCreateUsecase(HttpStatus response) {
        final DelegatingServerHttpResponse httpOutputMessage =
                new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));
        httpOutputMessage.setStatusCode(response);
        try {
            jacksonConverter.write(response, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void presentFindByClientIdUsecase(List<WorkoutFindByClientIdResponse> response) {
        final DelegatingServerHttpResponse httpOutputMessage =
                new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));
        try {
            jacksonConverter.write(response, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void presentFindByIdUsecase(WorkoutFindByIdResponse response) {
        final DelegatingServerHttpResponse httpOutputMessage =
                new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));
        try {
            jacksonConverter.write(response, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void presentError(Exception exception) {
        throw new RuntimeException(exception);
    }
}
