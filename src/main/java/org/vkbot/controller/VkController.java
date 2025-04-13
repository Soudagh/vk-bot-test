package org.vkbot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vkbot.dto.VkEvent;
import org.vkbot.service.VkService;

@RestController
@RequiredArgsConstructor
public class VkController {

  @Value("${vk.confirmation_code}")
  private String confirmationCode;

  private final VkService vkService;

  @PostMapping
  public ResponseEntity<String> handleCallback(@RequestBody VkEvent event) {
    return switch (event.getType()) {
      case "confirmation" -> ResponseEntity.ok(confirmationCode);
      case "message_new" -> {
        vkService.echoMessage(event);
        yield ResponseEntity.ok("ok");
      }
      default -> ResponseEntity.ok("unsupported");
    };
  }
}

