package org.vkbot.client;


import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
@RequiredArgsConstructor
public class VkApiClient {

  private final RestClient restClient;

  public static final String BASE_METHOD_URL = "https://api.vk.com/method/messages.send";

  public static final String BOT_RESPONSE_MESSAGE_TEMPLATE = "Вы сказали: %s";

  @Value("${vk.token}")
  private String token;

  @Value("${vk.api_version}")
  private String apiVersion;

  public void sendMessage(long peerId, String message) {
    var randomId = new Random().nextLong();

    var url = UriComponentsBuilder
        .fromUriString(BASE_METHOD_URL)
        .queryParam("peer_id", peerId)
        .queryParam("message", BOT_RESPONSE_MESSAGE_TEMPLATE.formatted(message))
        .queryParam("random_id", randomId)
        .queryParam("access_token", token)
        .queryParam("v", apiVersion)
        .build()
        .toUriString();

    restClient.get()
        .uri(url)
        .retrieve()
        .body(String.class);
  }
}
