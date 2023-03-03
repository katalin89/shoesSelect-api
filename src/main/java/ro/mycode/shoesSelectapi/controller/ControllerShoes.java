package ro.mycode.shoesSelectapi.controller;

import org.springframework.web.bind.annotation.*;
import ro.mycode.shoesSelectapi.dtos.ShoesDTO;
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

    @GetMapping("api/v1/shoes/{modele}")
    public List<Shoes>getAllShoesByModele(@PathVariable String model){

        return  shoesRepo.getAllShoesByModel(model);
    }

    @PostMapping("api/v1/add")
    public  Shoes addShoes(@RequestBody Shoes shoes){
        this.shoesRepo.save(shoes);

        return  shoes;
    }

    @DeleteMapping("api/v1/delete/{id}")
    public long deleteShoesById(@PathVariable long id){
        this.shoesRepo.deleteById(id);
        return id;
    }

    @PutMapping("api/v1/update")
    public Shoes updateShoes(@RequestBody ShoesDTO shoes){
        Shoes s=shoesRepo.findByModel(shoes.getModel());

        if(shoes.getModel().equals("")==false){
            s.setModel(shoes.getModel());
        }else System.out.println("Nu are valoare");

        if(shoes.getMaterial().equals("")==false){
            s.setMaterial(shoes.getMaterial());
        }else System.out.println("Nu are valoare");

        if(shoes.getCuloare().equals("")==false){
            s.setCuloare(shoes.getCuloare());
        }else System.out.println("Nu are valoare");

        if(shoes.getPret()!=0){
            s.setPret(shoes.getPret());
        }else System.out.println("Nu are valoare");
        shoesRepo.save(s);

        return s;
    }



}
