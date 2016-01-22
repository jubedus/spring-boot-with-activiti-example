package org.activiti.tasks;

import org.activiti.cargo.DocumentCargo;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("defaultValuesTask")
public class DefaultValuesTask {
	
    @Autowired
    private DocumentService docService;
    
	   public void process(DelegateExecution execution) {
	        System.out.println("Setting default values ...");
	        
	        DocumentCargo doc = (DocumentCargo) execution.getVariable("doc");
	        System.out.println("Doc type ="+doc.getType());
	        
	        if("invalid".equalsIgnoreCase(doc.getType())){
	        	throw new RuntimeException("Unable to set default value");
	        }else{
	        	docService.setDefaultValues(doc);
	        }
	    }
}
