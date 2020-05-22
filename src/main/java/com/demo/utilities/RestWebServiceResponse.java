package com.demo.utilities;


//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;
//import javax.ws.rs.core.MediaType;
//import sun.misc.BASE64Encoder;
//import io.restassured.http.ContentType;
//@SuppressWarnings("restriction")
//public class RestWebServiceResponse {
//
//	public static final MediaType[] APPLICATION_JSON_TYPE = { new MediaType("application", "json") };
//
//	public static String getResponse(String endPoint, String methodName, String name, String password) {
//
//		Client restClient = Client.create();
//		WebResource webResource = restClient.resource(endPoint + "/" + methodName);
//		String authStringEnc = new BASE64Encoder().encode((name + ":" + password).getBytes());
//		ClientResponse resp = (ClientResponse) ((WebResource.Builder) webResource.accept(APPLICATION_JSON_TYPE)
//				.header("Authorization", "Basic " + authStringEnc)).get(ClientResponse.class);
//		if (resp.getStatus() != 200) {
//			System.err.println("Unable to connect to the server");
//		}
//		String output = (String) resp.getEntity(String.class);
//		System.out.println("Get Response: " + output);
//		return output;
//	}
//
//	public static String postResponse(String endPoint, String methodName, String input) {
//
//		Client restClient = Client.create();
//		WebResource webResource = restClient.resource(endPoint + "/" + methodName);
//		ClientResponse resp = (ClientResponse) webResource.type("application/json").post(ClientResponse.class, input);
//		if (resp.getStatus() != 200) {
//			System.err.println("Unable to connect to the server");
//		}
//		String output = (String) resp.getEntity(String.class);
//		System.out.println("Post Response: " + output);
//		return output;
//	}
//
//	public static String putResponse(String endPoint, String methodName, String input) {
//		
//		Client restClient = Client.create();
//		WebResource webResource = restClient.resource(endPoint + "/" + methodName);
//		ClientResponse resp = (ClientResponse) webResource.type("application/json").put(ClientResponse.class, input);
//		if (resp.getStatus() != 200) {
//			System.err.println("Unable to connect to the server");
//		}
//		String output = (String) resp.getEntity(String.class);
//		System.out.println("Put Response: " + output);
//		return output;
//	}
//
//	public static String deleteResponse(String endPoint, String methodName, String input) {
//		
//		Client restClient = Client.create();
//		WebResource webResource = restClient.resource(endPoint + "/" + methodName);
//		ClientResponse resp = (ClientResponse) webResource.type("application/json").delete(ClientResponse.class, input);
//		if (resp.getStatus() != 200) {
//			System.err.println("Unable to connect to the server");
//		}
//		String output = (String) resp.getEntity(String.class);
//		System.out.println("Delete Response: " + output);
//		return output;
//	}
//}