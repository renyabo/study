package org.yabo.spring.test.worksheet;

public class Worksheet {

    private WorksheetState worksheetState;
    private Long id;
    private Long targetId;
    private Long targetType;
    private Long handlerId;
    private String content;

    public WorksheetState getWorksheetState() {
        return worksheetState;
    }

    public void setWorksheetState(WorksheetState worksheetState) {
        this.worksheetState = worksheetState;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTargetId() {
        return targetId;
    }

    public void setTargetId(Long targetId) {
        this.targetId = targetId;
    }

    public Long getTargetType() {
        return targetType;
    }

    public void setTargetType(Long targetType) {
        this.targetType = targetType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
