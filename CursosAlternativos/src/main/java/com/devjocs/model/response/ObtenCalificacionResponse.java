package com.devjocs.model.response;

import java.util.List;

import com.devjocs.model.Alumno;

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
public class ObtenCalificacionResponse {
	private List<Alumno> calificaciones;
	private float promedio;
}
