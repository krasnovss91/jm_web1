import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MainServlet;
import servlets.RequestServlet;


public class Main {

    public static void main(String[] args) throws Exception {
        MainServlet mainServlet = new MainServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(mainServlet), "/");

        RequestServlet rs = new RequestServlet();
        context.addServlet(new ServletHolder(rs),"/mult");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();


    }
}
