package com.application.administration.web.common;

import com.application.administration.core.shared.domain.DomainError;
import com.application.administration.core.shared.domain.bus.command.CommandHandlerExecutionError;
import com.application.administration.core.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.http.HttpStatus;
import org.springframework.web.util.NestedServletException;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.*;

import static com.application.administration.core.shared.domain.Utils.toSnake;

public class Utils {

    private Utils() {
    }

    public static void handleCustomError(
            ServletResponse response,
            HttpServletResponse httpResponse,
            ApiController possibleController,
            NestedServletException exception
    ) throws IOException {
        var errorMapping = possibleController.errorMapping();
        Throwable error = (
                                  exception.getCause() instanceof CommandHandlerExecutionError ||
                                          exception.getCause() instanceof QueryHandlerExecutionError
                          )
                          ? exception.getCause().getCause() : exception.getCause();

        int    statusCode = statusFor(errorMapping, error);
        String errorCode  = errorCodeFor(error);
        processResponse(response, httpResponse, error, statusCode, errorCode);
    }

    private static void processResponse(ServletResponse response, HttpServletResponse httpResponse, Throwable error,
                                        int statusCode, String errorCode) throws IOException {

        String errorMessage = error.getMessage();

        httpResponse.reset();
        httpResponse.setHeader("Content-Type", "application/json");
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setStatus(statusCode);
        PrintWriter writer = response.getWriter();
        writer.write(String.format(
                "{\"error_code\": \"%s\", \"message\": \"%s\"}",
                errorCode,
                errorMessage
        ));
        writer.close();
    }

    public static void handleCustomError(ServletResponse response, HttpServletResponse httpResponse,
                                         DomainError exception, int statusCode) throws IOException {
        String errorCode = exception.errorCode();
        processResponse(response, httpResponse, exception, statusCode, errorCode);
    }

    private static int statusFor(Map<Class<? extends DomainError>, HttpStatus> errorMapping, Throwable error) {
        return errorMapping.getOrDefault(error.getClass(), HttpStatus.INTERNAL_SERVER_ERROR).value();
    }

    private static String errorCodeFor(Throwable error) {
        if (error instanceof DomainError) {
            return ((DomainError) error).errorCode();
        }
        return toSnake(error.getClass().toString());
    }

    public static List<HashMap<String, String>> parseFilters(Map<String, Serializable> params) {
        int maxParams = params.size();

        List<HashMap<String, String>> filters = new ArrayList<>();

        for (int key = 0; key < maxParams; key++) {
            if (params.containsKey(String.format("filters[%s][field]", key))) {
                HashMap<String, String> filter = new HashMap<>();
                filter.put("field", (String) params.get(String.format("filters[%s][field]", key)));
                filter.put("operator", (String) params.get(String.format("filters[%s][operator]", key)));
                filter.put("value", (String) params.get(String.format("filters[%s][value]", key)));

                filters.add(filter);
            }
        }
        return filters;
    }

    public static Integer getParamIntValue(Serializable param) {
        Optional<String> value = Optional.ofNullable((String) param);
        if(value.isPresent()) {
            return Integer.parseInt(value.get());
        }
        return null;
    }
}
