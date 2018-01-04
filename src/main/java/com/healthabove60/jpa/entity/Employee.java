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
@Table(name="employee")
@Data
@NamedQueries({
	@NamedQuery(name="findByEmail",
			query="select e from Employee e where e.email=?1 and e.isActive=?2 and e.isDeleted=?3")
})
public class Employee{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;

	@OneToOne
	@NotEmpty(message="Please provide your emp id")
	@JoinColumn(name="emp_id",unique=true)
	private User user;

	@Column(name="first_name")
	@NotEmpty(message="Please provide your first name")
	private String firstName;

	@Column(name="last_name")
	@NotEmpty(message="Please provide your last name")
	private String lastName;

	@Column(name="email",unique=true)
	@Email(message="Please provide a valid email")
	@NotEmpty(message="Please provide a email")
	private String email;

	@Column(name="mobile",unique=true)
	@Length(min=10, message="Mobile number should be minimum 10 numbers")
	private String mobile;

	@Column(name="alt_mobile")
	@Length(min=10, message="Mobile number should be minimum 10 numbers")
	private String altMobile;

	@Column(name="designation")
	@NotEmpty(message="Please provide the designation")
	private String designation;

	@Column(name="emp_type")
	@NotEmpty(message="Please provide the employment type")
	private String empType;

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