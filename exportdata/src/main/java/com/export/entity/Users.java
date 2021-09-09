package com.export.entity;

import java.sql.Timestamp;

public class Users {
	private long id;
	private String transaction_id;
	private String parent_transaction_id;
	private String transaction_type;
	private long transaction_amount;
	private String transaction_currency;
	private String poi_id;
	private String poi_type;
	private String poi_sub_type;
	private String transaction_method;
	private Timestamp create_time;
	private Timestamp update_time;
	private String merchant_payment_gw_id;
	private String exchange_id;
	private String message_function;
	private String activity_name;
	private String activity_status;
	private String additional_info;
	private String transaction_amount_txt;
	private String process_id;

	public Users(int id, String transaction_id, String parent_transaction_id, String transaction_type,
			long transaction_amount, String transaction_currency, String poi_id, String poi_type, String poi_sub_type,
			String transaction_method, Timestamp create_time, Timestamp update_time, String merchant_payment_gw_id,
			String exchange_id, String message_function, String activity_name, String activity_status,
			String additional_info, String transaction_amount_txt, String process_id) {
		super();
		this.id = id;
		this.transaction_id = transaction_id;
		this.parent_transaction_id = parent_transaction_id;
		this.transaction_type = transaction_type;
		this.transaction_amount = transaction_amount;
		this.transaction_currency = transaction_currency;
		this.poi_id = poi_id;
		this.poi_type = poi_type;
		this.poi_sub_type = poi_sub_type;
		this.transaction_method = transaction_method;
		this.create_time = create_time;
		this.update_time = update_time;
		this.merchant_payment_gw_id = merchant_payment_gw_id;
		this.exchange_id = exchange_id;
		this.message_function = message_function;
		this.activity_name = activity_name;
		this.activity_status = activity_status;
		this.additional_info = additional_info;
		this.transaction_amount_txt = transaction_amount_txt;
		this.process_id = process_id;
	}

	public Users() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getParent_transaction_id() {
		return parent_transaction_id;
	}

	public void setParent_transaction_id(String parent_transaction_id) {
		this.parent_transaction_id = parent_transaction_id;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public long getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(long transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getTransaction_currency() {
		return transaction_currency;
	}

	public void setTransaction_currency(String transaction_currency) {
		this.transaction_currency = transaction_currency;
	}

	public String getPoi_id() {
		return poi_id;
	}

	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}

	public String getPoi_type() {
		return poi_type;
	}

	public void setPoi_type(String poi_type) {
		this.poi_type = poi_type;
	}

	public String getPoi_sub_type() {
		return poi_sub_type;
	}

	public void setPoi_sub_type(String poi_sub_type) {
		this.poi_sub_type = poi_sub_type;
	}

	public String getTransaction_method() {
		return transaction_method;
	}

	public void setTransaction_method(String transaction_method) {
		this.transaction_method = transaction_method;
	}

	public Timestamp getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}

	public Timestamp getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Timestamp update_time) {
		this.update_time = update_time;
	}

	public String getMerchant_payment_gw_id() {
		return merchant_payment_gw_id;
	}

	public void setMerchant_payment_gw_id(String merchant_payment_gw_id) {
		this.merchant_payment_gw_id = merchant_payment_gw_id;
	}

	public String getExchange_id() {
		return exchange_id;
	}

	public void setExchange_id(String exchange_id) {
		this.exchange_id = exchange_id;
	}

	public String getMessage_function() {
		return message_function;
	}

	public void setMessage_function(String message_function) {
		this.message_function = message_function;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public String getActivity_status() {
		return activity_status;
	}

	public void setActivity_status(String activity_status) {
		this.activity_status = activity_status;
	}

	public String getAdditional_info() {
		return additional_info;
	}

	public void setAdditional_info(String additional_info) {
		this.additional_info = additional_info;
	}

	public String getTransaction_amount_txt() {
		return transaction_amount_txt;
	}

	public void setTransaction_amount_txt(String transaction_amount_txt) {
		this.transaction_amount_txt = transaction_amount_txt;
	}

	public String getProcess_id() {
		return process_id;
	}

	public void setProcess_id(String process_id) {
		this.process_id = process_id;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", transaction_id=" + transaction_id + ", parent_transaction_id="
				+ parent_transaction_id + ", transaction_type=" + transaction_type + ", transaction_amount="
				+ transaction_amount + ", transaction_currency=" + transaction_currency + ", poi_id=" + poi_id
				+ ", poi_type=" + poi_type + ", poi_sub_type=" + poi_sub_type + ", transaction_method="
				+ transaction_method + ", create_time=" + create_time + ", update_time=" + update_time
				+ ", merchant_payment_gw_id=" + merchant_payment_gw_id + ", exchange_id=" + exchange_id
				+ ", message_function=" + message_function + ", activity_name=" + activity_name + ", activity_status="
				+ activity_status + ", additional_info=" + additional_info + ", transaction_amount_txt="
				+ transaction_amount_txt + ", process_id=" + process_id + "]";
	}

}