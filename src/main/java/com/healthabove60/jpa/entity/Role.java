package com.healthabove60.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="role")
@Data
@NamedQueries({
	@NamedQuery(name="Role.findByRole",
			query="select r from Role r where r.role=?1 and r.isActive=?2 and r.isDeleted=?3")
})
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="role_id")
	private Integer id;

	@Column(name="role")
	private String role;

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