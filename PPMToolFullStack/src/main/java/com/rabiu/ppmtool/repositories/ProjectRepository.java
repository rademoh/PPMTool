package com.rabiu.ppmtool.repositories;

import com.rabiu.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Rabiu Ademoh
 */

@Repository
public interface ProjectRepository  extends CrudRepository<Project,Long> {


    Project findByProjectIdentifier(String projectId);

    @Override
    Iterable<Project> findAll();
}