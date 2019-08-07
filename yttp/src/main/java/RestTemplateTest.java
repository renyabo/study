import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RestTemplateTest {

    public static void main(String[] args) throws InterruptedException, IOException {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setConnectTimeout(100);
        factory.setReadTimeout(3000);
//        OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();

//        User user = new User();
//        user.setId(1L);
//
//        String forObject = template.getForObject("http://localhost:8080/set?key=1&value=2", String.class);
//        System.out.println(forObject);


//        List<HttpMessageConverter<?>> messageConverters = template.getMessageConverters();
//        messageConverters.clear();
//        messageConverters.add(new JsonbHttpMessageConverter());


//        JSONPObject jsonpObject = template.postForObject("http://localhost:8080/test", user, JSONPObject.class);

//        Response response = template.getForObject("http://localhost:8080/test", Response.class);
//        System.out.println(jsonpObject);
//        System.out.println(object);
//
//        HttpEntity<User> request = new HttpEntity<>(user);
//
//        ResponseEntity<Response> exchange = template.exchange("http://localhost:8080/test", HttpMethod.POST, request, Response.class);
//        Response body = exchange.getBody();
//        System.out.println(body);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 500; i++) {
            final int temp = i;
            executorService.submit(() -> {
                RestTemplate template = new RestTemplate();
                String response = template.getForObject("http://localhost:8080/insertOK", String.class);
                System.out.println(temp + "----->" + response);
            });
            Thread.sleep(50L);
            System.out.println(i);
        }
        System.in.read();
    }
}


class Response {
    int code;
    String message;
    int data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}