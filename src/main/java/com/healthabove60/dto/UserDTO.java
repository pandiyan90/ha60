package com.healthabove60.dto;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class UserDTO {
	
	private String name;

	private String email;

	private String password;

}