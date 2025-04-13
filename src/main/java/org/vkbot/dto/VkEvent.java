package org.vkbot.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VkEvent {

  private String type;

  private VkObject object;
}

