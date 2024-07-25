package dncTech.rentABoat.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import dncTech.rentABoat.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
}
