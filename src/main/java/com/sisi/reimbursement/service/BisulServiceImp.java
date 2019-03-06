package com.sisi.reimbursement.service;

import com.sisi.reimbursement.model.BisulModel;
import com.sisi.reimbursement.repository.BisulDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BisulServiceImp implements BisulService {

    @Autowired
    BisulDb bisulDb;

    @Override
    public void addBisul(BisulModel bisul) {
        bisulDb.save(bisul);
    }

    @Override
    public BisulModel getBisulById(long id) {
        return bisulDb.findById(id);
    }

    @Override
    public List<BisulModel> getBisulList() {
        return bisulDb.findAll();
    }

    @Override
    public void deleteBisul(long id) {
        bisulDb.deleteById(id);
    }

    @Override
    public BisulModel getBisulDetailById(long id) {
        return bisulDb.findById(id);
    }

    @Override
    public List<BisulModel> getAllBisul() {
        return bisulDb.findAll();
    }
}
