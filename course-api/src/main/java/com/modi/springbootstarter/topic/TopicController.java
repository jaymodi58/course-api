package com.modi.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*
 * TopicController is system under test (SUT) & Dependency is topicService
 */
public class TopicController {

	@Autowired
	private ITopicService topicService;

	public TopicController(ITopicService topicService) {
		this.topicService = topicService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics")
	public List<Topic> getAllTopics() {

		return topicService.getAllTopics();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/topics/{id}")
	public Topic getTopic(@PathVariable String id) {

		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	private void addTopic(@RequestBody Topic topic) {

		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	private void updateTopic(@RequestBody Topic topic, @PathVariable String id) {

		topicService.updateTopic(topic, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {

		topicService.deleteTopic(id);
	}

}