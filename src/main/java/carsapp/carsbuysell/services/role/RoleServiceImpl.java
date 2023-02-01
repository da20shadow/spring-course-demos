package carsapp.carsbuysell.services.role;

import carsapp.carsbuysell.repositories.RoleRepository;
import carsapp.carsbuysell.services.init.DbInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService, DbInitService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInitialized() {
        return this.roleRepository.count() > 0;
    }
}
