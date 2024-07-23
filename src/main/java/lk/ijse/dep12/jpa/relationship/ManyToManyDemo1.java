package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Enroll;
import lk.ijse.dep12.jpa.relationship.entity.EnrollPk;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class ManyToManyDemo1 {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()){
            EntityTransaction tx = em.getTransaction();
            try{
                tx.begin();

                Student s001 = new Student("S001", "Sapumal", "Kurunegala", "071-1234567", Date.valueOf("1995-10-02"));
                Student s002 = new Student("S002", "Kamal", "Kandy", "076-1234567", Date.valueOf("1994-01-09"));
                Student s003 = new Student("S003", "Nimal", "Galle", "075-1234567", Date.valueOf("1993-02-07"));

                Course cmjd = new Course("CMJD", "Comprehensive JAVA Course", "6 Months");
                Course dep = new Course("DEP", "Direct Entry Program", "6 Months");

                Enroll e001 = new Enroll(s001, cmjd, "Tharindu", Date.valueOf(LocalDate.now()));
                Enroll e002 = new Enroll(s002, dep, "Samantha", Date.valueOf(LocalDate.now()));

                List.of(cmjd,dep,s001,s002,s003,e001,e002).forEach(em::persist);


                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                t.printStackTrace();
            }
        }
    }
}
