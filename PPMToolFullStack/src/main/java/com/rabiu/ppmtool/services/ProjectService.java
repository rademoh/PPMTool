package com.rabiu.ppmtool.services;

import com.rabiu.ppmtool.domain.Project;
import com.rabiu.ppmtool.exceptions.ProjectIdException;
import com.rabiu.ppmtool.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Rabiu Ademoh
 */

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;


    public Project saveOrUpdateProject(Project project){
        try {
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        } catch (Exception e){
            throw  new ProjectIdException("Project ID '"+project.getProjectIdentifier().toUpperCase()+"' already exists");
        }
    }

    public Project findProjectByIdentifier(String projectId){

        Project project = projectRepository.findByProjectIdentifier(projectId.toUpperCase());
        if(project == null){
            throw  new ProjectIdException("Project ID '"+projectId+"' doesn't exists");
        }
        return project;
    }

    public Iterable<Project> findAllProjects(){
        return projectRepository.findAll();
    }

    public void deleteProjectByIdentifier(String projectId){
        Project project = projectRepository.findByProjectIdentifier(projectId);
        if(project == null){
            throw  new ProjectIdException("Cannot Delete Project with ID'"+projectId+"' doesn't exists");
        }
        projectRepository.delete(project);
    }

}
