package com.music.app.rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.music.app.rest.Models.Tracks;
import com.music.app.rest.Repo.TracksRepo;

import java.util.List;

@RestController
public class MusicControllers {

	@Autowired
	private TracksRepo trackRepo;

	@GetMapping(value = "/")
	public String getPage() {
		return "Welcome";

	}
	//Get requests
	@GetMapping(value = "/music/tracks")
	public List<Tracks> getTracks() {
		return trackRepo.findAll();
	}
	//Post requests
	@PostMapping(value = "/music/track")
	public String saveTrack(@RequestBody Tracks track) {
		trackRepo.save(track);
		return "Saved...";
	}
	//Put requests
	@PutMapping(value = "/music/track/{id}")
	public String updateUser(@PathVariable long id, @RequestBody Tracks track) {
		Tracks updatedTrack = trackRepo.findById(id).get();
		updatedTrack.setArtist(track.getArtist());
		updatedTrack.setName(track.getName());
		updatedTrack.setGenre(track.getGenre());
		updatedTrack.setDurationInSeconds(track.getDurationInSeconds());
		trackRepo.save(updatedTrack);
		return "Updateed...";
	}
	//Delete requests
	@DeleteMapping(value = "music/delete/{id}")
	public String deleteTrack(@PathVariable long id) {
		Tracks deleteTrack = trackRepo.findById(id).get();
		trackRepo.delete(deleteTrack);
		return "Deleted track with the id: " +id;
	}
}