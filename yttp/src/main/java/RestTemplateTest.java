import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.yabo.common.beans.User;

public class RestTemplateTest {

    public static void main(String[] args) {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setConnectTimeout(100);
        factory.setReadTimeout(3000);
//        OkHttp3ClientHttpRequestFactory okHttp3ClientHttpRequestFactory = new OkHttp3ClientHttpRequestFactory();

        User user = new User();
        user.setId(1L);
        RestTemplate template = new RestTemplate();

        String forObject = template.getForObject("http://localhost:8080/set?key=1&value=2", String.class);
        System.out.println(forObject);


//        List<HttpMessageConverter<?>> messageConverters = template.getMessageConverters();
//        messageConverters.clear();
//        messageConverters.add(new JsonbHttpMessageConverter());


//        JSONPObject jsonpObject = template.postForObject("http://localhost:8080/test", user, JSONPObject.class);
//        String response = template.getForObject("http://localhost:8080/test", String.class);
//        Response response = template.getForObject("http://localhost:8080/test", Response.class);
//        System.out.println(jsonpObject);
//        System.out.println(object);

        HttpEntity<User> request = new HttpEntity<>(user);

        ResponseEntity<Response> exchange = template.exchange("http://localhost:8080/test", HttpMethod.POST, request, Response.class);
        Response body = exchange.getBody();
        System.out.println(body);
    }
}


class Response{
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