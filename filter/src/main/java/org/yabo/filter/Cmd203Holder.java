package org.yabo.filter;

import com.alibaba.fastjson.JSON;

import java.util.List;

//203指令,用于下发bot消息
public class Cmd203Holder {

    //mix_reply条目
    private static class Item {
        private String label;//问题
        private String score;
        private String style;
        private String type;
        private String target;
        private String params;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getStyle() {
            return style;
        }

        public void setStyle(String style) {
            this.style = style;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getParams() {
            return params;
        }

        public void setParams(String params) {
            this.params = params;
        }
    }

    //mix_reply回复
    private static class MixReply {
        private String id;//mix_reply
        private String label;
        private Float version;
        private List<Item> list;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Float getVersion() {
            return version;
        }

        public void setVersion(Float version) {
            this.version = version;
        }

        public List<Item> getList() {
            return list;
        }

        public void setList(List<Item> list) {
            this.list = list;
        }
    }

    //203指令,用于下发bot消息
    private  class Cmd203 {
        private Integer cmd;
        private MixReply template;
        private String type;

        public Integer getCmd() {
            return cmd;
        }

        public void setCmd(Integer cmd) {
            this.cmd = cmd;
        }

        public MixReply getTemplate() {
            return template;
        }

        public void setTemplate(MixReply template) {
            this.template = template;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

    }

    Cmd203 parse(String s) {
        return JSON.parseObject(s, Cmd203.class);
    }

}
