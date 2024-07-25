package dncTech.rentABoat.business.abstracts;

import java.util.List;

import dncTech.rentABoat.business.requests.CreateBrandRequest;
import dncTech.rentABoat.business.responses.GetAllBrandsResponse;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
}
