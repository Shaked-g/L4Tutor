package com.example.l4tutor2;

public class User {

    private String FirstName;
    private String LastName;
    private String EmailAddress;
    private String PhoneNumber;
    private String UserType;  // "student" or "teacher"
    boolean MeetingTypePreference; // zoom or frontal



    private int DesiredPayment;
    private Courses DesiredCourses;


    public enum Courses {
        Linear_Algebra1, Linear_Algebra2, Number_Theory, Infinitesimal_Calculus,
        Discrete_Mathematics, Logic_and_set_theory, Java, Data_Structures
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


    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Courses getDesiredCourses() {
        return DesiredCourses;
    }

    public void setDesiredCourses(Courses desiredCourses) {
        DesiredCourses = desiredCourses;
    }

}
