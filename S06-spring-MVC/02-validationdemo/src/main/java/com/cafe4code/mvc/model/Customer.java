package com.cafe4code.mvc.model;
import com.cafe4code.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {

    // ================================Variables================================
    private String firstName;

    @NotNull(message = "is required !")
    @Size(min = 3, message = "must more than 3")
    private String lastName;

    @NotNull(message = "is required !")
    @Min(value = 0, message = "0 in MINIMUM")
    @Max(value = 10, message = "10 is MAXIMUM")
    private Integer freePasses;

    @Pattern(regexp = "[a-zA-Z0-9]{5}", message = "only 5 chars/digits")
    private String postalCode;

    @CourseCode
    private String courseCode;

    // ================================Getters & Setters================================
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
