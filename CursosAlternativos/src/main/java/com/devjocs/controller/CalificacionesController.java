package com.devjocs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devjocs.model.RespuestaGeneral;
import com.devjocs.model.request.ActualizaCalificacionRequest;
import com.devjocs.model.request.EliminaCalificacionRequest;
import com.devjocs.model.request.GuardaCalificacionRequest;
import com.devjocs.model.response.GenericResponse;
import com.devjocs.model.response.ObtenCalificacionResponse;
import com.devjocs.service.ICalificaciones;
import com.devjocs.utils.Constantes;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@Log4j2
@CrossOrigin(origins = "*")
@RestController
public class CalificacionesController extends Constantes{

	
	@Autowired
	private ICalificaciones calificaciones;
	
	@ApiOperation(value = "Permite dar de alta una calificación")
	@PostMapping("/calificacion")
	public ResponseEntity<RespuestaGeneral<GenericResponse>> guardaCalificacion(@RequestBody GuardaCalificacionRequest req) {
		RespuestaGeneral<GenericResponse> response = new RespuestaGeneral<>();
		try {
			response = calificaciones.guardaCalificacion(req);
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return ResponseEntity.status(response.getCode()).body(response);
	}
	
	@ApiOperation(value = "Permite obtener la lista de calificaciónes del alumno")
	@GetMapping("/calificacion/{id}")
	public ResponseEntity<RespuestaGeneral<ObtenCalificacionResponse>> obternerCalificacion(@RequestParam int req) {
		RespuestaGeneral<ObtenCalificacionResponse> response = new RespuestaGeneral<>();
		try {
			response = calificaciones.obtenCalificacion(req);
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return ResponseEntity.status(response.getCode()).body(response);
	}
	
	@ApiOperation(value = "Permite actualizar una calificación")
	@PutMapping("/calificacion")
	public ResponseEntity<RespuestaGeneral<GenericResponse>> actualizaCalificacion(@RequestBody ActualizaCalificacionRequest req) {
		RespuestaGeneral<GenericResponse> response = new RespuestaGeneral<>();
		try {
			response = calificaciones.actualizaCalificacion(req);
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return ResponseEntity.status(response.getCode()).body(response);
	}
	
	@ApiOperation(value = "Permite eliminar una calificación")
	@DeleteMapping("/calificacion")
	public ResponseEntity<RespuestaGeneral<GenericResponse>> borraCalificacion(@RequestBody EliminaCalificacionRequest req) {
		RespuestaGeneral<GenericResponse> response = new RespuestaGeneral<>();
		try {
			response = calificaciones.borraCalificacion(req);
		} catch (Exception e) {
			log.info("Exception: ".concat(e.getMessage()));
			response = new RespuestaGeneral<>(HttpStatus.BAD_REQUEST.value(), RESULT_BAD_REQUEST);
		}
		return ResponseEntity.status(response.getCode()).body(response);
	}
}
