package ToDoApplication.model;

import jakarta.persistence.*;

//import java.util.Date;

@Entity
@Table(name = "Tasks",schema = "szl")
public class Task {

    @Column(name = "id_task")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(name = "title")
    protected String title;

    @Column(name = "description")
    protected String description;

    @Column(name = "status")
    protected String status;

    @Column(name = "due_date")
    protected String duedate;

    @Column(name = "updated_date")
    protected String updateddate;

    @ManyToOne
    @JoinColumn(name = "id_user")
    protected User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

      public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDuedate() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate = duedate;
    }

    public String getUpdateddate() {
        return updateddate;
    }

    public void setUpdated_date(String updateddate) {
        this.updateddate = updateddate;
    }
}
