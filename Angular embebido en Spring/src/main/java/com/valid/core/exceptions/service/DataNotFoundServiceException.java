package com.valid.core.exceptions.service;

import com.valid.core.exceptions.base.ServiceException;
import com.valid.core.exceptions.enums.LogRefServices;

public class DataNotFoundServiceException extends ServiceException {

    public DataNotFoundServiceException(LogRefServices logRefServices, String message) {
        super(logRefServices, message);
    }

    public DataNotFoundServiceException(LogRefServices logRefServices, String message, Throwable cause) {
        super(logRefServices, message, cause);
    }
}
