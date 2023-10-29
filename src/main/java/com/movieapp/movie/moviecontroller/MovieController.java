package com.movieapp.movie.moviecontroller;

import com.movieapp.movie.movieservice.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies/")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/upcoming")
    public ResponseEntity<?> getUpcoming(){
        return ResponseEntity.ok(movieService.fetchUpcomingMovies());
    }

    @GetMapping("/topRated")
    public ResponseEntity<?> getTopRated(){
        return ResponseEntity.ok(movieService.fetchTopRated());
    }

    @GetMapping("/popular")
    public ResponseEntity<?> getPopularMovies(){
        return ResponseEntity.ok(movieService.fetchPopularMovies());
    }

}
