package dncTech.rentABoat.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dncTech.rentABoat.business.abstracts.BrandService;
import dncTech.rentABoat.business.dto.requests.CreateBrandRequest;
import dncTech.rentABoat.business.dto.requests.DeleteBrandRequest;
import dncTech.rentABoat.business.dto.requests.UpdateBrandRequest;
import dncTech.rentABoat.business.dto.responses.GetAllBrandsResponse;
import dncTech.rentABoat.dataAccess.abstracts.BrandRepository;
import dncTech.rentABoat.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private final BrandRepository brandRepository;

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
		Optional<Brand> optionalBrand = brandRepository.findByName(createBrandRequest.getName());
		if (!optionalBrand.isPresent()) {
			Brand brand = new Brand();
	        brand.setName(createBrandRequest.getName());
	        brandRepository.save(brand);
		}
	}

	@Override
	public List<GetAllBrandsResponse> getByName(String name) {
		List<Brand> brands = brandRepository.findByNameContaining(name);
		return brands.stream().map(brand -> {
			GetAllBrandsResponse response = new GetAllBrandsResponse();
			response.setId(brand.getId());
			response.setName(brand.getName());
			return response;
		}).collect(Collectors.toList());
	}

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		Optional<Brand> optionalBrand = brandRepository.findByName(deleteBrandRequest.getName());
		if (optionalBrand.isPresent()) {
			Brand brand = optionalBrand.get();
			brandRepository.delete(brand);
		}
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Optional<Brand> optionalBrand = brandRepository.findByName(updateBrandRequest.getName());
		if (optionalBrand.isPresent()) {
			Brand brand = optionalBrand.get();
			brand.setName(updateBrandRequest.getNewName());
			brandRepository.save(brand);
		}

	}

}
