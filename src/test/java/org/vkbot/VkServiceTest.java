package org.vkbot;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vkbot.client.VkApiClient;
import org.vkbot.dto.VkEvent;
import org.vkbot.dto.VkMessage;
import org.vkbot.dto.VkObject;
import org.vkbot.service.VkService;

@ExtendWith(MockitoExtension.class)
public class VkServiceTest {

  @Mock
  private VkApiClient vkApiClient;

  @InjectMocks
  private VkService vkService;

  @Test
  void handleMessage_shouldCallSendMessage() {
    var message = new VkMessage().setFromId(1L).setText("квеве");
    var vkObject = new VkObject().setMessage(message);
    var event = new VkEvent().setObject(vkObject);
    vkService.echoMessage(event);
    verify(vkApiClient).sendMessage(1L, "квеве");
  }
}
