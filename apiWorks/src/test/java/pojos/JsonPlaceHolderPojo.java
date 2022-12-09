package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

// Farkli key-value ikililerinin uyusmazligini
// @JsonIgnoreProperties(ignoreUnknown = true) annotation'ini Pojo Class'imizin basima yazarak cozebiliriz

public class JsonPlaceHolderPojo {

    private int userId;
    private String title;
    private boolean completed;

    public JsonPlaceHolderPojo() {
    }

    public JsonPlaceHolderPojo(int userId, String title, boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

}
