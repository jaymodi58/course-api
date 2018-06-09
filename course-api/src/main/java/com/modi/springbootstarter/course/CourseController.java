package com.modi.springbootstarter.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.modi.springbootstarter.topic.Topic;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "Course operations", description = "It does all the course operation within the specfied topic.")
public class CourseController {

	@Autowired
	private CourseService courseService;

	@ApiOperation(value = "It returns the all the courses of the specified topic(by topic id).")
	@ApiResponses(value = { @ApiResponse(code = 522, message = "API's own internal error"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId) {

		return courseService.getAllCourses(topicId);
	}

	@ApiOperation(value = "It returns the course based on topic id and course id.")
	@RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{id}")
	public Optional<Course> getCourse(@PathVariable String id) {

		return courseService.getCourse(id);
	}

	@ApiOperation(value = "It adds the course for the specific topic(by topic id).")
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	private void addTopic(@PathVariable String topicId, @RequestBody Course course) {

		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	@ApiOperation(value = "It updates the course(by course id) for the specific topic(by topic id).")
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	private void updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {

		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@ApiOperation(value = "It deletes the course(by course id) for the specific topic(by topic id).")
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {

		courseService.deleteCourse(id);
	}

}