package com.springcapstone.speaker.controllers;

import com.springcapstone.speaker.models.Speaker;
import com.springcapstone.speaker.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Speaker speaker) {
        speakerRepository.save(speaker);
    }

    @GetMapping("/{id}")
    public Speaker get(@PathVariable("id") long id) {
        return speakerRepository.getOne(id);
    }

        @PutMapping("/{id}")
        public ResponseEntity<Speaker> updateSpeaker(@PathVariable(value = "id" ) Long id,
        @RequestBody Speaker speakerDetails) throws ResourceNotFoundException {
        Speaker speaker = speakerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Speaker not found"));

        speaker.setSpeaker(speakerDetails.getSpeaker());
        speaker.setCompany(speakerDetails.getCompany());
        speaker.setLocation(speakerDetails.getLocation());
        speaker.setEmail(speakerDetails.getEmail());
        speaker.setHours(speakerDetails.getHours());
        speaker.setImage(speakerDetails.getImage());
        speaker.setDate(speakerDetails.getDate());
        speaker.setLinkedin(speakerDetails.getLinkedin());
        speaker.setSummary(speakerDetails.getSummary());
        speaker.setOnline(speakerDetails.getOnline());
        speaker.setTime(speakerDetails.getTime());
        speaker.setTopic(speakerDetails.getTopic());
        final Speaker updatedSpeaker = speakerRepository.save(speaker);
        return ResponseEntity.ok(updatedSpeaker);
        }

        @DeleteMapping("/{id}")
        void delete(@PathVariable Long id){
        speakerRepository.deleteById(id);
    }
}
