package dncTech.rentABoat.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dncTech.rentABoat.business.abstracts.BrandService;
import dncTech.rentABoat.business.requests.CreateBrandRequest;
import dncTech.rentABoat.business.responses.GetAllBrandsResponse;
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
	public List<GetAllBrandsResponse> getAll() {
		// BusinessRules
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();

		for (Brand brand : brands) {
			GetAllBrandsResponse brandRes = new GetAllBrandsResponse();
			brandRes.setId(brand.getId());
			brandRes.setName(brand.getName());
			brandsResponse.add(brandRes);
		}

		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);
	}

}
