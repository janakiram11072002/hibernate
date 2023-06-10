package hibernate.learning.MapFile;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import java.util.Collection;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

// import jakarta.persistence.AttributeOverride;
// import jakarta.persistence.AttributeOverrides;
// import jakarta.persistence.Column;
// import jakarta.persistence.ElementCollection;
// import jakarta.persistence.Embedded;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;

@Entity(name = "user_details")
public class UserDetails {
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ElementCollection
    @JoinTable(name = "USER_ADDRESS",joinColumns = @JoinColumn(name="USER_ID"))
    //@GenericGenerator(name="hilo-gen",strategy = "hilo") // since it has been removed
    @GenericGenerator(name = "sequence_gen", strategy = "sequence")
    @CollectionId(columns ={@Column(name="ADDRESS_ID")}, generator = "sequence_gen", type = @Type(type = "long"))
    private Collection<Address> listOfAddresses = new ArrayList<Address>();

    // @Embedded
    // @AttributeOverrides(
    //     {
    //         @AttributeOverride(name="street",column =@Column(name="HOME_STREET_NAME")),
    //         @AttributeOverride(name="city",column =@Column(name="HOME_CITY_NAME")),
    //         @AttributeOverride(name="state",column =@Column(name="HOME_STATE_NAME")),
    //         @AttributeOverride(name="pincode",column =@Column(name="HOME_PINCODE")),
    //     }
    // )
    // private Address HomeAddress;

    // @Embedded
    // @AttributeOverrides(
    //     {
    //         @AttributeOverride(name="street",column =@Column(name="OFFICE_STREET_NAME")),
    //         @AttributeOverride(name="city",column =@Column(name="OFFICE_CITY_NAME")),
    //         @AttributeOverride(name="state",column =@Column(name="OFFICE_STATE_NAME")),
    //         @AttributeOverride(name="pincode",column =@Column(name="OFFICE_PINCODE")),
    //     }
    // )
    // private Address OfficeAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }

    // public Set<Address> getListOfAddresses() {
    //     return listOfAddresses;
    // }

    // public void setListOfAddresses(Set<Address> listOfAddresses) {
    //     this.listOfAddresses = listOfAddresses;
    // }

    // public Address getHomeAddress() {
    //     return HomeAddress;
    // }

    // public void setHomeAddress(Address homeAddress) {
    //     HomeAddress = homeAddress;
    // }

    // public Address getOfficeAddress() {
    //     return OfficeAddress;
    // }

    // public void setOfficeAddress(Address officeAddress) {
    //     OfficeAddress = officeAddress;
    // }

    

}
