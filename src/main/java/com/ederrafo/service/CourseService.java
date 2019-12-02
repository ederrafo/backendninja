package com.ederrafo.service;

import com.ederrafo.entity.Course;

import java.util.List;


public interface CourseService {

    List<Course> all();
    Course store(Course course);
    int remove(int id);
    Course update(Course course);

}
