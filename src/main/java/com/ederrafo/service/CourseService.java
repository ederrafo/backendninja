package com.ederrafo.service;

import com.ederrafo.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    List<Course> all();
    Course store(Course course);
    int remove(int id);
    Course update(Course course);

}
