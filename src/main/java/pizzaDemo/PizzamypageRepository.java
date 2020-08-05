package pizzaDemo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PizzamypageRepository extends CrudRepository<Pizzamypage, Long> {

    List<Pizzamypage> findByPizzaId(String pizzaId);

}