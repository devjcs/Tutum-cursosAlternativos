package com.devjocs.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Entity
@Table(name = "t_calificaciones")
public class CalificacionEntity implements Serializable{
	private static final long serialVersionUID = -9092062626878526790L;
	@Id
	@Column(name = "id_t_calificaciones")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCalificacion;
	@JoinColumn(name = "idMateria")
	private int idMateria;
	@JoinColumn(name = "idUsuario")
	private int idUsuario;
	@Column(precision=10, scale=2) 
	private float calificacion;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fecha;
}
