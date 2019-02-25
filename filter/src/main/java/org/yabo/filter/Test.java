package org.yabo.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Test {


    public static void main(String[] args) {
        String s = "{\"template\":{\"id\":\"mix_reply\",\"label\":\"asdasd?\\noc\",\"list\":[{\"score\":\"0.6946001\",\"style\":\"button\",\"label\":\"c主问题7-子问题2\",\"type\":\"faq\",\"params\":\"_preRequestId=5e02a8bb-a65f-447c-a28f-8935233944d7&_sessionId=14510673&_preNodeId=_preNodeId&_token=f361b8e69b3fcb2511abe0fa15027371&_flowId=_flowId\",\"target\":\"3035033\"},{\"score\":\"0.671783\",\"style\":\"button\",\"label\":\"主问题\",\"type\":\"faq\",\"params\":\"_preRequestId=5e02a8bb-a65f-447c-a28f-8935233944d7&_sessionId=14510673&_preNodeId=_preNodeId&_token=f361b8e69b3fcb2511abe0fa15027371&_flowId=_flowId\",\"target\":\"3035039\"},{\"score\":\"0.5764133\",\"style\":\"button\",\"label\":\"c主问题7\",\"type\":\"faq\",\"params\":\"_preRequestId=5e02a8bb-a65f-447c-a28f-8935233944d7&_sessionId=14510673&_preNodeId=_preNodeId&_token=f361b8e69b3fcb2511abe0fa15027371&_flowId=_flowId\",\"target\":\"3035047\"}],\"version\":\"0.1\"},\"cmd\":203,\"type\":\"11\",\"extendInfo\":{\"nodeId\":\"mix_sort\",\"preRequestId\":\"5e02a8bb-a65f-447c-a28f-8935233944d7\",\"requestId\":\"5e02a8bb-a65f-447c-a28f-8935233944d7\",\"showUseful\":true}}";
        Cmd203Holder holder=new Cmd203Holder();
        holder.parse(s);

    }
}
