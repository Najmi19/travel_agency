package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.*;

import java.rmi.registry.Registry;
import java.util.ArrayList;

@RestController
public class travel_controller {
    private final ArrayList<Country> listA = new ArrayList<>();
    private final ArrayList<registration_travel> listB = new ArrayList<>();

    @GetMapping("/api/travels")
    public ArrayList<Country> getListA(@RequestParam String userName) {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Caribbean", 32.4));
        countries.add(new Country("Australia", 35.1));
        for (registration_travel registration : listB) {
            if (registration.userName().equals(userName)) {
                return countries;
            }
        }
            return new ArrayList<Country>();
        }

        @PostMapping("api/inscription")
        public void add (@RequestBody registration_travel registration){
            this.listB.add(registration);
        }
    }

