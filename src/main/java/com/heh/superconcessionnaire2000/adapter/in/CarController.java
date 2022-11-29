package com.heh.superconcessionnaire2000.adapter.in;

import com.heh.superconcessionnaire2000.adapter.out.CarRepository;
import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.port.in.AddCarUseCase;
import com.heh.superconcessionnaire2000.port.in.CarListUseCase;
import com.heh.superconcessionnaire2000.port.out.GetCars;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController
{
    @Autowired
    private CarListUseCase carListGetter;
    @Autowired
    private GetCars carAdder;
    private List<Car> cars;

    public CarController(CarListUseCase carListGetter)
    {
        this.carListGetter = carListGetter;
    }

    @GetMapping("/carlist")
    public String carList(Model model)
    {
        cars = carListGetter.getCarList();
        model.addAttribute("cars", cars);
        return "carList";
    }

    @GetMapping("/addcar")
    public String addCar(Model model)
    {
        Car anoCar = new Car(0, "", "", 1900, "", 0, 0);
        model.addAttribute("car", anoCar);
        return "addCar";
    }

    @PostMapping("/caradded")
    public String addCar(@ModelAttribute("car") Car car)
    {
        carAdder.addCarToDB(car);
        return "carAdded";
    }
}