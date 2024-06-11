import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;


public class MyServer {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int port = 8010;
		new MyServer().start(port);
	}

	private void start(int port) throws Exception{
    	// 1. Web Server, Server Connector 생성
		Server server = new Server();
		ServerConnector httpConector = new ServerConnector(server);
		httpConector.setHost("127.0.0.1");
		httpConector.setPort(port);
		server.addConnector(httpConector);
		
        // 2. Servlet Handler 매핑
		ServletHandler servletHandler = new ServletHandler();
		ServletHolder servletHolder = new ServletHolder(MyServlet.class);
		servletHolder.setInitParameter("hillee", "hillee");
		servletHandler.addServletWithMapping(servletHolder, "/");
		server.setHandler(servletHandler);
				
        // 3. Web Server start
		server.start();
		server.join();
		
	}
}
