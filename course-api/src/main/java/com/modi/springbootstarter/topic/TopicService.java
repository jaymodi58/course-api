package com.modi.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService implements ITopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	@Override
	public Topic getTopic(String id) {

		Optional<Topic> optionalTopic = topicRepository.findById(id);
		if (optionalTopic.isPresent()) {
			return optionalTopic.get();
		}

		return null;
	}

	@Override
	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	@Override
	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
	}

	@Override
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}
}