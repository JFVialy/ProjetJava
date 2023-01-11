package com.heh.superconcessionnaire2000.adapter.in;

import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.model.User;
import com.heh.superconcessionnaire2000.port.in.CarManagerIn;
import com.heh.superconcessionnaire2000.port.in.UserManagerIn;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@Scope("session")
@RequiredArgsConstructor
public class CarController
{
    @Autowired
    private CarManagerIn carManager;
    @Autowired
    private UserManagerIn userManagerIn;

    public CarController(CarManagerIn carListGetter)
    {
        this.carManager = carListGetter;
    }

    @GetMapping("/carlist")
    public String carList(Model model, HttpSession session)
    {
        User user = userManagerIn.getConnectedUser();
        if(Objects.equals(user.getRole(), "admin"))
        {
            session.setAttribute("admin", true);
        }
        List<Car> cars = carManager.getCarList();
        model.addAttribute("cars", cars);
        return "carList";
    }

    @PostMapping("/cardelete")
    public String carDelete(Model model, @ModelAttribute("carId") String carId, HttpSession session)
    {
        model.addAttribute("car", carManager.getCar(Integer.parseInt(carId)));
        carManager.deleteCar(Integer.parseInt(carId));
        return "carDeleted";
    }

    @GetMapping("/addcar")
    public String addCar(Model model, HttpServletRequest request)
    {
        Car anoCar = new Car(0, "", "", 1900, "", 0, 0, "", false, false);
        model.addAttribute("car", anoCar);

        String confirm = "OK";
        request.getSession().setAttribute("confirmation", confirm);
        model.addAttribute("confirmation", confirm);
        return "addCar";
    }

    @GetMapping("/caradded")
    public String carAddedFail()
    {
        return "carAddedFail";
    }

    @PostMapping("/caradded")
    public String addCar(@ModelAttribute("car") Car car, @RequestParam("imageFile") MultipartFile file, HttpServletRequest request, HttpSession session)
            throws IOException {
        System.out.println(request.getSession().getAttribute("confirmation"));

        if(request.getSession().getAttribute("confirmation") != null && session.getAttribute("admin") != null)
        {
            carManager.addCar(car, file);
        }
        request.getSession().removeAttribute("confirmation");
        return "carAdded";
    }

    @PostMapping("/updatecar")
    public String carUpdate(Model model, @ModelAttribute("carId") String carId)
    {
        Car car = carManager.getCar(Integer.parseInt(carId));
        model.addAttribute("carToUpdate", car);
        return "updateCar";
    }

    @PostMapping("/carupdated")
    public String carUpdated(@ModelAttribute("car") Car car, HttpServletRequest request, HttpSession session)
    {
        carManager.updateCar(car);
        return "carUpdated";
    }

    @PostMapping("/carview")
    public String carView(Model model, @ModelAttribute("carId") String carId, HttpSession session)
    {
        Car car = carManager.getCar(Integer.parseInt(carId));
        model.addAttribute("carId", Long.parseLong(carId));
        model.addAttribute("car", car);

        return "carView";
    }
}