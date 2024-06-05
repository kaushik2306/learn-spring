package dev.kc.learnspring.course;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.StringJoiner;

@Entity
@Table(name = "course")
public class CourseModel {

    @Id
    @GeneratedValue
    private Long id;

    private String courseName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CourseModel.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("courseName='" + courseName + "'")
                .toString();
    }
}
