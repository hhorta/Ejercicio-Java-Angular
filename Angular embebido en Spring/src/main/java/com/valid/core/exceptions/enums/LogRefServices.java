package com.valid.core.exceptions.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LogRefServices {

    ERROR_GENERAL_SERVICIO("ERROR_GENERAL_SERVICIO", "/ayuda/error_general_servicio.html"),
    ERROR_PERSISTENCIA("ERROR_PERSISTENCIA", "/ayuda/error_persistencia.html"),
    ERROR_CLIENTE_SERVICIO("ERROR_CLIENTE_SERVICIO", "/ayuda/error_cliente_servicio.html"),
    ERROR_DATO_CORRUPTO("ERROR_DATO_CORRUPTO", "/ayuda/error_dato_corrupto.html"),
    ERROR_JWT_SEGURIDAD("ERROR_JWT_VALIDACION", "/ayuda/error_validacion_jwt.html"),
    ERROR_DATO_NO_ENCONTRADO("ERROR_DATO_NO_ENCONTRADO", "/ayuda/error_dato_no_encontrado.html"),
    ERROR_GENERAL_HTTPS_SERVICIO("ERROR_GENERAL_HTTPS_SERVICIO", "/ayuda/error_general_https_servicio.html"),
    ERROR_CONVERSION_FECHA("ERROR_CONVERSION_FECHA", "/ayuda/error_conversion_fecha.html");

    /**
     * Codigo del error
     */
    private @Getter
    String logRef;
    /**
     * Enlace a la pagina con ayuda
     */
    private @Getter
    String hrefLink;

    public static LogRefServices valueOfLogRef(String logRef) {
        for (LogRefServices item : values()) {
            if (item.getLogRef().equals(logRef)) {
                return item;
            }
        }
        return null;
    }
}
