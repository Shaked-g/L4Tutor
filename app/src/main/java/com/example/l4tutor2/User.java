package com.example.l4tutor2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    public enum Courses {
        Linear_Algebra1, Linear_Algebra2, Number_Theory, Infinitesimal_Calculus1,Infinitesimal_Calculus2,
        Discrete_Mathematics, Logic_and_set_theory, Java, Data_Structures,Object_Oriented,
    }

    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String PhoneNumber;
    private String UserType;  // "student" or "tutor"
    private String Password;
    boolean MeetingTypePreference; // zoom or frontal

    private int DesiredPayment;
    private List<Courses> DesiredCourses = new ArrayList<>();






    Courses newCourse = Courses.Linear_Algebra1; // example


    // Constructor //
    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }


    public User(String emailString, String password, String name, String familyName) {
        this.EmailAddress = emailString;
        this.Password = password;
        this.FirstName = name;
        this.LastName = familyName;
    }

    public User(User tutor,String phoneNumber,int price){
        this.FirstName = tutor.getFirstName();
        this.LastName = tutor.getLastName();
        this.EmailAddress = tutor.getEmailAddress();
        this.Password = tutor.getPassword();
        this.PhoneNumber = phoneNumber;
        this.DesiredPayment = price;
    }

    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    private boolean CreateTutor(){
        return true;
    }


    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }


    public int getDesiredPayment() {
        return DesiredPayment;
    }

    public void setDesiredPayment(int payment) {
        DesiredPayment = payment;
    }


    public boolean isMeetingTypePreference() {
        return MeetingTypePreference;
    }

    public void setMeetingTypePreference(boolean preference) {
        MeetingTypePreference = preference;
    }


    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }


    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }


    public String getLastName() { return LastName; }

    public void setLastName(String lastName) {
        LastName = lastName;
    }


    public List getDesiredCourses() {
        return this.DesiredCourses;
    }

    public void setDesiredCourses(Courses desiredCourses) {
        this.DesiredCourses.add(desiredCourses);
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}