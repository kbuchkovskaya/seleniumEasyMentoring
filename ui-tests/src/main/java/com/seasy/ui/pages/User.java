package com.seasy.ui.pages;

public class User {

    public String firstName;
    public String lastName;
    public String email;
    public String phone;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String projectDescription;
    public String webSite;

    public static class Builder {

        private User user;

        public Builder() {
            user = new User();
        }

        public Builder withFirstName(String firstName){
            user.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName){
            user.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email){
            user.email = email;
            return this;
        }

        public Builder withPhone(String phone){
            user.phone = phone;
            return this;
        }

        public Builder withAddress(String address){
            user.address = address;
            return this;
        }

        public Builder withCity(String city){
            user.city = city;
            return this;
        }

        public Builder withZipCode(String zipCode){
            user.zipCode = zipCode;
            return this;
        }

        public Builder withWebSite(String webSite){
            user.webSite = webSite;
            return this;
        }

        public Builder withProjectDescription(String description){
            user.projectDescription = description;
            return this;
        }

        public User build(){
            return user;
        }

    }
}
