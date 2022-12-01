package com.myapi.myapplication.services;

import com.myapi.myapplication.dto.AmountPerState;
import com.myapi.myapplication.dto.AverageAgeByBloodType;
import com.myapi.myapplication.dto.PercentageObese;
import com.myapi.myapplication.dto.PotentialDonorByType;
import com.myapi.myapplication.entities.AverageImcByAge;
import com.myapi.myapplication.entities.Donor;
import com.myapi.myapplication.handler.ResourceNotFoundException;
import com.myapi.myapplication.repositories.AverageImcByAgeRepository;
import com.myapi.myapplication.repositories.DonorRepository;
import com.myapi.myapplication.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DonorService {

    @Autowired
    DonorRepository repository;

    @Autowired
    AverageImcByAgeRepository repo;

    public void process(List<Donor> list){
        List<Donor> donors = new ArrayList<>();
        for(Donor d : list){
            Integer age = Util.calculateAge(d.getBirthDate());
            d.setAge(age);
            d.setImc(Util.calculateImc(d.getWeight(), d.getHeight()));
            if(age >= 16 && age <= 69 && d.getWeight() > 50.0){
                d.setCanDonate(Boolean.TRUE);
            }else{
                d.setCanDonate(Boolean.FALSE);
            }
            donors.add(d);
        }
        repository.saveAll(donors);
    }

    public List<AmountPerState> amountPerState(){
        List<Donor> donors = findAllDonors();
        Map<String, Integer> amountPerState = new TreeMap<>();
        for(Donor d : donors){
            if(!amountPerState.containsKey(d.getState())){
                amountPerState.put(d.getState(), 1);
            }else{
                amountPerState.put(d.getState(), amountPerState.get(d.getState()) + 1);
            }
        }
        List<AmountPerState> result = new ArrayList<>();
        for(String i : amountPerState.keySet()){
            result.add(new AmountPerState(i, amountPerState.get(i)));
        }
        return result;
    }

    public List<AverageImcByAge> averageImcByAge(){
        return repo.findAverageImcByAge();
    }

    public List<PercentageObese> percentageObese(){
        List<Donor> donors = findAllDonors();
        Map<String, Integer> qtdObeses = new HashMap<>();
        Map<String, Integer> totalMenAndWomen = new HashMap<>();
        for(Donor d : donors){
            if(d.getImc() > 30){
                if(!qtdObeses.containsKey(d.getSex())){
                    qtdObeses.put(d.getSex(), 1);
                }else{
                    qtdObeses.put(d.getSex(), qtdObeses.get(d.getSex()) + 1);
                }
            }
            if(!totalMenAndWomen.containsKey(d.getSex())){
                totalMenAndWomen.put(d.getSex(), 1);
            }else{
                totalMenAndWomen.put(d.getSex(), totalMenAndWomen.get(d.getSex()) + 1);
            }
        }
        Map<String, Float> percentage = new TreeMap<>();
        for(String i : totalMenAndWomen.keySet()){
            float per = qtdObeses.get(i) * totalMenAndWomen.get(i) / 100;
            percentage.put(i, per);
        }
        List<PercentageObese> result = new ArrayList<>();
        for(String i : percentage.keySet()){
            result.add(new PercentageObese(i, percentage.get(i)));
        }
        return result;
    }

    public List<AverageAgeByBloodType> averageByBloodType(){
        List<Donor> donors = findAllDonors();
        Map<String, Integer> qtdByType =  new HashMap<>();
        Map<String, Integer> totalAgeByType = new HashMap<>();
        for(Donor d : donors){
            if(!qtdByType.containsKey(d.getBloodType())){
                qtdByType.put(d.getBloodType(), 1);
                totalAgeByType.put(d.getBloodType(), d.getAge());
            }else{
                qtdByType.put(d.getBloodType(), qtdByType.get(d.getBloodType()) + 1);
                totalAgeByType.put(d.getBloodType(), totalAgeByType.get(d.getBloodType()) + d.getAge());
            }
        }
        Map<String, Float> r = new TreeMap<>();
        for(String i : qtdByType.keySet()){
            float average = totalAgeByType.get(i) / qtdByType.get(i);
            r.put(i, average);
        }
        List<AverageAgeByBloodType> result = new ArrayList<>();
        for(String i : r.keySet()){
            result.add(new AverageAgeByBloodType(i, r.get(i)));
        }
        return result;
    }

    public List<PotentialDonorByType> potentialDonorsByType(){
        List<Donor> r = findAllDonors();
        List<Donor> donors = new ArrayList<>();
        Map<String, Integer> qtdDonors = new HashMap<>();
        Map<String, Integer> potentialDonorsByType = new TreeMap<>();
        for(Donor d : r){
            if(d.getCanDonate()){
                donors.add(d);
            }
        }
        for(Donor d : donors){
            if(!qtdDonors.containsKey(d.getBloodType())){
                qtdDonors.put(d.getBloodType(), 1);
                potentialDonorsByType.put(d.getBloodType(), 0);
            }else{
                qtdDonors.put(d.getBloodType(), qtdDonors.get(d.getBloodType()) + 1);
                potentialDonorsByType.put(d.getBloodType(), 0);
            }
        }
        for(String i : qtdDonors.keySet()){
           if(i.equals("A+")){
               potentialDonorsByType.put("A+", potentialDonorsByType.get("A+") + qtdDonors.get(i));
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
           }else if(i.equals("A-")){
               potentialDonorsByType.put("A+", potentialDonorsByType.get("A+") + qtdDonors.get(i));
               potentialDonorsByType.put("A-", potentialDonorsByType.get("A-") + qtdDonors.get(i));
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
               potentialDonorsByType.put("AB-", potentialDonorsByType.get("AB-") + qtdDonors.get(i));
           }else if(i.equals("B+")){
               potentialDonorsByType.put("B+", potentialDonorsByType.get("B+") + qtdDonors.get(i));
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
           }else if(i.equals("B-")){
               potentialDonorsByType.put("B+", potentialDonorsByType.get("B+") + qtdDonors.get(i));
               potentialDonorsByType.put("B-", potentialDonorsByType.get("B-") + qtdDonors.get(i));
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
               potentialDonorsByType.put("AB-", potentialDonorsByType.get("AB-") + qtdDonors.get(i));
           }else if(i.equals("AB+")){
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
           }else if(i.equals("AB-")){
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
               potentialDonorsByType.put("AB-", potentialDonorsByType.get("AB-") + qtdDonors.get(i));
           }else if(i.equals("O+")){
               potentialDonorsByType.put("A+", potentialDonorsByType.get("A+") + qtdDonors.get(i));
               potentialDonorsByType.put("B+", potentialDonorsByType.get("B+") + qtdDonors.get(i));
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
               potentialDonorsByType.put("O+", potentialDonorsByType.get("O+") + qtdDonors.get(i));
           }else if(i.equals("O-")){
               potentialDonorsByType.put("A+", potentialDonorsByType.get("A+") + qtdDonors.get(i));
               potentialDonorsByType.put("A-", potentialDonorsByType.get("A-") + qtdDonors.get(i));
               potentialDonorsByType.put("B+", potentialDonorsByType.get("B+") + qtdDonors.get(i));
               potentialDonorsByType.put("B-", potentialDonorsByType.get("B-") + qtdDonors.get(i));
               potentialDonorsByType.put("AB+", potentialDonorsByType.get("AB+") + qtdDonors.get(i));
               potentialDonorsByType.put("AB-", potentialDonorsByType.get("AB-") + qtdDonors.get(i));
               potentialDonorsByType.put("O+", potentialDonorsByType.get("O+") + qtdDonors.get(i));
               potentialDonorsByType.put("O-", potentialDonorsByType.get("O-") + qtdDonors.get(i));
           }
        }
        List<PotentialDonorByType> result = new ArrayList<>();
        for(String i : potentialDonorsByType.keySet()){
            result.add(new PotentialDonorByType(i, potentialDonorsByType.get(i)));
        }
        return result;
    }

    private List<Donor> findAllDonors() {
        List<Donor> donors = repository.findAll();
        if(donors.isEmpty()){
            throw new ResourceNotFoundException("Donors not found");
        }
        return donors;
    }
}
