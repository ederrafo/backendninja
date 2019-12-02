package com.ederrafo.service;

import com.ederrafo.entity.Course;
import com.ederrafo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    // Inyectamos una dependencia
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> all() {
        return courseRepository.findAll();
    }

    @Override
    public Course store(Course course) {
        // Si lo guardamos correctamente nos devolvera ese nuevo objeto
        return courseRepository.save(course);
    }

    @Override
    public int remove(int id) {
        //courseRepository.delete(id);
        return 0;
    }

    @Override
    public Course update(Course course) {
        return courseRepository.save(course);
    }
}
