package app.entities;

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
public class FoundReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Min(10000)
    @Max(99999)
    @Column(name = "foundID", unique = true)
    private int foundID;

    @NotNull
    @OneToOne
    @JoinColumn(name = "claimID", referencedColumnName = "claimID", nullable = false)
    private ClaimEvent claimEvent;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column
    private LocalDateTime foundDate;

    @NotNull
    @OneToOne
    @JoinColumn(name = "LocationID", referencedColumnName = "LocationID", nullable = false)
    private Location location;

    @NotNull
    @Column
    private String foundDetails;

    @NotNull
    @OneToOne
    @JoinColumn(name = "IDNumber", referencedColumnName = "IDNumber", nullable = false)
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getFoundID() {
		return foundID;
	}

	public void setFoundID(int foundID) {
		this.foundID = foundID;
	}

	public ClaimEvent getClaimEvent() {
		return claimEvent;
	}

	public void setClaimEvent(ClaimEvent claimEvent) {
		this.claimEvent = claimEvent;
	}

	public LocalDateTime getFoundDate() {
		return foundDate;
	}

	public void setFoundDate(LocalDateTime foundDate) {
		this.foundDate = foundDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getFoundDetails() {
		return foundDetails;
	}

	public void setFoundDetails(String foundDetails) {
		this.foundDetails = foundDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    
}
