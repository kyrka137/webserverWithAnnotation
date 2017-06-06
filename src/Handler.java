import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by keli on 2017.06.06..
 */
public class Handler {

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {

            Class<Routes> obj = Routes.class;

            // iterate through the obj's methods
            for (Method method : obj.getDeclaredMethods()) {

                // if method is annotated with @WebRoute
                if (method.isAnnotationPresent(WebRoute.class)) {

                    Annotation annotation = method.getAnnotation(WebRoute.class);
                    WebRoute webRoute = (WebRoute) annotation;

                    // if annotation value equal with uri as string
                    if (webRoute.route().equals(t.getRequestURI().toString())) {
                        try {
                            method.invoke(obj.newInstance(), t);
                            System.out.println(String.format("Method name: %s", method.getName()));
                            return;
                        } catch (Throwable ex) {
                            ex.printStackTrace();
                            System.out.println(String.format("Method name: %s", method.getName()));
                        }
                    }
                }
            }

            // if wrong uri was given
            try {
                obj.newInstance().redirectToError(t);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}