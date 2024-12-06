package app.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ClaimEvent implements Serializable{
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Min(1000)
    @Max(9999)
    @Column(name = "claimID")
    private int claimID;

    @NotNull
    @OneToOne
    @JoinColumn(name = "itemID", referencedColumnName = "itemID", nullable = false)
    private Item item;

    @NotNull
    @Column
    private String claimReport;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column
    private LocalDateTime claimDate;

    @NotNull
    @Column
    private String claimantName;

    @NotNull
    @Column
    private String claimantContact;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getClaimID() {
		return claimID;
	}

	public void setClaimID(int claimID) {
		this.claimID = claimID;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
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
