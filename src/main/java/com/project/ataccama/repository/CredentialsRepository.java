package com.project.ataccama.repository;

import com.project.ataccama.model.ConnectionDetails;
import org.springframework.data.repository.CrudRepository;

public interface CredentialsRepository extends CrudRepository<ConnectionDetails, String> {
}
