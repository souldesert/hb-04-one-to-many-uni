package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Course;
import ru.voskhod.hibernate.demo.entity.Instructor;
import ru.voskhod.hibernate.demo.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // create a course
            Course course = new Course("Pacman: How To Score One Million Points");

            // add some reviews
            course.addReview(new Review("Great course - loved it!"));
            course.addReview(new Review("Cool course, job well done"));
            course.addReview(new Review("What a dumb course, you're an idiot!"));

            // save the course ... and leverage the cascade all
            System.out.println("Saving the course: " + course);
            System.out.println("Along with reviews:" + course.getReviews());

            entityManager.persist(course);





            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
