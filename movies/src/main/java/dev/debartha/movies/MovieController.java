package dev.debartha.movies;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    private HttpHeaders headers = new HttpHeaders();

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        headers.set("Content-Type", "application/json");
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable("id") String imdbId) {
        headers.set("Content-Type", "application/json");
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId), headers, HttpStatus.OK);
    }
}
