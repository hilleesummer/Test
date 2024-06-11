import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.HttpMethod;
import org.eclipse.jetty.http.HttpStatus;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class MyServlet extends HttpServlet {
	private List<DeviceInfo> device_info_list;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		Device device = readDeviceInfoFile();
		device_info_list = device.getDeviceInfo();
		//System.out.println(getInitParameter("hillee"));
	}

	// json 파일을 읽는다.
	private Device readDeviceInfoFile() {
		// TODO Auto-generated method stub
		Device device = null;
		try {
			Gson gson = new Gson();
			BufferedReader reader = Files.newBufferedReader(Paths.get("./INFO/DEVICE.JSON"));
			device = gson.fromJson(reader, Device.class);
			reader.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// Server에 String Data를 송신한다.
	private ContentResponse sendToServer(String url, HttpMethod httpMethod, String data) {
		HttpClient httpClient;
		ContentResponse contentResponse = null;
		try {
			httpClient = new HttpClient();
			httpClient.start();
			
			Request request = httpClient.newRequest(url);
			request.method(httpMethod);
			request.header(HttpHeader.CONTENT_TYPE, "application/json");
			request.content(new StringContentProvider(data, "utf-8"));
			
			contentResponse = request.send();
			httpClient.stop();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return contentResponse;
	}
	
	// client가 송신한 content를 String으로 리턴한다.
	public String getReqContent(HttpServletRequest request) throws IOException {

		String body = null;
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;

		try {
			InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					stringBuilder.append(charBuffer, 0, bytesRead);
				}
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException ex) {
					throw ex;
				}
			}
		}

		body = stringBuilder.toString();
		return body;
	}
	
	// json file을 업데이트
	public void updateJsonFile(String key, String value) {
		String str = null;
		try {
			Gson gson = new Gson();
			BufferedReader reader = Files.newBufferedReader(Paths.get("VARIABLE.JSON"));
			HashMap<String, String> map = new HashMap<String, String>();
			map = gson.fromJson(reader, HashMap.class);
			reader.close();
			map.replace(key, value);
			FileWriter writer = new FileWriter("VARIABLE.JSON");
			gson.toJson(map, writer);
			writer.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setStatus(HttpStatus.OK_200);
		res.getWriter().write("Welcome to my server.");
		String reqUri = req.getRequestURI();
		String[] pathParam = reqUri.split("/");
		
		HttpClient httpClient = new HttpClient();
		String uri = "http://www.naver.com:8080/";
		try {
			ContentResponse contentResponse = httpClient.newRequest(uri).method(HttpMethod.GET).send();
			Type type = new TypeToken<Map<String, String>>(){}.getType();
			Map<String, String> map = new Gson().fromJson(contentResponse.getContentAsString(), type);
			Iterator<String> iter = map.keySet().iterator();
			while( iter.hasNext()) {
				String key = iter.next();
				String value = (String)map.get(key);
				updateJsonFile(key, value);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, IOException {
        // 1.request
    	String reqUri = req.getRequestURI();
        String[] pathParam = reqUri.split("/");
        
        // 2.수신한 content
        String reqContent = getReqContent(req);
        
        // 3.수신한 path별 json content 처리
        if(reqUri.startsWith("/fromServer")) {
        	
        	// 3-1. client로 부터 수신한 json content 파싱
        	ServerRequest serverRequest = new Gson().fromJson(reqContent, ServerRequest.class);
        	//System.out.println(serverRequest.getCommand() + " " + serverRequest.getTargetDevice() + " " + serverRequest.getParam());
        	
        	// 3-2. server로 송신할 json content 생성 후 송신
        	Map<String, String> map = new HashMap<String, String>();
        	map.put("command", serverRequest.getCommand());
        	map.put("param", serverRequest.getParam());
        	String uri = "https://www.naver.com:8080/";
        	ContentResponse contentResponse = sendToServer(uri, HttpMethod.POST, new Gson().toJson(map));
        	
        	// 3-4. server 응답 json content 파싱
        	DeviceResponse deviceResponse = new Gson().fromJson(contentResponse.getContentAsString(), DeviceResponse.class);
        	
        	// 3-5. server 응답을 그대로 Client에 Forward
        	String msg = new Gson().toJson(deviceResponse);
        	res.setStatus(HttpStatus.OK_200);
        	res.getWriter().write(msg);
        }
        
    }
}
