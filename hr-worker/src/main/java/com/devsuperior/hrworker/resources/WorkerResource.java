package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.dto.WorkerDTO;
import com.devsuperior.hrworker.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    @Autowired
    private WorkerService workerService;

    //Get all WorkerDTO with variable workerService
    @GetMapping
    public ResponseEntity<List<WorkerDTO>> getAllWorkers(){
        return ResponseEntity.ok().body(workerService.listAllWorker());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WorkerDTO> getWorkerById(@PathVariable Long id){
        return ResponseEntity.ok().body(workerService.findWorkerById(id));
    }
}
