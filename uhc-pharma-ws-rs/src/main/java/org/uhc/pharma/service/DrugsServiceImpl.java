package org.uhc.pharma.service;

import java.math.BigInteger;
import java.util.List;

import org.uhc.pharma.dao.DrugsDao;
import org.uhc.pharma.dao.DrugsDaoImpl;
import org.uhc.pharma.exceptions.DataNotFoundException;
import org.uhc.pharma.model.DrugsBean;

public class DrugsServiceImpl implements DrugsService {
	private DrugsDao dao = new DrugsDaoImpl();
	@Override
	public List<DrugsBean> getAllDrugs() {
		
		return dao.findAllDrugs();
	}

	@Override
	public DrugsBean getDrugById(int id) {
		
		DrugsBean drug = dao.findDrug(id);
		if(drug==null){
			throw new DataNotFoundException("Data not found for Drug Id :" + id);
		}
		return drug;
	}

	@Override
	public int addDrug(DrugsBean drug) {
		
		return dao.save(drug);
	}

	@Override
	public void modifyDrug(DrugsBean drug) {
		try{
		dao.update(drug);
		}
		catch(Exception ex){
			throw new DataNotFoundException("Can't update the Drug with Id : " + drug.getId());
		}
		
	}

	@Override
	public void removeDrug(int id) {
		dao.delete(id);

	}

	@Override
	public List<DrugsBean> getDrugsByCondition(String company, String name) {
		
		return dao.findDrugsByFiltering(company, name);
	}

}
