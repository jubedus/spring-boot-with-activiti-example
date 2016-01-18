package org.activiti.tasks;

import org.activiti.cargo.DocumentCargo;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ingestionTask")
public class ImportDocTask {
	
    @Autowired
    private DocumentService docService;
    
	   public String process(DelegateExecution execution) {
	        System.out.println("Importing ...");
	        
	        DocumentCargo doc = (DocumentCargo) execution.getVariable("doc");
	        System.out.println("Doc type ="+doc.getType());
	        
	        return docService.importIntoEDM(doc);
	    }
}
