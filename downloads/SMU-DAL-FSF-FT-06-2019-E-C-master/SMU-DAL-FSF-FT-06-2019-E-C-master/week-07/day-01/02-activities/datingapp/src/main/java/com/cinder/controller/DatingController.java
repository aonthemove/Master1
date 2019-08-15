package com.cinder.controller;

import com.cinder.models.Dislike;
import com.cinder.models.Person;
import com.cinder.models.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DatingController {

    private static int personId = 1;
    private static int dislikeId = 1;

    private List<Dislike> dislikes;
    private List<Person> people;
    private Profile profile;

    public DatingController() {
        people = new ArrayList<>();
        people.add(new Person(personId++, "Sam", 25, "I am Sam."));
        people.add(new Person(personId++, "Sue", 27, "I like Reiki and beach yoga. I love my cat and all energies on all ephemeral planes."));
        people.add(new Person(personId++, "Tony", 24, "I fix cars, weld, and do jazzercise."));
        people.add(new Person(personId++, "Simone", 33, "I am a jazz singer and travel extensively to perform. Looking for someone who can keep up with my schedule."));
        people.add(new Person(personId++, "Tara", 25, "I am super energetic. Always hiking, biking, skating, running, and on adventures. Come join me!"));
        people.add(new Person(personId++, "Selena", 25, "I am from Ecuador and am new to town. I would love a friend to explore the city with."));

        dislikes = new ArrayList<>();
        dislikes.add(new Dislike(dislikeId++, 1));
        dislikes.add(new Dislike(dislikeId++, 3));

        profile = new Profile();
        profile.setHiking(1);
        profile.setDancing(3);
        profile.setSports(5);
        profile.setReading(2);
        profile.setQuietNight(1);
        profile.setDining(5);
        profile.setDebate(2);
        profile.setClub(4);
        profile.setPolitics(3);
        profile.setBeach(4);
        profile.setParties(1);

    }

    @RequestMapping(value="/api/match", method = RequestMethod.GET)
    public List<Person> getPeople() {
        List<Person> matches = new ArrayList<>();

        for(Person person : people) {
            boolean liked = true;
            for(Dislike dislike : dislikes) {
                if(dislike.getPersonId() == person.getId()) {
                    liked = false;
                    break;
                }
            }
            if (liked) {
                matches.add(person);
            }
        }

        return matches;
    }

    @RequestMapping(value="/api/dislike", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDislikes(@RequestBody Dislike dislike) {
        dislike.setId(dislikeId++);
        dislikes.add(dislike);
    }

    @RequestMapping(value="/api/profile", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(@RequestBody Profile profile) {
        this.profile = profile;
    }


    @RequestMapping(value="/api/profile", method = RequestMethod.GET)
    public Profile getProfile() {
        return profile;
    }


}
