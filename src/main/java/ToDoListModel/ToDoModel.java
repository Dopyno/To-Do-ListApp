package ToDoListModel;

import java.io.Serializable;
import java.time.LocalDate;

public class ToDoModel implements Serializable {
    private String shortDescription;
    private String detail;
    private LocalDate date;

    public ToDoModel(String shortDescription, String detail, LocalDate date) {
        this.shortDescription = shortDescription;
        this.detail = detail;
        this.date = date;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return shortDescription;
    }
}
