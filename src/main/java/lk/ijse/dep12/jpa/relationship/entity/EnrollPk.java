package lk.ijse.dep12.jpa.relationship.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EnrollPk implements Serializable {
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "course_code")
    private String courseCode;
}
