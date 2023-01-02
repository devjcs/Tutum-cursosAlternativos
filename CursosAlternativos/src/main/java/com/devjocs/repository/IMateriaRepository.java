package com.devjocs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devjocs.model.entity.MateriaEntity;

public interface IMateriaRepository extends JpaRepository<MateriaEntity, String>{

}
