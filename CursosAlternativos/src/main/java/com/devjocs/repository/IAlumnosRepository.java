package com.devjocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjocs.model.entity.AlumnoEntity;

public interface IAlumnosRepository extends JpaRepository<AlumnoEntity, String>{

}
