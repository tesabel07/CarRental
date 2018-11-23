package com.CarRental.controller;

import com.CarRental.model.Car;
import com.CarRental.model.User;
import com.CarRental.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
public class CarController {

//    private static String UPLOADED_FOLDER = "\\META-INF.resources\\images\\";
    private static String UPLOADED_FOLDER = "D:\\images\\";

    @Autowired
    private ICarService carService;

    @CrossOrigin
    @RequestMapping(value="/car" ,method = RequestMethod.POST)
    public void addCar(@RequestBody Car car){
        carService.create(car);
    }

    @CrossOrigin
    @RequestMapping(value = "/car",method = RequestMethod.GET)
    public List<Car> allCars(){
        return carService.allCars();
    }

    @CrossOrigin
    @RequestMapping(value = "/car/{id}",method = RequestMethod.GET)
    public Car getOneCar(@PathVariable Long id){
        Car car=carService.getCar(id);
        //System.out.println(car);
        return car;
    }

    @CrossOrigin
    @GetMapping("/availablecar")
    public List<Car> listOfAvailableCar(){
        List<Car> availableCar= carService.availableCar();
        return availableCar;
    }
    // before Deleting the car it must check the user if it is admin
    @CrossOrigin
    @PostMapping("/car/delete/{id}/{userId}")
    public void delete(@PathVariable long id, @PathVariable long userId) throws Exception{
        carService.delete(userId,id);
    }

    @CrossOrigin
    @RequestMapping(value = "/car/{id}",method = RequestMethod.DELETE)
    public  void deleteCar(long id){
        carService.deleteCar(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/car/upload", method = RequestMethod.POST)
    public String singleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Error: the file is empty.";
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file.getOriginalFilename();
    }

    @CrossOrigin
    @RequestMapping(value = "car/image/{name:.+}", method = RequestMethod.GET)
    public @ResponseBody byte[] getImage(@PathVariable String name,HttpServletResponse response) throws IOException {
        try {
            return org.apache.commons.io.IOUtils.toByteArray(new FileInputStream(new File(UPLOADED_FOLDER +  name)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
