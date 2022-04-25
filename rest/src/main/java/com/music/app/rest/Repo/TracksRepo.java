package com.music.app.rest.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.music.app.rest.Models.Tracks;

public interface TracksRepo extends JpaRepository <Tracks, Long> {

}
