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
    @JoinColumn(name = "student_id" , referencedColumnName = "id", insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_code" , referencedColumnName = "code", insertable = false,updatable = false)
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
    }


}
