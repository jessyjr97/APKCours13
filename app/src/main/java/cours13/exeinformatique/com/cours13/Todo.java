package cours13.exeinformatique.com.cours13;

import java.util.Date;

public class Todo {
    Date dateAdded;
    String title;
    String description;

    public Todo(Date dateAdded, String title, String description) {
        this.dateAdded = dateAdded;
        this.title = title;
        this.description = description;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
