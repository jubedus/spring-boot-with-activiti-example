package org.activiti.tasks;

import org.activiti.cargo.DocumentCargo;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

@Service("constructNameTask")
public class ConstructDocNameTask {
	
    
	   public void process(DelegateExecution execution) {
	        System.out.println("Constructing document name ...");
	        
	        DocumentCargo doc = (DocumentCargo) execution.getVariable("doc");
	        System.out.println("Doc type ="+doc.getType());
	        System.out.println("Doc title ="+doc.getTitle());
	        
	        String docName = doc.getType() + doc.getTitle();
	        doc.setName(docName);
	    }
}
