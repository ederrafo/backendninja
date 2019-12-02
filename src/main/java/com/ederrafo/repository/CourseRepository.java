package com.ederrafo.repository;

import com.ederrafo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

// Creamos nuestro repositorio JPA
// En la interface no va la implementacion
@Repository
public interface CourseRepository extends JpaRepository<Course, Serializable> {

     Course findByPrice(BigDecimal price);
     Course findByPriceAndName(BigDecimal price, String name);
     List<Course> findByNameOrderByHours(String name);
     Course findByNameOrPrice(String name, BigDecimal price);
}
