package com.modi.springbootstarter.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {

		return Arrays.asList(
				new Topic("spring", "spring framework", "SPRING_DES"),
				new Topic("java", "core Java", "JAVA_DES"),
				new Topic("javascript", "javascript framework", "JAVASCRIPT_DES")
				);
	}
}
