package ro.mycode.shoesSelectapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.shoesSelectapi.model.Shoes;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ShoesRepo extends JpaRepository<Shoes, Long> {
    @Query("select distinct s.model from Shoes s")
    List<String> getAllModels();

    @Query("select s from Shoes s where s.model=?1")
    List<Shoes> getAllShoesByModel(String model);

    @Transactional
    @Modifying
    @Query("delete from Shoes s where s.model like ?1")
    void deleteShoesByModel(String model);

    @Transactional
    @Modifying
    @Query("delete from Shoes s where s.id=?1")
    void deleteById(int id);

    Shoes findByModel(String model);

    @Transactional
    @Modifying
    @Query("select  distinct  s from Shoes s order by  s.pret")
    List<Shoes>sortByPrice();

    @Transactional
    @Modifying
    @Query("select  distinct  s from Shoes s order by  s.material")
    List<Shoes>sortByMaterial();

    @Transactional
    @Modifying
    @Query("select distinct s from Shoes s order by  s.culoare")
    List<Shoes>sortByCuloare();

    @Transactional
    @Modifying
    @Query("select distinct  s from Shoes s order by s.model")
    List<Shoes>sortByModel();

}
