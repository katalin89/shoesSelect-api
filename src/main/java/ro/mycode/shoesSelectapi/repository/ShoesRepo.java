package ro.mycode.shoesSelectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.shoesSelectapi.model.Shoes;

import java.util.List;

@Repository
public interface ShoesRepo extends JpaRepository<Shoes,Long> {
   @Query("select distinct s.model from Shoes s")
   List<String> getAllModels();

   @Query("select s from Shoes s where s.model=?1")

    List<Shoes>getAllShoesByModel(String model);

}
