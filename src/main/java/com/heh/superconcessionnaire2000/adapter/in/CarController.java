package com.heh.superconcessionnaire2000.adapter.in;

import com.heh.superconcessionnaire2000.adapter.out.CarRepository;
import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.port.in.CarListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CarController
{
    @Autowired
    private CarListUseCase carListGetter;
    private List<Car> cars;

    public CarController(CarListUseCase carListGetter)
    {
        this.carListGetter = carListGetter;
    }

    @GetMapping("/")
    public String carList(Model model)
    {
        cars = carListGetter.getCarList();
        model.addAttribute("cars", cars);
        return "carList";
    }
}