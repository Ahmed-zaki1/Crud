package bean;

import java.time.LocalDateTime;
import java.sql.Date;

public class Message_Template {
    private String template_id="1";
    private Date created_date;
    private Boolean is_active=true;
    private LocalDateTime last_updated_date;
    private String message;
    private String name;
    private String user_id;
    private Boolean is_templated=false;

    public Message_Template() {
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public LocalDateTime getLast_updated_date() {
        return last_updated_date;
    }

    public void setLast_updated_date(LocalDateTime last_updated_date) {
        this.last_updated_date = last_updated_date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Boolean getIs_templated() {
        return is_templated;
    }

    public Message_Template(String template_id, Date created_date, Boolean is_active, LocalDateTime last_updated_date, String message, String name, String user_id, Boolean is_templated) {
        this.template_id = template_id;
        this.created_date = created_date;
        this.is_active = is_active;
        this.last_updated_date = last_updated_date;
        this.message = message;
        this.name = name;
        this.user_id = user_id;
        this.is_templated = is_templated;
    }
}
