package lab_3;

import java.util.Date;

public class Dossier {
    private String firstName;
    private String surName;
    private Date birthDate;
    private Date dateOfImprisonment;
    private Date dateOfRelease;
    private int id;

    public Dossier() {
    }

    public Dossier(String firstName, String surName, Date birthDate, Date dateOfImprisonment, Date dateOfRelease) {
        this.firstName = firstName;
        this.surName = surName;
        this.birthDate = birthDate;
        this.dateOfImprisonment = dateOfImprisonment;
        this.dateOfRelease = dateOfRelease;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDateOfImprisonment() {
        return dateOfImprisonment;
    }

    public void setDateOfImprisonment(Date dateOfImprisonment) {
        this.dateOfImprisonment = dateOfImprisonment;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Dossier{" +
                "firstName='" + firstName + '\'' +
                ", surName='" + surName + '\'' +
                ", birthDate=" + birthDate +
                ", dateOfImprisonment=" + dateOfImprisonment +
                ", dateOfRelease=" + dateOfRelease +
                '}';
    }


}
