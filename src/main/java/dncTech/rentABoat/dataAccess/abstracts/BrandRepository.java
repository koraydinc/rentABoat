package dncTech.rentABoat.dataAccess.abstracts;

import java.util.List;

import dncTech.rentABoat.entities.concretes.Brand;

public interface BrandRepository {
	List<Brand> getAll();
}
