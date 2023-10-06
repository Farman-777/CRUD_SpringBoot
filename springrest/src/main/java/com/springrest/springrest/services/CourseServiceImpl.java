package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;
	
	public CourseServiceImpl() {
		list = new ArrayList<>();
		list.add(new Course(145, "First Course", "This is First Course"));
		list.add(new Course(146, "Second Course", "This is Second Course"));
		list.add(new Course(147, "Third Course", "This is Third Course"));
	}

	@Override
	public List<Course> getCourses() {
	
		return list;
	}

	@Override
	public Course getCourse(long courseId) {
		Course c=null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				c=course;
				break;
			}
		}
		return c;
	}

	@Override
	public Course addCourse(Course course) {
		list.add(course);
		return course;
	}
	
	@Override
	public Course updateCourse(long courseId, Course updatedCourse) {
	    for (Course course : list) {
	        if (course.getId() == courseId) {
	            // Update the existing course with the new data
	            course.setTitle(updatedCourse.getTitle());
	            course.setDescription(updatedCourse.getDescription());
	            return course; // Return the updated course
	        }
	    }
	    return null; // Return null if no course with the specified courseId was found
	}
	
	@Override
	public boolean deleteCourse(long courseId) {
	    for (Iterator<Course> iterator = list.iterator(); iterator.hasNext();) {
	        Course course = iterator.next();
	        if (course.getId() == courseId) {
	            iterator.remove(); // Remove the course from the list
	            return true; // Return true to indicate successful deletion
	        }
	    }
	    return false; // Return false if no course with the specified courseId was found
	}

}
