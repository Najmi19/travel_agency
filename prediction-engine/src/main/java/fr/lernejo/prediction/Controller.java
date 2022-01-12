package fr.lernejo.prediction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class Controller implements Actuality {
    private final ArrayList<Country> List_C = new ArrayList<>();
    private final ArrayList<List_temperatures> List_T = new ArrayList<>();
    private final String Date = null;
    private final ArrayList<Overall> List_O = new ArrayList<>();

    @Override
    public void actuality() {
        System.out.println("The server");
        System.out.println("the Date and the temperature");
    }

@GetMapping("/api/temperature")
    public Overall getList_C(@RequestParam String country){
            this.actuality();
            ArrayList<List_temperatures>list_w = new ArrayList<>();
            list_w = getList_T(country,list_w);
            list_w =getList_TT(country,list_w);
            Overall overall = new Overall(country,list_w);
            return overall;
}
    public ArrayList<List_temperatures> getList_T(String country, ArrayList<List_temperatures>list_w){
        TemperatureService tempSrv = new TemperatureService();
        LocalDate localDate = LocalDate.now();
        list_w.add(new List_temperatures(tempSrv.getTemperature(country), localDate));
        return list_w;
    }
    public ArrayList<List_temperatures> getList_TT(String country, ArrayList<List_temperatures>list_w){
        TemperatureService tempSrv = new TemperatureService();
        LocalDate localDateToday = LocalDate.now();
        LocalDate localDateYesterday = localDateToday.minusDays(1);
        list_w.add(new List_temperatures(tempSrv.getTemperature(country), localDateYesterday));
        return list_w;
    }

}
