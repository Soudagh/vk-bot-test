package org.vkbot.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class VkObject {

  private VkMessage message;
}
