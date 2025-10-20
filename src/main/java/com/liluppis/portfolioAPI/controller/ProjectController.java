package com.liluppis.portfolioAPI.controller;

import com.liluppis.portfolioAPI.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.dto.ProjectResponseDTO;
import com.liluppis.portfolioAPI.mapper.ProjectMapper;
import com.liluppis.portfolioAPI.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectServiceImpl _service;

    @Autowired
    public ProjectController(ProjectServiceImpl service) {
        _service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjectResponseDTO>> findById(@PathVariable String id) {
        Optional<ProjectResponseDTO> foundProject = _service.getProject(id);
        if (foundProject.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(foundProject);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProjectResponseDTO>> findAll() {
        List<ProjectResponseDTO> projects = _service.getAllProjects();
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/find/{tag}")
    public ResponseEntity<List<ProjectResponseDTO>> findByTag(@PathVariable String tag) {
        List<ProjectResponseDTO> projects = _service.getProjectsByTags(tag);
        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectResponseDTO> createProject(@RequestBody ProjectCreationDTO projectDTO) {
        if (projectDTO == null){
            return ResponseEntity.badRequest().build();
        }

        ProjectResponseDTO newProject = _service.saveProject(projectDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
    }

    @PutMapping("/update")
    public ResponseEntity<ProjectResponseDTO> updateProject(@RequestBody ProjectCreationDTO projectDTO) {
        if (projectDTO == null){
            return ResponseEntity.badRequest().build();
        }

        return null;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProjectResponseDTO> deleteProject(@PathVariable String id) {
        return null;
    }
}
