package com.example.demoms3.api;

import com.example.demoms3.model.MovieInfo;
import com.example.demoms3.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/{movieTitle}")
    public MovieInfo getMovieInfo(@PathVariable("movieTitle") String movieTitle) {
        return movieService.getMovieInfo(movieTitle);
    }

}
