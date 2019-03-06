package com.sisi.reimbursement.service;

import com.sisi.reimbursement.model.BisulModel;

import java.util.List;

public interface BisulService {
    void addBisul(BisulModel bisul);

    BisulModel getBisulById(long id);

    List<BisulModel> getBisulList();

    void deleteBisul(long id);

    BisulModel getBisulDetailById(long id);

    List<BisulModel> getAllBisul();


}
