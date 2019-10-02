package commonAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import hello.Test;

public class FetchData {

	
	
	public static String getToken(Test user) throws MalformedURLException {

		// Adding double quotes
		String passWord = "\"" + user.getPassword() + "\"";
		String userName = "\"" + user.getUsername() + "\"";

		// initializing token string
		String token = null;

		// getToken body data
		final String getTokenBodyParams = "{" + "\"username\": " + userName + ", " + "\"password\": " + passWord + ""
				+ "}";

		// initializing URL end point
		URL getTokenURLobject = new URL("https://apq.inner-circle.io/getToken");

		// initializing and building request method and headers.
		HttpURLConnection getTokenRequest = null;
		try {
			getTokenRequest = (HttpURLConnection) getTokenURLobject.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getTokenRequest.setRequestMethod("POST");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getTokenRequest.setRequestProperty("Connection", "keep-alive");
		getTokenRequest.setRequestProperty("Accept", "application/json");
		getTokenRequest.setRequestProperty("Origin", "https://portal.inner-circle.io");
		getTokenRequest.setRequestProperty("Host", "apq.inner-circle.io");
		getTokenRequest.setRequestProperty("Content-Type", "application/json");
		getTokenRequest.setDoOutput(true);

		// Sending the request.
		OutputStream getTokenOutputStream = null;
		try {
			getTokenOutputStream = getTokenRequest.getOutputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getTokenOutputStream.write(getTokenBodyParams.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getTokenOutputStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			getTokenOutputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// fetching response code.
		int getTokenResponseCode = 0;
		try {
			getTokenResponseCode = getTokenRequest.getResponseCode();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("/getToken Response Code :  " + getTokenResponseCode  );
		try {
			System.out.println("/getToken Response Message : " + getTokenRequest.getResponseMessage() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if response code is 200, continue.
		if (getTokenResponseCode == 200) { // success
			// Writing response data
			BufferedReader getTokenBufferReader = null;
			try {
				getTokenBufferReader = new BufferedReader(new InputStreamReader(getTokenRequest.getInputStream()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String getTokenInputLine;
			StringBuffer getTokenResponse = new StringBuffer();
			try {
				while ((getTokenInputLine = getTokenBufferReader.readLine()) != null) {
					getTokenResponse.append(getTokenInputLine);

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				getTokenBufferReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// inserting response body to string (token)
			token = getTokenResponse.toString();

			// printing the fetched token.
			System.out.println("Token to use: " + token + "\n");

		}
		return token;

	}
	
	
	
}
