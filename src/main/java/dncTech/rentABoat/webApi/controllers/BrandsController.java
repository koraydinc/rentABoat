package dncTech.rentABoat.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dncTech.rentABoat.business.abstracts.BrandService;
import dncTech.rentABoat.business.dto.requests.CreateBrandRequest;
import dncTech.rentABoat.business.dto.requests.DeleteBrandRequest;
import dncTech.rentABoat.business.dto.requests.UpdateBrandRequest;
import dncTech.rentABoat.business.dto.responses.GetAllBrandsResponse;

@RestController //annotation
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	};
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	};
	
	@PostMapping("/add")
	public void add(CreateBrandRequest createBrandRequest) {
		brandService.add(createBrandRequest);
	};
	
	@GetMapping("/getallbyname")
	public List<GetAllBrandsResponse> getByName(String name){
		return brandService.getByName(name);
	};
	
	@PostMapping("/update")
	public void update(UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
	};
	
	@PostMapping("/delete")
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		brandService.delete(deleteBrandRequest);
	};
}
