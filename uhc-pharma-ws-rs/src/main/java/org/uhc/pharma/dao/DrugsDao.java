package org.uhc.pharma.dao;

import java.math.BigInteger;
import java.util.List;

import org.uhc.pharma.model.DrugsBean;

public interface DrugsDao {
	
	List<DrugsBean> findAllDrugs();
	DrugsBean findDrug(int id);
	int save(DrugsBean drug);
	void update(DrugsBean drug);
	void delete(int id);
	List<DrugsBean> findDrugsByFiltering(String company,String name);
	
	
 
}
