package com.xanderhub.flightapp;

import com.sun.deploy.net.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FlightAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FlightAppApplicationTests {

	@Test
	public void contextLoads() throws IOException {
		// Given
		HttpUriRequest request = new HttpGet( "http://localhost:8080/api/tickets?ticketId=100");

		// When
		CloseableHttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

		// Then
		assertThat(
				httpResponse.getStatusLine().getStatusCode(),
				equalTo(HttpStatus.SC_OK));
	}

}
