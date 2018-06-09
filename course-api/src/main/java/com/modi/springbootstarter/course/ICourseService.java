package com.modi.springbootstarter.course;

import java.util.List;

public interface ICourseService {

	List<Course> getAllCourses(String topicId);

	Course getCourse(String id);

	void addCourse(Course course);

	void updateCourse(Course course);

	void deleteCourse(String id);

}