package com.safetynet.safetynetalerts.DTOs;

import java.util.List;

public class PersonDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
    private MedicalRecordDTO medicalRecord;
    private List<FireStationDTO> fireStations;

    public PersonDTO() {
    }

    public PersonDTO(String firstName, String lastName, String address,
                     String city, String zip, String phone, String email,
                     MedicalRecordDTO medicalRecords, List<FireStationDTO> fireStations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.medicalRecord = medicalRecords;
        this.fireStations = fireStations;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MedicalRecordDTO getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecordDTO medicalRecords) {
        this.medicalRecord = medicalRecords;
    }

    public List<FireStationDTO> getFireStations() {
        return fireStations;
    }

    public void setFireStations(List<FireStationDTO> fireStations) {
        this.fireStations = fireStations;
    }
}
