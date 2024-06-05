package dev.kc.learnspring.course;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class CourseService {

    private final DataSource dataSource;

    public CourseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Transactional
    public void create(CourseModel courseModel){
        try {
            String sql = "insert into course (course_name) values('%s')".formatted(courseModel.getCourseName());
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
