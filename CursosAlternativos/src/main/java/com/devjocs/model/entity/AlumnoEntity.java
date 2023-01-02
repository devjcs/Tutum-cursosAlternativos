package com.devjocs.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "t_alumnos")
public class AlumnoEntity implements Serializable{
	private static final long serialVersionUID = -9092062626878526790L;
	@Id
	@Column(name = "id_t_usuarios")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;
	@Column(length = 80)
	private String nombre;
	@Column(name = "ap_paterno", length = 80)
	private String apPaterno;
	@Column(name = "ap_materno", length = 80)
	private String apMaterno;
	@Column(length = 1)
	private int activo;
}