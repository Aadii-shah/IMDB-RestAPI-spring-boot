package com.movieapp.movie.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
        private boolean adult;
        private String backdropPath;
        private List<Integer> genreIds;
        private int id;
        private String originalLanguage;
        private String originalTitle;
        private String overview;
        private double popularity;
        @JsonProperty("poster_path")
        private String posterPath;
        @JsonProperty("release_date")
        private String releaseDate;
        private String title;
        private boolean video;
        @JsonProperty("vote_average")
        private double voteAverage;
        private int voteCount;
}
