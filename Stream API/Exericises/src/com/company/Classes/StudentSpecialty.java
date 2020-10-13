package com.company.Classes;

public class StudentSpecialty {
    private String specialtyName;
    private String facultyNumber;

    public StudentSpecialty(String specialtyName, String facultyNumber) {
        this.specialtyName = specialtyName;
        this.facultyNumber = facultyNumber;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public String getFacultyNumber() {
        return facultyNumber;
    }

    public void setFacultyNumber(String facultyNumber) {
        this.facultyNumber = facultyNumber;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        StudentSpecialty specialty = (StudentSpecialty) other;

        return facultyNumber != null ? facultyNumber.equals(specialty.facultyNumber) : specialty.facultyNumber == null;
    }

    @Override
    public int hashCode() {
        int result = 31 * +(facultyNumber != null ? facultyNumber.hashCode() : 0);
        return result;
    }
}
