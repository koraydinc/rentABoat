package dncTech.rentABoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dncTech.rentABoat.business.abstracts.BrandService;
import dncTech.rentABoat.dataAccess.abstracts.BrandRepository;
import dncTech.rentABoat.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {
	
	private BrandRepository brandRepository;
	
	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> getAll() {
		//BusinessRules
		return brandRepository.getAll();
	}

}
