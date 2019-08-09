package com.adidas.challenge.datasubs.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Timestamp;    

@Data
@Entity
@ApiModel
@Table(name = "subscription")
public class Subs {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ApiModelProperty(value = "Email address")
    @Column(name = "email")
    private String email;
    
    @ApiModelProperty(value = "First name")
    @Column(name = "firstName")
    private String first_name;
    
    @ApiModelProperty(value = "Gender")
    @Column(name = "gender")
    private String gender;
    
    @ApiModelProperty(value = "Date of birthday")
    @Temporal(TemporalType.DATE)
    private Date date_of_bith;
    
    @ApiModelProperty(value = "Consent")
    @Column(name = "consent")
    private Boolean consent;
    
    @ApiModelProperty(value = "Newsletter Id corresponding to the campaign")
    @Column(name = "idNewsletter")
    private Integer id_newsletter;
	
	
	public Subs() {
    }
 
    public Subs(String email, String firstName, String gender, String dateOfBith, String consent, String idNewsletter) throws Exception {
        this.email = email;
        this.first_name = firstName;
        this.gender = gender;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        this.date_of_bith = formatter.parse(dateOfBith);
        this.consent = Boolean.valueOf(consent);
        this.id_newsletter = Integer.parseInt(idNewsletter);
    }
}