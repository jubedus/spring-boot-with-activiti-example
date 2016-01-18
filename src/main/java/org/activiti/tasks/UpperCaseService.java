package org.activiti.tasks;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class UpperCaseService {
	
	   public void convert(DelegateExecution execution) {
	        System.out.println("Converting to upper case ...");
	        
	        String var = (String) execution.getVariable("input");
	        var = var.toUpperCase();
	        execution.setVariable("input", var);
	    }
}
