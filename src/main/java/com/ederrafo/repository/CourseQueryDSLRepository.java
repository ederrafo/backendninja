package com.ederrafo.repository;

import com.ederrafo.entity.Course;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Repository;
import com.ederrafo.entity.QCourse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository("courseQueryDSLRepository")
public class CourseQueryDSLRepository {

    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager em;

    public Course find(boolean exist) {
        JPAQuery<Course> query = new JPAQuery<Course>(em);

        BooleanBuilder booleanBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if (exist) {
            Predicate predicate = qCourse.id.eq(2);
            booleanBuilder.and(predicate);
        } else {
            Predicate predicate2 = qCourse.name.endsWith("OP");
            booleanBuilder.or(predicate2);

        }
        // Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

        return query.select(qCourse).from(qCourse).where(booleanBuilder).fetchOne();
    }

}
