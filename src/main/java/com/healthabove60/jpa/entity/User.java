package com.healthabove60.jpa.entity;

import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Entity
@Table(name="user")
@Data
@NamedQueries({
	@NamedQuery(
			name="User.findByUserId", 
			query="select u from User u where u.userId=?1")
})
public class User {

	@Id
	@NotEmpty(message="Please provide your user name")
	@Column(name="user_id")
	private String userId;

	@Column(name="password")
	@Length(min=8, message="Password should be minimum of 8 characters")
	@NotEmpty(message="Please provide your password")
	private String password;

	@Column
	private String name;

	@Column
	private String who;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="user_roles", joinColumns=@JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set<Role> roles;

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