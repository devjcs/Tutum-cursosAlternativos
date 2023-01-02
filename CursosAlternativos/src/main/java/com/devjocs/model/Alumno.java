package com.devjocs.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Alumno {
	private int id_t_usuario;
	private int idCalificacion;
	private String nombre;
	private String apellido;
	private String materia;
	private float calificacion;
	private Date fecha_registro;
}
