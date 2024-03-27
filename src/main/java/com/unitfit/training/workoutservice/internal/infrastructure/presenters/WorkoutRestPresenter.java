package com.unitfit.training.workoutservice.internal.infrastructure.presenters;

import com.unitfit.training.workoutservice.internal.core.domains.Workout;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;

import java.io.IOException;

@RequiredArgsConstructor
public class WorkoutRestPresenter implements WorkoutPresenter {
    private final HttpServletResponse httpServletResponse;
    private final MappingJackson2HttpMessageConverter jacksonConverter;
    @Override
    public void presentWorkout(Workout workout) {
        /*
            Doing a bit of heavy lifting here ourselves:
            need to serialize the response model as JSON
            to the HTTP response. This will normally will
            be done by Spring Web when a request handling
            method returning the response model and annotated
            with ResponseBody.
         */

        // construct HTTP output message working with Servlet HTTP
        // response
        final DelegatingServerHttpResponse httpOutputMessage =
                new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));

        // set status OK
        httpOutputMessage.setStatusCode(HttpStatus.OK);

        // serialize response model to JSON as the body of the message
        try {
            jacksonConverter.write(workout, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            // just for this example
            throw new RuntimeException(e);
        }

    }
    @Override
    public void presentError(Exception exception) {
//       Treat handling exception here
        throw new RuntimeException(exception);
    }
}
