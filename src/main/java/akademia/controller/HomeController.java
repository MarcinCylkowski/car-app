package akademia.controller;

import akademia.model.Car;
import akademia.service.CarService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class HomeController {

    private CarService carService;

    public HomeController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    public String getHomePage(
            Model model, @RequestParam(value = "message", required = false) String resultMessage) {
        String titlePage = "Home page Cars";
        String welcome = "Welcome to ma awesome application!";
        model.addAttribute("tilePage", titlePage);
        model.addAttribute("welcome", welcome);
        model.addAttribute("resultMessage", resultMessage);
        model.addAttribute("cars", carService.getCars());
        return "index";
    }

    @PostMapping("/cars/add")
    public String addCar(@ModelAttribute Car incomeCar) {
        Car car = new Car();
        car.setBrand(incomeCar.getBrand());
        car.setModel(incomeCar.getModel());
        car.setProductionYear(incomeCar.getProductionYear());
        car.setDescribe(incomeCar.getDescribe());
        String operationResult = carService.createCar(car).getModel();
        return "redirect:/cars?message=create car: " + operationResult;
    }

    @GetMapping("/cars/delete")
    public String deleteCar(@RequestParam long id) {
        carService.deleteCar(id);
        return "redirect:/cars";
    }


    @GetMapping("/cars/update")
    public String updateCar(@RequestParam long id, Model model) {
        Car car = carService.getCarById(id);
        if (car == null) {
            return "Cannot find car!";
        }
        model.addAttribute("car", car);
        return "update";
    }


    @PostMapping("/cars/update/confirm")
    public String updateCarConfirm(@ModelAttribute Car incomeCar) {
        Car car = new Car();
        car.setId(incomeCar.getId());
        car.setBrand(incomeCar.getBrand());
        car.setModel(incomeCar.getModel());
        car.setProductionYear(incomeCar.getProductionYear());
        car.setDescribe(incomeCar.getDescribe());
        String operationResult = carService.updateCar(incomeCar.getId(),car).getModel();
        return "redirect:/cars?message=updated car: " + operationResult;
    }


}
