package app.dto;

public class LoginRequestDTO {
	private int idNumber;
    private String password;
    public int getIdNumber() {  // Changed getter
        return idNumber;
    }
    
    public void setIdNumber(int idNumber) {  // Changed setter
        this.idNumber = idNumber;
    }
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
    
    // Getters and setters

}
