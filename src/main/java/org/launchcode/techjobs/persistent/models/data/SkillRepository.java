package org.launchcode.techjobs.persistent.models.data;
import org.launchcode.techjobs.persistent.models.Skill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//TASK 2
@Repository
public interface SkillRepository extends CrudRepository<Skill, Integer> {
} //2 PARAMS: ENTITY TYPE & ID
