package com.modi.springbootstarter.topic;

import java.util.List;

public interface ITopicService {

	List<Topic> getAllTopics();

	Topic getTopic(String id);

	void addTopic(Topic topic);

	void updateTopic(Topic topic, String id);

	void deleteTopic(String id);
}