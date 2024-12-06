package app.dto;

import java.time.LocalDateTime;

public class FoundReportDTO {
    private int foundID;
    private int claimID;
    private LocalDateTime foundDate;
    private int locationID;
    private String foundDetails;
    private int idNumber;
	public int getFoundID() {
		return foundID;
	}
	public void setFoundID(int foundID) {
		this.foundID = foundID;
	}
	public int getClaimID() {
		return claimID;
	}
	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}
	public LocalDateTime getFoundDate() {
		return foundDate;
	}
	public void setFoundDate(LocalDateTime foundDate) {
		this.foundDate = foundDate;
	}
	public int getLocationID() {
		return locationID;
	}
	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}
	public String getFoundDetails() {
		return foundDetails;
	}
	public void setFoundDetails(String foundDetails) {
		this.foundDetails = foundDetails;
	}
	public int getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}
    
    
}
