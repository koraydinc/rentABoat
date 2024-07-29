package dncTech.rentABoat.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dncTech.rentABoat.business.abstracts.BrandService;
import dncTech.rentABoat.business.dto.requests.CreateBrandRequest;
import dncTech.rentABoat.business.dto.requests.DeleteBrandRequest;
import dncTech.rentABoat.business.dto.requests.UpdateBrandRequest;
import dncTech.rentABoat.business.dto.responses.GetAllBrandsResponse;
import dncTech.rentABoat.business.core.utilities.mappers.BrandMapper;
import dncTech.rentABoat.dataAccess.abstracts.BrandRepository;
import dncTech.rentABoat.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private final BrandRepository brandRepository;
	private final BrandMapper brandMapper;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		List<Brand> brands = brandRepository.findAll();
		return brandMapper.brandsToGetAllBrandsListResponses(brands);
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Optional<Brand> optionalBrand = brandRepository.findByName(createBrandRequest.getName());
		if (!optionalBrand.isPresent()) {
			brandRepository.save(brandMapper.createBrand(createBrandRequest));
		}
	}

	@Override
	public List<GetAllBrandsResponse> getByName(String name) {
		Optional<List<Brand>> optionalBrand = brandRepository.findByNameContaining(name);
		if (optionalBrand.isPresent()) {
			List<Brand> brands = optionalBrand.get();
			return brandMapper.brandsToGetAllBrandsListResponses(brands);
		}

		return null;
	}

	@Override
	public void delete(DeleteBrandRequest deleteBrandRequest) {
			brandRepository.delete(brandMapper.deleteBrand(deleteBrandRequest));	
	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {	
		brandRepository.save(brandMapper.updateBrand(updateBrandRequest));
	}

}
