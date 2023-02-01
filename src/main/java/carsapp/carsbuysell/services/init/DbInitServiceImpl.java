package carsapp.carsbuysell.services.init;

import org.springframework.stereotype.Service;

@Service
public class DbInitServiceImpl implements DbInitService {
    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInitialized() {
        return false;
    }
}
