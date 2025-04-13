package org.vkbot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vkbot.client.VkApiClient;
import org.vkbot.dto.VkEvent;

@Service
@RequiredArgsConstructor
public class VkService {

  private final VkApiClient client;

  public void echoMessage(VkEvent event) {
    client.sendMessage(event.getObject().getMessage().getFromId(), event.getObject().getMessage().getText());
  }

}

