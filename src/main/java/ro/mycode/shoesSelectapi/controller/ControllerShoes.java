package ro.mycode.shoesSelectapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.mycode.shoesSelectapi.model.Shoes;
import ro.mycode.shoesSelectapi.repository.ShoesRepo;

import java.util.List;

@RestController
@CrossOrigin
public class ControllerShoes {

    private ShoesRepo shoesRepo;

    public ControllerShoes(ShoesRepo shoesRepo){
        this.shoesRepo=shoesRepo;
    }

    @GetMapping("api/v1/shoes")

    public List<Shoes> getAllShoes(){
        return  shoesRepo.findAll();
    }

    @GetMapping("api/v1/shoes/modele")
    public  List<String>getAllModele(){
        return shoesRepo.getAllModels();
    }

    @GetMapping("api/v1/shoes/{modele")
    public List<Shoes>getAllShoesByModele(@PathVariable String model){
        return  shoesRepo.getAllShoesByModel(model);
    }

}
