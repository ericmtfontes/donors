package com.myapi.myapplication.repositories;

import com.myapi.myapplication.entities.AverageImcByAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AverageImcByAgeRepository extends JpaRepository<AverageImcByAge, Long> {

    @Query(value = "SELECT t.* FROM (\n" +
            "(select 1 AS id, '0-10' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age > 0 AND age <= 10)\n" +
            "UNION ALL \n" +
            "(select 2 id, '11-20' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 11 AND age <= 20)\n" +
            "UNION ALL \n" +
            "(select 3 AS id, '21-30' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 21 AND age <= 30)\n" +
            "UNION ALL\n" +
            "(select 4 as id, '31-40' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 31 AND age <= 40)\n" +
            "UNION ALL\n" +
            "(select 5 as id, '41-50' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 41 AND age <= 50)\n" +
            "UNION ALL\n" +
            "(select 6 as id, '51-60' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 51 AND age <= 60)\n" +
            "UNION ALL\n" +
            "(select 7 as id, '61-70' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 61 AND age <= 70)\n" +
            "UNION ALL\n" +
            "(select 8 as id, '71-80' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 71 AND age <= 80)\n" +
            "UNION ALL\n" +
            "(select 9 as id, '81-90' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 81 AND age <= 90)\n" +
            "UNION ALL\n" +
            "(select 10 as id, '91-100' as age, COALESCE((SUM(imc) / COUNT(1)),0) as average from donor WHERE age >= 91 AND age <= 100)\n" +
            ") as t", nativeQuery = true)
    public List<AverageImcByAge> findAverageImcByAge();
}
