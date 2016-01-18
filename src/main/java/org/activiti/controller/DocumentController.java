package org.activiti.controller;

import java.util.HashMap;
import java.util.Map;

import org.activiti.cargo.DocumentCargo;
import org.activiti.cargo.DocumentRepository;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DocumentController {

    @Autowired
    private RuntimeService runtimeService;
    
    @Autowired
    private DocumentRepository docRepository;
    
    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/documents", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public DocumentCargo ingestDocument(@RequestBody Map<String, String> data) {

        DocumentCargo doc = new DocumentCargo();
        doc.setTitle(data.get("title"));
        doc.setType(data.get("type"));
        
        docRepository.save(doc);
        
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("doc", doc);
        variables.put("input", "MyName");
        ProcessInstance proc =  runtimeService.startProcessInstanceByKey("documentIngestion", variables);
        String docUUID = (String) proc.getProcessVariables().get("docUUID");
        DocumentCargo retDoc = new DocumentCargo();
        retDoc.setUuid(docUUID);
        return retDoc;
    }
}
