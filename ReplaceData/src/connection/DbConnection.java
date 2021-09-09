package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Campaign;
import bean.Message;
import bean.Message_Template;

public class DbConnection {
	Campaign campaign = new Campaign();
	Message_Template template = new Message_Template();
	Message message = new Message();

	public void getCampaign(String message_id) {
		try (Connection conn = util.ConnectionUtils.getConnection()) {
			PreparedStatement st = conn.prepareStatement("select * from campaign where message_id=?");
			st.setString(1, message_id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				campaign.setCampaign_id(rs.getString(1));
				campaign.setChannel_id(rs.getString(2));
				campaign.setList_id(rs.getString(6));
				campaign.setMessage_id(rs.getString(7));
				campaign.setName(rs.getString(8));
				campaign.setPublished_list_size(rs.getInt(10));
				campaign.setSender(rs.getString(11));
				campaign.setStatus(rs.getString(12));
				campaign.setUser_id(rs.getString(13));
				campaign.setTemplate_id(rs.getString(14));
				System.out.println("successfully read");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getMessage(String message_id) {
		try {
			Connection conn = util.ConnectionUtils.getConnection();
			PreparedStatement st = conn.prepareStatement("select * from message where message_id=?");
			st.setString(1, message_id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				message.setMessage_id(rs.getString(1));
				message.setMessage(rs.getString(2));
				System.out.println(message.getMessage_id() + "" + campaign.getMessage_id());
				if (message.getMessage_id() == campaign.getMessage_id()) {
					template.setMessage(message.getMessage());
					System.out.println(template.getMessage());
				}
				System.out.println("successfully read");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTemplate() {
		Connection conn = util.ConnectionUtils.getConnection();
		try {
			PreparedStatement st = conn.prepareStatement(
					"insert into message_template(template_id,is_Active,message,name,user_id,is_templated) values(?,?,?,?,?,?)");
			st.setString(1, template.getTemplate_id());
			st.setBoolean(2, template.getIs_active());
			st.setString(3, message.getMessage());
			st.setString(4, campaign.getName());
			st.setString(5, campaign.getUser_id());
			st.setBoolean(6, template.getIs_templated());
			int status = st.executeUpdate();
			System.out.println(status);
			System.out.println("successfully insert");
			template.setUser_id(campaign.getUser_id());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		System.out.println(template.getUser_id() + "" + campaign.getUser_id());
		if (template.getUser_id() == campaign.getUser_id()) {

			Connection conn = util.ConnectionUtils.getConnection();
			try {
				PreparedStatement st = conn.prepareStatement("update campaign set template_id=? where user_id=?");
				st.setString(1, template.getTemplate_id());
				st.setString(2, template.getUser_id());
				int status = st.executeUpdate();
				System.out.println(status);
				System.out.println("successfully updated templateId" + template.getTemplate_id());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {

		DbConnection connection = new DbConnection();
		connection.getCampaign("1");
		connection.getMessage("1");
		connection.createTemplate();
		connection.update();
	}
}
