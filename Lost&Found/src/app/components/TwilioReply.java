package app.components;

public class TwilioReply {
	
	public String sid;
	private String status;
	private String message;
	
	
	public TwilioReply() {}
	
	public TwilioReply(String sid, String status, String message) {
		this.sid = sid;
        this.status = status;
        this.message = message;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "TwilioReply [sid=" + sid + ", status=" + status + ", message=" + message + "]";
	}
	
	

}
