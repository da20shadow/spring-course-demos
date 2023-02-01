package carsapp.carsbuysell.services.model;

import carsapp.carsbuysell.repositories.ModelRepository;
import carsapp.carsbuysell.services.init.DbInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService, DbInitService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInitialized() {
        return this.modelRepository.count() > 0;
    }
}
