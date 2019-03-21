package org.yabo.spring.test.worksheet;

public enum WorksheetState {
    UNDISPOSED(1, "未处理"),
    PROCESSING(2, "处理中"),
    REJECT(3, "已驳回"),
    REOPEN(4, "重新发起"),
    FINISHED(10, "已完结");

    private int state;
    private String name;

    WorksheetState(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
