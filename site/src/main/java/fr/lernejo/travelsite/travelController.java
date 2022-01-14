package fr.lernejo.travelsite;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class travelController {
    private final ArrayList<country> listA = new ArrayList<>();
    private final ArrayList<registrationTravel> listB = new ArrayList<>();

    @GetMapping("/api/travels")
    public ArrayList<country> getListA(@RequestParam String userName) {
        ArrayList<country> countries = new ArrayList<>();
        countries.add(new country("Caribbean", 32.4));
        countries.add(new country("Australia", 35.1));
        for (registrationTravel registration : listB) {
            if (registration.userName().equals(userName)) {
                return countries;
            }
        }
            return new ArrayList<country>();
        }
        @PostMapping("api/inscription")
        public void add (@RequestBody registrationTravel registration){
            this.listB.add(registration);
        }
    }

