package com.liluppis.portfolioAPI.project.controller;

import com.liluppis.portfolioAPI.project.dto.ProjectCreationDTO;
import com.liluppis.portfolioAPI.project.dto.ProjectResponseDTO;
import com.liluppis.portfolioAPI.project.service.ProjectServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    private final ProjectServiceImpl service;

    @Autowired
    public ProjectController(ProjectServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjectResponseDTO>> findById(@PathVariable String id) {
        Optional<ProjectResponseDTO> foundProject = service.getProject(id);
        if (foundProject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(foundProject);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProjectResponseDTO>> findAll() {
        List<ProjectResponseDTO> projects = service.getAllProjects();
        if (projects.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/find/{tag}")
    public ResponseEntity<List<ProjectResponseDTO>> findByTag(@PathVariable String tag) {
        List<ProjectResponseDTO> projects = service.getProjectsByTags(tag);
        if (projects.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/create")
    public ResponseEntity<ProjectResponseDTO> createProject(@Valid @RequestBody ProjectCreationDTO projectDTO) {

        if (projectDTO == null){
            return ResponseEntity.badRequest().build();
        }

        ProjectResponseDTO newProject = service.saveProject(projectDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newProject);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProject(@PathVariable String id, @RequestBody ProjectCreationDTO projectDTO) {

        if (projectDTO == null){
            return ResponseEntity.badRequest().build();
        }

        ProjectResponseDTO updatedProject = service.updateProject(id,  projectDTO);

        return ResponseEntity.ok(updatedProject);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProject(@PathVariable String id) {
        if (service.deleteProject(id)){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
