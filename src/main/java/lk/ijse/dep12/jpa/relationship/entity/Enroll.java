package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enroll")
public class Enroll implements Serializable {
    @EmbeddedId
    private EnrollPk enrollPk;
    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseCode")
    private Course course;

    public Enroll(EnrollPk enrollPk, String registeredBy, Date date) {
        this.enrollPk = enrollPk;
        this.registeredBy = registeredBy;
        this.date = date;
    }

    public Enroll(Student student,Course course, String registeredBy, Date date) {
        this.enrollPk = new EnrollPk(student.getId(), course.getCode());
        this.registeredBy = registeredBy;
        this.date = date;
        this.course = course;
        this.student = student;
    }


}
