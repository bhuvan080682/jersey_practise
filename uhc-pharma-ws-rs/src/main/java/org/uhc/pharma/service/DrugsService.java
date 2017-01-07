package org.uhc.pharma.service;

import java.math.BigInteger;
import java.util.List;

import org.uhc.pharma.model.DrugsBean;

public interface DrugsService {
	
	 List<DrugsBean> getAllDrugs();
	 DrugsBean getDrugById(int id);
	 int addDrug(DrugsBean drug);
	 void modifyDrug(DrugsBean drug);
	 void removeDrug(int id);
	 List<DrugsBean> getDrugsByCondition(String company,String name);

}
