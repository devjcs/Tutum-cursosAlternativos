package com.devjocs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devjocs.model.Alumno;
import com.devjocs.model.entity.CalificacionEntity;

public interface ICalificacionesRepository extends JpaRepository<CalificacionEntity, String>{
	@Query("SELECT new com.devjocs.model.Alumno(a.idUsuario, c.idCalificacion, a.nombre, a.apPaterno, m.nombre, c.calificacion, c.fecha) FROM CalificacionEntity c JOIN AlumnoEntity a ON a.idUsuario = c.idUsuario JOIN MateriaEntity m ON m.idMateria = c.idMateria WHERE a.idUsuario = ?1")
	public List<Alumno> getUsuario(int idUsuario);
	@Transactional
	@Modifying
	@Query("DELETE CalificacionEntity WHERE idCalificacion = ?1")
	public void borraIdCalificacion(int idCalificacion);
}
