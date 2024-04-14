package com.unitfit.training.customerservice.internal.infrastructure.presenters;

import com.unitfit.training.customerservice.internal.infrastructure.utils.dtos.CustomerCreateResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;

import java.io.IOException;

@RequiredArgsConstructor
public class CustomerRestPresenter implements CustomerOutputPortPresenter {

    private final HttpServletResponse httpServletResponse;
    private final MappingJackson2HttpMessageConverter jacksonConverter;

    @Override
    public void presentCreateUsecase(HttpStatus status) {
        final DelegatingServerHttpResponse httpOutputMessage =
                new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));
        httpOutputMessage.setStatusCode(status);
        try {
            jacksonConverter.write(status, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void presentFindByIdUsecase(CustomerCreateResponse response) {
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
