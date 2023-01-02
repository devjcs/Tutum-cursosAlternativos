package com.devjocs.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ActualizaCalificacionRequest {
	private int idUsuario;
	private int idMateria;
	private int idCalificacion;
	private float calificacion;
}
