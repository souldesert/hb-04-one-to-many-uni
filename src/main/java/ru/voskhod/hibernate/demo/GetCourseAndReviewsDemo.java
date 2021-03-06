package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Course;
import ru.voskhod.hibernate.demo.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetCourseAndReviewsDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            int id = 10;
            Course course = entityManager.find(Course.class, id);

            // print the course
            System.out.println("Found course: " + course);

            System.out.println("Reviews for course are: " + course.getReviews());

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
