package com.valid.core.exceptions.base;

import com.valid.core.exceptions.enums.LogRefServices;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends Exception {

    private final LogRefServices logRefServices;

    private final String message;

    public ServiceException(LogRefServices logRefServices, String message) {
        super(message);
        this.logRefServices = logRefServices;
        this.message = message;
    }

    public ServiceException(LogRefServices logRefServices, String message, Throwable cause) {
        super(message, cause);
        this.logRefServices = logRefServices;
        this.message = message;
    }

    public ServiceException(LogRefServices logRefServices, Throwable throwable) {
        super(logRefServices.getLogRef(), throwable);
        this.logRefServices = logRefServices;
        this.message = StringUtils.EMPTY;
    }
}
