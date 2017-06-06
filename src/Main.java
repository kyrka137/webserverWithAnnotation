import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

public class Main {

    @WebRoute(route = "/test")
    static void onTest() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new Handler.MyHandler());
        server.start();
    }


    public static void main(String[] args) throws Exception {
        Main.onTest();

    }
}
