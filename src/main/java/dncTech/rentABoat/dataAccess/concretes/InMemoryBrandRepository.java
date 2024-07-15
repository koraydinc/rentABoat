package dncTech.rentABoat.dataAccess.concretes;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import dncTech.rentABoat.dataAccess.abstracts.BrandRepository;
import dncTech.rentABoat.entities.concretes.Brand;

@Repository
public class InMemoryBrandRepository implements BrandRepository {

	List<Brand> brands;	
	
	public InMemoryBrandRepository() {
		this.brands = new ArrayList<Brand>();
		brands.add(new Brand(1, "Ferretti"));
		brands.add(new Brand(2, "Azimut Yachts"));
		brands.add(new Brand(3, "Boston Whaler"));
		brands.add(new Brand(4, "Princess"));
	}

	@Override
	public List<Brand> getAll() {
		return brands;
	}
}
