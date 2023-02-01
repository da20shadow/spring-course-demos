package carsapp.carsbuysell.services.offer;

import carsapp.carsbuysell.repositories.OfferRepository;
import carsapp.carsbuysell.services.init.DbInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl implements OfferService, DbInitService {

    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInitialized() {
        return this.offerRepository.count() > 0;
    }
}
