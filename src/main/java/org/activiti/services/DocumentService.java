package org.activiti.services;

import org.activiti.cargo.DocumentCargo;
import org.springframework.stereotype.Service;

@Service("documentService")
public class DocumentService {

	public void validate(DocumentCargo doc){
		System.out.println("Validating in service ...");
	}
	
	public void setDefaultValues(DocumentCargo doc){
		System.out.println("Setting default values in service ...");
	}
	
	public String importIntoEDM(DocumentCargo doc){
		System.out.println("Importing in service ...");
		doc.setUuid("12");
		return "12";
	}
	
	public String insertIntoS1(DocumentCargo doc){
		System.out.println("Importing into S1 in service ...");
		return "ab";
	}
}
