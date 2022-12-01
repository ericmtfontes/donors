package com.myapi.myapplication.controllers;

import com.myapi.myapplication.dto.AmountPerState;
import com.myapi.myapplication.dto.AverageAgeByBloodType;
import com.myapi.myapplication.dto.PercentageObese;
import com.myapi.myapplication.dto.PotentialDonorByType;
import com.myapi.myapplication.entities.AverageImcByAge;
import com.myapi.myapplication.entities.Donor;
import com.myapi.myapplication.services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/donors")
public class DonorController {

    @Autowired
    DonorService service;

    @RequestMapping("/")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index.html");
        return modelAndView;
    }

    @PostMapping
    public ResponseEntity<HttpStatus> process(@RequestBody List<Donor> donors){
        service.process(donors);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/amount-per-state")
    public ResponseEntity<List<AmountPerState>> amountPerState(){
        return new ResponseEntity<>(service.amountPerState(), HttpStatus.OK);
    }

    @GetMapping(value = "/average-imc-by-age")
    public ResponseEntity<List<AverageImcByAge>> averageImcByAge(){
        return new ResponseEntity<>(service.averageImcByAge(), HttpStatus.OK);
    }

    @GetMapping(value = "/percentage-obese")
    public ResponseEntity<List<PercentageObese>> percentageObese(){
        return new ResponseEntity<>(service.percentageObese(), HttpStatus.OK);
    }

    @GetMapping(value = "/average-by-blood-type")
    public ResponseEntity<List<AverageAgeByBloodType>> averageByBloodType(){
        return new ResponseEntity<>(service.averageByBloodType(), HttpStatus.OK);
    }

    @GetMapping(value = "/potential-donors-by-type")
    public ResponseEntity<List<PotentialDonorByType>> potentialDonorsByType(){
        return new ResponseEntity<>(service.potentialDonorsByType(), HttpStatus.OK);
    }
}
