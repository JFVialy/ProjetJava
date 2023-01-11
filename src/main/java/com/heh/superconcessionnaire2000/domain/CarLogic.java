package com.heh.superconcessionnaire2000.domain;

import com.heh.superconcessionnaire2000.model.Car;
import com.heh.superconcessionnaire2000.port.in.CarManagerIn;
import com.heh.superconcessionnaire2000.port.out.CarManagerOut;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RequiredArgsConstructor
public class CarLogic implements CarManagerIn
{
    private CarManagerOut carGetter;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\car_images";


    public CarLogic(CarManagerOut carGetter) {
        this.carGetter = carGetter;
    }

    @Override
    public List<Car> getCarList()
    {
        return this.carGetter.getAllCars();
    }

    @Override
    public void addCar(Car car, MultipartFile file) throws IOException {
        Integer lastId = carGetter.getLastCarId() + 1;
        String ext = file.getOriginalFilename().split("\\.", 2)[1];
        String imageName = lastId + "_" + car.getBrand() + "_" + car.getModel() + '.' + ext;
        Path fileNamePath = Paths.get(UPLOAD_DIRECTORY, imageName);
        Files.write(fileNamePath, file.getBytes());
        car.setImage(imageName);
        this.carGetter.addCarToDB(car);
    }

    @Override
    public Car getCar(Integer id)
    {
        return this.carGetter.getCarById(id);
    }

    @Override
    public void deleteCar(Integer id)
    {
        this.carGetter.deleteCar(id);
    }

    @Override
    public void updateCar(Car car)
    {
        this.carGetter.updateCar(car);
    }
}
