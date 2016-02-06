package com.sai.WholesaleTransport.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class TimestampJsonSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) 
			throws IOException, JsonProcessingException {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
		jsonGenerator.writeString(dateFormat.format(date));
	}
}
