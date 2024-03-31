package cse364.project;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Entity
public class User {

    private @Id String User_id;
    private String Gender;
    private int Age;
    private String Occupation;
    private int Zip_code;
    User() {};
    User(String User_id, String Gender, int Age, String Occupation, int Zip_code){
        this.User_id = User_id;
        this.Gender = Gender;
        this.Age = Age;
        this.Occupation = Occupation;
        this.Zip_code = Zip_code;
    }

    public String getUser_id() { return this.User_id; }
    public String getGender() { return this.Gender; }
    public int getAge() { return this.Age; }
    public String getOccupation() { return this.Occupation; }
    public int getZip_code() { return this.Zip_code; }

    public void setUser_id(String User_id) { this.User_id = User_id; }
    public void setGender(String Gender) { this.Gender = Gender; }
    public void setAge(int Age) { this.Age = Age; }
    public void setOccupation(String Occupation) { this.Occupation = Occupation; }
    public void setZip_code(int Zip_code) { this.Zip_code = Zip_code; }

}