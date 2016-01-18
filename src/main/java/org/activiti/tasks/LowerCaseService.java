package org.activiti.tasks;

import org.activiti.cargo.DocumentCargo;
import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class LowerCaseService {
	
	   public void convert(DelegateExecution execution) {
	        System.out.println("Converting to lower case ...");
	        
	        String var = (String) execution.getVariable("input");
	        var = var.toLowerCase();
	        execution.setVariable("input", var);
	        
	        DocumentCargo doc = (DocumentCargo) execution.getVariable("doc");
	        System.out.println("Doc type ="+doc.getType());
	    }
}
