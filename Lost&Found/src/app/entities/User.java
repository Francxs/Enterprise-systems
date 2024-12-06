package app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotNull
    @Min(100000)
    @Max(999999)
    @Column(name = "IDNumber", unique = true)
    private int idNumber;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Email
    @Pattern(regexp = "^[a-zA-Z]+(\\.[a-zA-Z]+)?@student\\.ateneo\\.edu$|^[a-zA-Z]\\w*\\.ateneo\\.edu$\r\n")
    @Column
    private String email;

    @NotNull
    @Column
    private String password;

    @NotNull
    @Pattern(regexp = "09\\d{9}")
    @Column
    private String phoneNumber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getIDNumber() {
		return idNumber;
	}

	public void setIDNumber(int iDNumber) {
		this.idNumber = iDNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    // Getters and Setters
    
    
}
