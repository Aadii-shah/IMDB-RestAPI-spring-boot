package com.movieapp.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {

    private Integer page;
    private Integer total_pages;
    private Integer total_results;

    private List<Movie> results;

}
