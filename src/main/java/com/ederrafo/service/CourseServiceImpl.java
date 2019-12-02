package com.ederrafo.service;

import com.ederrafo.entity.Course;
import com.ederrafo.repository.CourseRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseServiceImpl")
public class CourseServiceImpl implements CourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    // Inyectamos una dependencia
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> all() {
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod);
        return courseRepository.findAll();
    }

    @Override
    public Course store(Course course) {
        String nameofCurrentMethod = new Throwable().getStackTrace()[0].getMethodName();
        LOG.info("Call " + nameofCurrentMethod);
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
