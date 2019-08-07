import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class EasyPost {

    static String BankerId = "AA10";
    static String plantId_or_userId = "9oq7hoqk6c";
    static String plantKey = "8231X3378T5T66EE1Y01J21IY2IY2371";
    static String priceid = "AA10ups002";

    static RestTemplate restTemplate = new RestTemplate();

    static {
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        int index = -1;
        for (int i = 0; i < messageConverters.size(); i++) {
            if (messageConverters.get(i) instanceof StringHttpMessageConverter) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            messageConverters.set(index, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        }
    }

    static void getUserPriceList() {

        String reqBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.eship.logisticstb/\">\n" +
                "  <soapenv:Header/>\n" +
                "  <soapenv:Body>\n" +
                "     <ser:getUserPriceList>\n" +
                "      <request> \n" +
                "        <clientInfo> \n" +
                "          <bankerId>AA10</bankerId>\n" +
                "          <plantId>9oq7hoqk6c</plantId>\n" +
                "          <plantKey>8231X3378T5T66EE1Y01J21IY2IY2371</plantKey>\n" +
                "          <userId>9oq7hoqk6c</userId> \n" +
                "        </clientInfo>\n" +
                "      </request>\n" +
                "    </ser:getUserPriceList>\n" +
                "  </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("SOAPAction", "");
        requestHeaders.add("Content-type", "text/xml;charset=UTF-8");

        //HttpEntity
        HttpEntity<String> requestEntity = new HttpEntity<String>(reqBody, requestHeaders);
        //post
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://ws.xn--7hvv57c8im.com:8401/lgtbws/eship/getUserPriceList", requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

    static void order() {

        String reqBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ser=\"http://service.eship.logisticstb/\">\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "  <soapenv:Header/>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "  <soapenv:Body>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "    <ser:orderShip>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "      <request> \t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "        <clientInfo> \t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <bankerId>AA10</bankerId>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <plantId>9oq7hoqk6c</plantId>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <plantKey>8231X3378T5T66EE1Y01J21IY2IY2371</plantKey>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <userId>9oq7hoqk6c</userId> \t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "        </clientInfo>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "        <orderList>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <signature>0</signature>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <orderId>ceshi</orderId>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <priceId>AA10ups002</priceId>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <description>ceshi</description>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <referenceNumber>ceshi</referenceNumber>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <packageType>02</packageType>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <taxdutyType>R</taxdutyType>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <shipTo>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <userName>test</userName>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <companyName>Sarah Ally</companyName>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <phoneNumber>2292538766</phoneNumber>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <email>80359854@qq.com</email>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <address>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <address1>4858 summit ridge rd</address1>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <city>JUNEAU</city>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <country>US</country>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <province>AK</province>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <postalCode>99802</postalCode>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            </address>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          </shipTo>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <packageList>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <weight>1</weight>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <length>1</length>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <width>1</width>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <height>1</height>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <count>1</count>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          </packageList>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <invoice>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <currencyCode>USD</currencyCode>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <shipmentTerms>FOB</shipmentTerms>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <exportReason>SAMPLE</exportReason>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <insuranceCharges>0</insuranceCharges>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <freightCharges>0</freightCharges>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <invoiceDetailList>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <descriptionEn>test</descriptionEn>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <descriptionCn>测试</descriptionCn>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <partNumber>001</partNumber>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <commodityCode>3919909090</commodityCode>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <originCountry>CN</originCountry>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <weight>1</weight>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <currencyValue>1</currencyValue>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <unitCount>1</unitCount>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "              <measure>PCS</measure>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            </invoiceDetailList>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          </invoice>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          <label>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <labelType>C</labelType>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "            <printLabel>Y</printLabel>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "          </label>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "        </orderList>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "      </request>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "    </ser:orderShip>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "  </soapenv:Body>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n" +
                "</soapenv:Envelope>";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("SOAPAction", "");
        requestHeaders.add("Content-type", "text/xml;charset=UTF-8");

        //HttpEntity
        HttpEntity<String> requestEntity = new HttpEntity<String>(reqBody, requestHeaders);
        //post
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://ws.xn--7hvv57c8im.com:8401/lgtbws/eship/orderShip", requestEntity, String.class);
        System.out.println(responseEntity.getBody());
    }

    public static void main(String[] args) {
        getUserPriceList();
//        order();
//        System.out.println(restTemplate.getMessageConverters());
    }

}
