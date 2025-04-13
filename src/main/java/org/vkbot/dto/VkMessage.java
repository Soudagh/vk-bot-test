package org.vkbot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VkMessage {

  @JsonProperty("peer_id")
  private long peerId;

  @JsonProperty("from_id")
  private long fromId;

  private String text;
}
