package fr.lernejo.travelsite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class travel_controller {
    private final ArrayList<travel> listA = new ArrayList<>();
    private final ArrayList<registration_travel> listB = new ArrayList<>();

    @GetMapping("/api/travels")
    public ArrayList<travel> getListA() {
        listA.add(new travel("Caribbean",
            32.4));
        listA.add(new travel("Australia",
            35.1));
        return listA;
    }

    @PostMapping("api/travels")
    public void add (@RequestBody travel Travel){
        this.listA.add(Travel);
    }

    @GetMapping("/api/inscription")
    public ArrayList<registration_travel> getListB() {
        return listB;
    }

    @PostMapping("api/inscription")
    public void add (@RequestBody registration_travel registration){
        this.listB.add(registration);
    }
}
