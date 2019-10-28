package com.example.demo.domain.localDate;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @program: demo
 * @description:
 * @author: wenky huwenqi@panda-fintech.com
 * @create: 2019-10-28 14:45
 */
public class LocalDateTimeConverter extends JsonSerializer<LocalDateTime> {
  // xxx 2
  @Override
  public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException {
    gen.writeNumber(value.toInstant(ZoneOffset.of("+8")).toEpochMilli());
  }
}
