package dncTech.rentABoat.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dncTech.rentABoat.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
	Optional<Brand> findByName(String name);
	List<Brand> findByNameContaining(String name);
}
