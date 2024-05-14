package com.school.management.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.management.dto.ResponseDTO;

import com.school.management.entity.School;

import com.school.management.repository.SchoolRepository;

@Service
public class SchoolService {
   
	@Autowired
	private SchoolRepository schoolrepository;
	
//	public List<ResponseDTO> retrieveSchool()
//	{
//		List<SchoolEntity> data = this.schoolrepository.findAll();
//		List<ResponseDTO> resList = new ArrayList<ResponseDTO>();
//		for(SchoolEntity school : data) {
//			ResponseDTO temp = new ResponseDTO();
//			temp.setId(school.getId());
//			temp.setName(school.getName());
//			resList.add(temp);
//		}
//		return resList;
//	}
	public List<School> retrieveSchool(){
		return this.schoolrepository.findAll();
	}
	public Optional<School> retrieveSingleSchool(Long id)
	{
		return this.schoolrepository.findById(id);
	}
	
	public School addSchool(final School schoolentity)
	{
		return this.schoolrepository.save(schoolentity);
	}
	
	public String deleteSchool(Long id)
	{
		//long schoolId = Long.parseLong(id);
	   // this.schoolrepository.deleteById(schoolId);	
		this.schoolrepository.deleteById(id);
		return "Deleted Sucessfully";
	}
	
//	public String updateSchool(Long id,SchoolEntity school)
//	{
//		Optional<SchoolEntity> existingSchoolOptional = schoolrepository.findById(id);
//		SchoolEntity existingSchool = existingSchoolOptional.get();
//		
//		existingSchool.setName(school.getName());
//		existingSchool.setAddress_1(school.getAddress_1());
//		existingSchool.setAddress_2(school.getAddress_2());
//		schoolrepository.save(existingSchool);
//	    return "Edited Successfully";
//	}
	public School updateSchool(Long id, School school) throws AccountNotFoundException {
//	    Optional<School> existingSchoolOptional = schoolrepository.findById(id);
//	    if (existingSchoolOptional.isPresent()) {
//	    	School existingSchool = existingSchoolOptional.get();
//	        existingSchool.setName(school.getName());
//	        existingSchool.setAddress_1(school.getAddress_1());
//	        existingSchool.setAddress_2(school.getAddress_2());
//	        schoolrepository.save(existingSchool);
//	        return "Edited Successfully";
//	    } else {
//	        return "School with ID " + id + " not found";
//	    }
		
		 Optional<School> existingSchool = schoolrepository.findById(id);
		 if(existingSchool.isEmpty()) {
			 throw new AccountNotFoundException("User not found");
		 }
		 
		 School finalSchool = existingSchool.orElseThrow(); 
		 
		if(school.getName()!=null) {
			finalSchool.setName(school.getName());
		}
		if(school.getAddress_1()!=null) {
			finalSchool.setAddress_1(school.getAddress_1());
		}
		if(school.getAddress_2()!=null) {
			finalSchool.setAddress_2(school.getAddress_2());
		}
		
		return this.schoolrepository.saveAndFlush(finalSchool);
	}
}
