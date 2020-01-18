package fr.ajaate.dora.model;

public class Struct {
    private int idStruct;
    private String name;
    private Level level;
    private String country;
    private String city;
    private String postal_code;
    private String street;
    private String buildingNumber;
    private int idStructParent;
    private int idResponsible;


    public Struct(int idStruct, String name, Level level, String country, String city, String postal_code, String street, String buildingNumber, Integer idStructParent, int idResponsible) {
        this.idStruct = idStruct;
        this.name = name;
        this.level = level;
        this.country = country;
        this.city = city;
        this.postal_code = postal_code;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.idStructParent = idStructParent;
        this.idResponsible = idResponsible;
    }

    public int getIdStruct() {
        return idStruct;
    }

    public void setIdStruct(int idStruct) {
        this.idStruct = idStruct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getIdStructParent() {
        return idStructParent;
    }

    public void setIdStructParent(int idStructParent) {
        this.idStructParent = idStructParent;
    }

    public int getIdResponsible() {
        return idResponsible;
    }

    public void setIdResponsible(int idResponsible) {
        this.idResponsible = idResponsible;
    }
}




