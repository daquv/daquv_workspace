package com.daquv.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daquv.Repository.IndexRepository;


@Service
public class IndexService {

	@Autowired
    private IndexRepository indexrepo;
	
	
	
	public String getTest() {
		
		return indexrepo.getTest();
	}

}
