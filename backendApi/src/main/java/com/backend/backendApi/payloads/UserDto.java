package com.backend.backendApi.payloads;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	

	private int id;
	@NotEmpty
	@Size(min = 4,message = "User name must be min of 4 Character")
	private String name;
	@Email(message="Email address no valid")
	private String email;
	@NotEmpty
	@Size(min = 3, max = 10, message="Password must be min 3 and max 3")
	private String password;
	@NotEmpty
	private String about;
	
	
	

}
