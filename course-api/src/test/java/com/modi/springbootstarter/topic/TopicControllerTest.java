package com.modi.springbootstarter.topic;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TopicControllerTest {

	@Test
	public void getAllTopics() {

		ITopicService topicServiceMock = mock(TopicService.class);

		List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "spring framework", "SPRING_DES"),
				new Topic("java", "core Java", "JAVA_DES"),
				new Topic("javascript", "javascript framework", "JAVASCRIPT_DES")));

		when(topicServiceMock.getAllTopics()).thenReturn(topics);

		TopicController topicController = new TopicController(topicServiceMock);

		List<Topic> outputTopics = topicController.getAllTopics();

		assertEquals(3, outputTopics.size());

	}

	@Test
	public void getTopic() {

		ITopicService topicServiceMock = mock(TopicService.class);

		when(topicServiceMock.getTopic("java")).thenReturn(new Topic("java", "core Java", "Java_Desc"));

		TopicController topicController = new TopicController(topicServiceMock);

		Topic topic = topicController.getTopic("java");

		assertEquals("java", topic.getId());
		assertEquals("core Java", topic.getName());
		assertEquals("Java_Desc", topic.getDescription());

	}
}