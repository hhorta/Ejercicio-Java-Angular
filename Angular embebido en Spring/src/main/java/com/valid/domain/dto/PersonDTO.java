package com.valid.domain.dto;

//import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PersonDTO {

   // @Schema(name = "id")
    private Integer id;

    //@Schema(name = "nombre", example = "Harold")
    private String nombre;

    //  @Schema(name = "apellido", example = "Horta")
    private String apellido;

    //  @Schema(name = "procesado", example = "false")
    private Boolean procesado;

}