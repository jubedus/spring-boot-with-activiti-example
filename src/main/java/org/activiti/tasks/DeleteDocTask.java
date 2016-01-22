package org.activiti.tasks;

import org.activiti.cargo.DocumentCargo;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deleteDocTask")
public class DeleteDocTask {
	
    @Autowired
    private DocumentService docService;
    
	   public void process(DelegateExecution execution) {
	        System.out.println("Deleting document ...");
	        
	        DocumentCargo doc = (DocumentCargo) execution.getVariable("doc");
	        System.out.println("Doc type ="+doc.getType());
	        
	        docService.deleteDocument(doc);
	    }
}
