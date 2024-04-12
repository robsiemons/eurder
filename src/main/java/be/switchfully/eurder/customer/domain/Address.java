package be.switchfully.eurder.customer.domain;

public class Address {
    private String country;
    private String city;
    private String streetName;
    private int houseNumber;
    private int postalCode;

    public Address(String country, String city, int postalCode, String streetName, int houseNumber) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }
    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }


    @Override
    public String toString() {
        return "Address{ " + streetName + " " + houseNumber + ", " + postalCode + " " + city + ", " + country + " }";
    }
}
