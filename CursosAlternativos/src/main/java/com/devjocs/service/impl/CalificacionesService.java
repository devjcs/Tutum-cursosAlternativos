package com.devjocs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.devjocs.model.Alumno;
import com.devjocs.model.RespuestaGeneral;
import com.devjocs.model.entity.CalificacionEntity;
import com.devjocs.model.request.ActualizaCalificacionRequest;
import com.devjocs.model.request.EliminaCalificacionRequest;
import com.devjocs.model.request.GuardaCalificacionRequest;
import com.devjocs.model.response.GenericResponse;
import com.devjocs.model.response.ObtenCalificacionResponse;
import com.devjocs.repository.IAlumnosRepository;
import com.devjocs.repository.ICalificacionesRepository;
import com.devjocs.repository.IMateriaRepository;
import com.devjocs.service.ICalificaciones;
import com.devjocs.utils.Constantes;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CalificacionesService extends Constantes implements ICalificaciones {

	@Autowired
	private IAlumnosRepository alumnosRepository;
	
	@Autowired
	private ICalificacionesRepository calificacionesRepository;
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Override
	public RespuestaGeneral<GenericResponse> guardaCalificacion(GuardaCalificacionRequest req) {
		RespuestaGeneral<GenericResponse> response = new RespuestaGeneral<>();
		try {
			CalificacionEntity query = calificacionesRepository.save(new CalificacionEntity(0, req.getIdMateria(), req.getIdUsuario(), req.getCalificacion(), new Date()));
			response = new RespuestaGeneral<GenericResponse>(HttpStatus.OK.value(), RESULT_SUCCESS_DESCRIPTION, new GenericResponse(OK, RESULT_SUCCESS_UPDATE));
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return response;
	}

	@Override
	public RespuestaGeneral<ObtenCalificacionResponse> obtenCalificacion(int req) {
		RespuestaGeneral<ObtenCalificacionResponse> response = new RespuestaGeneral<>();
		try {
			List<Alumno> query = calificacionesRepository.getUsuario(req);
			if (query != null) {
				float promedio = (float) (query.stream().mapToDouble(Alumno::getCalificacion).sum()/query.size());	
				response = new RespuestaGeneral<ObtenCalificacionResponse>(HttpStatus.OK.value(), RESULT_SUCCESS_DESCRIPTION, new ObtenCalificacionResponse(query, promedio));				
			}
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return response;
	}

	@Override
	public RespuestaGeneral<GenericResponse> actualizaCalificacion(ActualizaCalificacionRequest req) {
		RespuestaGeneral<GenericResponse> response = new RespuestaGeneral<>();
		try {
			CalificacionEntity query = calificacionesRepository.save(new CalificacionEntity(req.getIdCalificacion(), req.getIdMateria(), req.getIdUsuario(), req.getCalificacion(), new Date()));
			if (query != null) {
				response = new RespuestaGeneral<GenericResponse>(HttpStatus.OK.value(), RESULT_SUCCESS_DESCRIPTION, new GenericResponse(OK, RESULT_SUCCESS_UPDATE));				
			}
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return response;
	}

	@Override
	public RespuestaGeneral<GenericResponse> borraCalificacion(EliminaCalificacionRequest req) {
		RespuestaGeneral<GenericResponse> response = new RespuestaGeneral<>();
		try {
			calificacionesRepository.borraIdCalificacion(req.getIdCalificacion());
			response = new RespuestaGeneral<GenericResponse>(HttpStatus.OK.value(), RESULT_SUCCESS_DESCRIPTION, new GenericResponse(OK, RESULT_SUCCESS_UPDATE));
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return response;
	}

}
