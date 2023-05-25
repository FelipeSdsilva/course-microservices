package com.devsuperior.hrworker.services;

import com.devsuperior.hrworker.dto.WorkerDTO;
import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import com.devsuperior.hrworker.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Transactional(readOnly = true)
    public List<WorkerDTO> listAllWorker() {
        return workerRepository.findAll().stream().map(WorkerDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public WorkerDTO findWorkerById(Long id) {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        return new WorkerDTO(worker);
    }
}
