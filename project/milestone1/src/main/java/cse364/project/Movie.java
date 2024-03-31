package cse364.project;

import jakarta.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "movies")
@Entity
public class Movie {

    private @Id Long Movie_id;
    private String Title;
    private String Genres;
    private List<Rating> RatingList;
    private Long SumOfRating = 0L;
    Movie() {};
    Movie(Long Movie_id, String Title, String Genres){
        this.Movie_id = Movie_id;
        this.Title = Title;
        this.Genres = Genres;
        this.RatingList = new ArrayList();
        this.SumOfRating = 0L;
    }

    public Long getMovie_id() { return this.Movie_id; }
    public String getTitle() { return this.Title; }
    public String getGenres() { return this.Genres; }
    public List<Rating> getRatingList() {return this.RatingList; }
    public Long getSumOfRating() { return this.SumOfRating; }
    public void setMovie_id(Long Movie_id) { this.Movie_id = Movie_id; }
    public void setTitle(String Title) { this.Title = Title; }
    public void setGenres(String Genres) { this.Genres = Genres; }
    public void addRatingList(Rating Rate) { this.RatingList.add(Rate); }
    public void plusSumOfRating(Long diff) { this.SumOfRating += diff; }

}