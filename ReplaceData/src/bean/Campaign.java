package bean;

import java.time.LocalDateTime;

public class Campaign {
    private  String campaign_id;
    private  String channel_id;
    private LocalDateTime completed_date;
    private LocalDateTime created_date;
    private LocalDateTime last_updated_date;
    private String list_id;
    private String message_id;
    private String name;
    private  LocalDateTime published_date;
    private int published_list_size;
    private String sender;
    private String status;
    private String user_id;
    private String template_id;

    public String getCampaign_id() {
        return campaign_id;
    }

    public void setCampaign_id(String campaign_id) {
        this.campaign_id = campaign_id;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public LocalDateTime getCompleted_date() {
        return completed_date;
    }

    public void setCompleted_date(LocalDateTime completed_date) {
        this.completed_date = completed_date;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    public LocalDateTime getLast_updated_date() {
        return last_updated_date;
    }

    public void setLast_updated_date(LocalDateTime last_updated_date) {
        this.last_updated_date = last_updated_date;
    }

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getPublished_date() {
        return published_date;
    }

    public void setPublished_date(LocalDateTime published_date) {
        this.published_date = published_date;
    }

    public int getPublished_list_size() {
        return published_list_size;
    }

    public void setPublished_list_size(int published_list_size) {
        this.published_list_size = published_list_size;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public Campaign() {
    }

    public Campaign(String campaign_id, String channel_id, LocalDateTime completed_date, LocalDateTime created_date, LocalDateTime last_updated_date, String list_id, String message_id, String name, LocalDateTime published_date, int published_list_size, String sender, String status, String user_id, String template_id) {
        this.campaign_id = campaign_id;
        this.channel_id = channel_id;
        this.completed_date = completed_date;
        this.created_date = created_date;
        this.last_updated_date = last_updated_date;
        this.list_id = list_id;
        this.message_id = message_id;
        this.name = name;
        this.published_date = published_date;
        this.published_list_size = published_list_size;
        this.sender = sender;
        this.status = status;
        this.user_id = user_id;
        this.template_id = template_id;
    }
}
