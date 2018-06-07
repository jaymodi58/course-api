package com.modi.springbootstarter.topic;

import java.util.List;
import java.util.Optional;

public interface ITopicService {

	List<Topic> getAllTopics();

	Optional<Topic> getTopic(String id);

	void addTopic(Topic topic);

	void updateTopic(Topic topic, String id);

	void deleteTopic(String id);
}