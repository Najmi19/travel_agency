package fr.lernejo.prediction;

import com.sun.nio.sctp.SctpSocketOption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class travel__controller implements Additional_Information {

    private final ArrayList<Country> countryArrayList = new ArrayList<>();
    private final ArrayList<Temperature> temperatures = new ArrayList<>();
    private final ArrayList<Overall> overallArrayList = new ArrayList<>();
    private final String SimpleDateFormat = null;

    @Override
    public void Information() {
        System.out.println("travel");
        System.out.println("information");
    }

    @GetMapping("/api/temperature")
    public Overall getcountryArrayList() {
        travel__controller info = new travel__controller();
        info.Information();
        gittemperature1();
        gittemperature2();
        Overall overall = new Overall("France",temperatures);
        return overall;
    }

    private void gittemperature1() {
        TemperatureService temperatureService = new TemperatureService();
        LocalDate localDate = LocalDate.now();
        temperatures.add(new Temperature(localDate, temperatureService.getTemperature("France")));
    }

    private void gittemperature2() {
        TemperatureService temperatureService = new TemperatureService();
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.minusDays(1);
        temperatures.add(new Temperature(localDate2, temperatureService.getTemperature("France")));
    }

}
