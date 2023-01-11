package com.heh.superconcessionnaire2000.adapter.in;


import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.model.Contract;
import com.heh.superconcessionnaire2000.model.User;
import com.heh.superconcessionnaire2000.port.in.CarManagerIn;
import com.heh.superconcessionnaire2000.port.in.ContractManagerIn;
import com.heh.superconcessionnaire2000.port.in.UserManagerIn;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
@Scope("session")
@RequiredArgsConstructor
public class ContractController
{
    @Autowired
    private ContractManagerIn contractManager;
    @Autowired
    private CarManagerIn carManager;
    @Autowired
    private UserManagerIn userManager;

    public ContractController(ContractManagerIn contractManager)
    {
        this.contractManager = contractManager;
    }

    @PostMapping("/buycar")
    public String buyCar(@ModelAttribute("carId") String carId)
    {
        Car car = carManager.getCar(Integer.parseInt(carId));
        User currentUser = userManager.getConnectedUser();

        contractManager.addContract(car, currentUser);

        return "contractCreated";
    }

    @GetMapping("/contractlist")
    public String contractList(Model model)
    {
        List<Contract> contracts = contractManager.getAllContracts();
        model.addAttribute("contracts", contracts);
        return "contractList";
    }
}
