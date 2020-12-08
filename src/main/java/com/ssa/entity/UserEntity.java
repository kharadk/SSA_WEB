package com.ssa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "ssa_user_data")
public class UserEntity {
	@GenericGenerator(name = "ssn_no_generator", strategy = "com.ssa.generator.SSNNoIdGenerator")
	@GeneratedValue(generator = "ssn_no_generator")
	@Id
	@Column(name = "ssn_no")
	protected Long ssnNo;
	@Column(name = "first_name")
	protected String firstName;
	@Column(name = "last_name")
	protected String lastName;
	protected String gender;
	protected String dob;
	@Column(name = "state_name")
	protected String stateName;
	/*
	 * @Lob protected byte[] photo;
	 */
}
