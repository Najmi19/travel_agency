package fr.lernejo.prediction;

import com.sun.nio.sctp.SctpSocketOption;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Overall getList_C(){
            Controller Act = new Controller();
            Act.actuality();
            getList_T();
            getList_TT();
            Overall overall = new Overall("France",List_T);
            return overall;
}
    public void getList_T(){
        TemperatureService tempSrv = new TemperatureService();
        LocalDate localDate = LocalDate.now();
        List_T.add(new List_temperatures(tempSrv.getTemperature("France"), localDate));
    }
    public void getList_TT(){
        TemperatureService tempSrv = new TemperatureService();
        LocalDate localDateToday = LocalDate.now();
        LocalDate localDateYesterday = localDateToday.minusDays(1);
        List_T.add(new List_temperatures(tempSrv.getTemperature("France"), localDateYesterday));

    }
}
