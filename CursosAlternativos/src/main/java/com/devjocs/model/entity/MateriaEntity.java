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
@Table(name = "t_materias")
public class MateriaEntity implements Serializable{
	private static final long serialVersionUID = -9092062626878526790L;
	@Id
	@Column(name = "id_t_materias")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMateria;
	@Column(length = 80)
	private String nombre;
	@Column(length = 1)
	private int activo;
}
