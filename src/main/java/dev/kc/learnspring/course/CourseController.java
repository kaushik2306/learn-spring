package dev.kc.learnspring.course;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public String hello(){
        return "Hello";
    }

    @PostMapping
    public void createCourse(@RequestBody CourseModel courseModel){
        courseService.create(courseModel);
    }
}
