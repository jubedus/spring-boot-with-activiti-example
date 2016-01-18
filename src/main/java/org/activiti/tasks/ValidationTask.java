package org.activiti.tasks;

import org.activiti.cargo.DocumentCargo;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("validationTask")
public class ValidationTask {
	
    @Autowired
    private DocumentService docService;
    
	   public void process(DelegateExecution execution) {
	        System.out.println("Validating ...");
	        
	        DocumentCargo doc = (DocumentCargo) execution.getVariable("doc");
	        System.out.println("Doc type ="+doc.getType());
	        
	        docService.validate(doc);
	    }
}
