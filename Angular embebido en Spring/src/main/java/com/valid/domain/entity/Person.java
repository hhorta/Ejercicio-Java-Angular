package com.valid.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "person")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person {
    /**
     * Campo para almacenar el objeto o valor id con un valor autoincrementable
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * Campo para almacenar el objeto o valor nombre
     */
    @NotBlank(message = "El campo nombre no puede ser vacio.")
    private String nombre;
    /**
     * Campo para almacenar el objeto o valor apellido
     */
    @NotBlank(message = "El campo apellido no puede ser vacio.")
    private String apellido;
    /**
     * Campo para almacenar el objeto o valor procesado
     */

    private Boolean procesado;


}
