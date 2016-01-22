package org.activiti.tasks;

import org.activiti.cargo.DocumentCargo;
import org.activiti.engine.delegate.BpmnError;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("s1CreateTask")
public class InsertS1Task {
	
    @Autowired
    private DocumentService docService;
    
	   public String process(DelegateExecution execution) {
	        System.out.println("Importing into S1 ...");
	        
	        DocumentCargo doc = (DocumentCargo) execution.getVariable("doc");
	        System.out.println("Doc type ="+doc.getType());
	        
	        String docUUID = (String) execution.getVariable("docUUID");	        
	        System.out.println("Doc UUID ="+docUUID);
	        
	        if("invalidS1".equalsIgnoreCase(doc.getType())){
	        	 System.out.println("Failed import into S1");
	        	throw new BpmnError("S1ImportFailed");
	        }else{
	        	 return docService.insertIntoS1(doc);
	        }
	    }
}
