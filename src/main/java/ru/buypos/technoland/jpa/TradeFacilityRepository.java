package ru.buypos.technoland.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.buypos.technoland.controllers.AddAddTradeFacilityIf;
import ru.buypos.technoland.model.TradeFacility;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface TradeFacilityRepository extends JpaRepository<TradeFacility, Long> {

    boolean existsByName(String name);






//    List<TradeFacility> findAll(String toName);


//    @Query(value = "SELECT u FROM User u where u = s")
//    List<TradeFacility> findAllUsers(String s);


//    @Query("SELECT u FROM User u WHERE u.status = :userName")
//    TradeFacility findByName(@Param("status") String userName);


//    @Query("SELECT t FROM TradeFacility t WHERE t.name = :toName")
//    List<TradeFacility> findByName(@Param("name") String toName);
}