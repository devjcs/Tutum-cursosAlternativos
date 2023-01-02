package com.devjocs.service;

import com.devjocs.model.RespuestaGeneral;
import com.devjocs.model.request.ActualizaCalificacionRequest;
import com.devjocs.model.request.EliminaCalificacionRequest;
import com.devjocs.model.request.GuardaCalificacionRequest;
import com.devjocs.model.response.GenericResponse;
import com.devjocs.model.response.ObtenCalificacionResponse;

public interface ICalificaciones {
	public RespuestaGeneral<GenericResponse> guardaCalificacion(GuardaCalificacionRequest req);
	public RespuestaGeneral<ObtenCalificacionResponse> obtenCalificacion(int req);
	public RespuestaGeneral<GenericResponse> actualizaCalificacion(ActualizaCalificacionRequest req);
	public RespuestaGeneral<GenericResponse> borraCalificacion(EliminaCalificacionRequest req);
}
