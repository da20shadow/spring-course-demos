package carsapp.carsbuysell.services.brand;

import carsapp.carsbuysell.repositories.BrandRepository;
import carsapp.carsbuysell.services.init.DbInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService, DbInitService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInitialized() {
        return this.brandRepository.count() > 0;
    }
}
