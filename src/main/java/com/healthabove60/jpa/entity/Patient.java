package com.healthabove60.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name="patient")
@Data
public class Patient{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	@OneToOne
	@NotEmpty(message="Please provide your patient id")
	@JoinColumn(name="patient_id",unique=true)
	private User user;

	@Column(name="first_name")
	@NotEmpty(message="Please provide your first name")
	private String firstName;

	@Column(name="last_name")
	@NotEmpty(message="Please provide your last name")
	private String lastName;

	@Column(name="email")
	@Email(message="Please provide a valid email")
	@NotEmpty(message="Please provide a email")
	private String email;

	@Column(name="mobile")
	@Length(min=10, message="Mobile number should be minimum 10 numbers")
	private String mobile;

	@Column(name="is_active")
	private Boolean isActive;

	@Column(name="is_deleted")
	private Boolean isDeleted;

	@Column(name="created_on")
	private String createdOn;

	@Column(name="created_by")
	private String createdBy;
	
	@Column(name="modified_on")
	private String modifiedOn;

	@Column(name="modified_by")
	private String modifiedBy;

}