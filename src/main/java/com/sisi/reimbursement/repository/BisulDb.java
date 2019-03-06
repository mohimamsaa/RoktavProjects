package com.sisi.reimbursement.repository;

import com.sisi.reimbursement.model.BisulModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BisulDb extends JpaRepository<BisulModel, Long> {
    BisulModel findById (long id);
    BisulModel deleteById (long id);
}
