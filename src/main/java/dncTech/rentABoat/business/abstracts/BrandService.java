package dncTech.rentABoat.business.abstracts;

import java.util.List;

import dncTech.rentABoat.business.dto.requests.CreateBrandRequest;
import dncTech.rentABoat.business.dto.requests.DeleteBrandRequest;
import dncTech.rentABoat.business.dto.requests.UpdateBrandRequest;
import dncTech.rentABoat.business.dto.responses.GetAllBrandsResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	List<GetAllBrandsResponse> getByName(String name);
	void add(CreateBrandRequest createBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
}
