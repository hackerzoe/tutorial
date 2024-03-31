package cse364.project;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "ratings")
@Entity
public class Rating {

    private @Id Long User_id;
    private Long Rate;
    Rating() {};
    Rating(Long User_id, Long Rate){
        this.User_id = User_id;
        this.Rate = Rate;
    }

    public Long getUser_id() { return this.User_id; }
    public Long getRate() { return this.Rate; }
    public void setMovie_id(Long User_id) { this.User_id = User_id; }
    public void setTitle(Long Rate) { this.Rate = Rate; }

}