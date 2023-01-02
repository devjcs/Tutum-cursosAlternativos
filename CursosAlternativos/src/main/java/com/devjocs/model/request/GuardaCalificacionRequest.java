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
public class GuardaCalificacionRequest {
	private int idMateria;
	private int idUsuario;
	private float calificacion;
}
