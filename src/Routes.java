import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;

public class Routes {

    @WebRoute(route = "/test")
    public void redirectToTest(HttpExchange t) throws IOException {
        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(route = "/home")
    public void redirectToHome(HttpExchange t) throws IOException {
        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(route = "/try")
    public void redirectToTry(HttpExchange t) throws IOException {
        String response = "This is the response";
        t.sendResponseHeaders(200, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }

    @WebRoute(route = "/error")
    public void redirectToError(HttpExchange t) throws IOException {
        String response = "Wrong uri was given";
        t.sendResponseHeaders(404, response.length());
        OutputStream os = t.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}