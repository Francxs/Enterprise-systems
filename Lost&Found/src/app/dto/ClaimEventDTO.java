package app.dto;

import java.time.LocalDateTime;

public class ClaimEventDTO {
    private int claimID;
    private int itemID;
    private String claimReport;
    private LocalDateTime claimDate;
    private String claimantName;
    private String claimantContact;
	public int getClaimID() {
		return claimID;
	}
	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}
	public int getItemID() {
		return itemID;
	}
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	public String getClaimReport() {
		return claimReport;
	}
	public void setClaimReport(String claimReport) {
		this.claimReport = claimReport;
	}
	public LocalDateTime getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(LocalDateTime claimDate) {
		this.claimDate = claimDate;
	}
	public String getClaimantName() {
		return claimantName;
	}
	public void setClaimantName(String claimantName) {
		this.claimantName = claimantName;
	}
	public String getClaimantContact() {
		return claimantContact;
	}
	public void setClaimantContact(String claimantContact) {
		this.claimantContact = claimantContact;
	}

    // Getters and Setters
    
    
}
