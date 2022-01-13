package com.rich.service

import com.rich.entity.TraceModel
import com.rich.repository.TraceModelRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TraceModelServiceImpl implements TraceModelService {

    @Autowired TraceModelRepo repo

    @Override
    void save(TraceModel traceModel) {
        repo.save(traceModel)
    }
}
