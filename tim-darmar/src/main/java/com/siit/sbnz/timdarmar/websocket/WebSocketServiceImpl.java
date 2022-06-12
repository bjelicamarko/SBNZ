package com.siit.sbnz.timdarmar.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketServiceImpl implements WebSocketService {

	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
	
	@Override
	public void sendNotifications(String email) {
		this.simpMessagingTemplate.convertAndSend(String.format("/socket-publisher/%s", email), "Banned user with " + email + "!");
	}

	
}
