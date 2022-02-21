package com.seasy.ui.pages;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

/*@Builder
@Getter*/
public class User {
	// @NonNull
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String projectDescription;
	private String webSite;
	
	public static class Builder {
		
		private final User user;
		
		public Builder() {
			user = new User();
		}
		
		public Builder withFirstName(String firstName) {
			user.firstName = firstName;
			return this;
		}
		
		public Builder withLastName(String lastName) {
			user.lastName = lastName;
			return this;
		}
		
		public Builder withEmail(String email) {
			user.email = email;
			return this;
		}
		
		public Builder withPhone(String phone) {
			user.phone = phone;
			return this;
		}
		
		public Builder withAddress(String address) {
			user.address = address;
			return this;
		}
		
		public Builder withCity(String city) {
			user.city = city;
			return this;
		}
		
		public Builder withZipCode(String zipCode) {
			user.zipCode = zipCode;
			return this;
		}
		
		public Builder withWebSite(String webSite) {
			user.webSite = webSite;
			return this;
		}
		
		public Builder withProjectDescription(String description) {
			user.projectDescription = description;
			return this;
		}
		
		public User build() {
			return user;
		}
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getProjectDescription() {
		return projectDescription;
	}
	
	public String getWebSite() {
		return webSite;
	}
}
