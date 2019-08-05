package io.n4smh.sample.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.n4smh.sample.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService topicService;

	@RequestMapping("/topics/{topicId}/course")
	public List<Course> returnAllCourse(@PathVariable String topicId) {
		return topicService.getCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/course/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return topicService.getCourse(courseId);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/course")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		topicService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/course/{courseId}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		topicService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}/course/{courseId}")
	public void deleteCourse(@PathVariable String id) {
		topicService.deleteCourse(id);
	}

}
