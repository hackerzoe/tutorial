package cse364.project;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MovieController {

    private final MovieRepository repository;

    MovieController(MovieRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/movies")
    List<Movie> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/movies")
    Movie newMovie(@RequestBody Movie newMovie) {

        Long id = newMovie.getMovie_id();
        Optional<Movie> optional = repository.findById(id);
        if(optional.isPresent()){
            return repository.save(newMovie);
        } else {
            throw new CannotChangeIDException("Movie");
        }
    }

    // Single item

    @GetMapping("/movies/{id}")
    Movie one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @PutMapping("/movies/{id}")
    Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id) {

        Optional<Movie> optional = repository.findById(id);
        if(optional.isPresent()){
            Long NewMovieID = newMovie.getMovie_id();
            if(id == NewMovieID) {
                return repository.save(newMovie);
            } else{
                throw new CannotChangeIDException("Movie");
            }
        } else{
            throw new MovieNotFoundException(id);
        }
    }

    @DeleteMapping("/Movies/{id}")
    void deleteEmployee(@PathVariable Long id) {

        Optional<Movie> optional = repository.findById(id);
        if(optional.isPresent()){
            repository.deleteById(id);
        } else{
            throw new MovieNotFoundException(id);
        }
    }
}