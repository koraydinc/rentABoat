package dncTech.rentABoat.business.abstracts;

import java.util.List;

import dncTech.rentABoat.entities.concretes.Brand;

public interface BrandService {
	List<Brand> getAll();
}
