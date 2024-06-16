package org.launchcode.techjobs.persistent.models.data;
import org.launchcode.techjobs.persistent.models.Employer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//TASK 2
@Repository
public interface EmployerRepository extends CrudRepository<Employer, Integer> {
} //2 PARAMS: ENTITY TYPE & ID
  //<Employer, Integer>
