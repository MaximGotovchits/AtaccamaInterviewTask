package com.project.ataccama.repository;

import com.project.ataccama.model.ConnectionDetails;
import org.springframework.data.repository.CrudRepository;

public interface ConnectionRepository extends CrudRepository<ConnectionDetails, String> {
}
