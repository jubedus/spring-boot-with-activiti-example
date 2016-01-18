package org.activiti.cargo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<DocumentCargo, Long> {

}