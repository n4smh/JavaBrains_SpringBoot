package io.n4smh.sample.course;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;

	public List<Course> getCourses(String topicId) {
		List<Course> course = new ArrayList<Course>();
		courseRepository.findByTopicId(topicId).forEach(course::add);

		return course;
	}

	public Course getCourse(String id) {
		Optional<Course> response = courseRepository.findById(id);
		return response.get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);

	}

}
