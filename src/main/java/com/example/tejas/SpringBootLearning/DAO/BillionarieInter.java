package com.example.tejas.SpringBootLearning.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BillionarieInter extends CrudRepository<Billionaire,Long> {
	

}
