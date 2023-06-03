package com.unochapeco.example.configuration;

import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

public class JacksonObjectCustomizer {
	
	public static Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
		return builder -> {
			builder.simpleDateFormat("yyyy-MM-dd");
			builder.serializers(new LocalDateSerializer(DateTimeFormatter.ISO_DATE));
			builder.serializers(new LocalDateTimeSerializer(DateTimeFormatter.ISO_DATE_TIME));
		};
	}
	
}
