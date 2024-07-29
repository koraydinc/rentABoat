package dncTech.rentABoat.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dncTech.rentABoat.business.abstracts.BrandService;
import dncTech.rentABoat.business.dto.requests.CreateBrandRequest;
import dncTech.rentABoat.business.dto.requests.DeleteBrandRequest;
import dncTech.rentABoat.business.dto.requests.UpdateBrandRequest;
import dncTech.rentABoat.business.dto.responses.GetAllBrandsResponse;
import lombok.AllArgsConstructor;

@RestController //annotation
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;
	
	@GetMapping("/getall")
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	};
	
	@PostMapping("/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(CreateBrandRequest createBrandRequest) {
		brandService.add(createBrandRequest);
	};
	
	@GetMapping("/getallbyname")
	public List<GetAllBrandsResponse> getByName(String name){
		return brandService.getByName(name);
	};
	
	@PutMapping("/update")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
	};
	
	@DeleteMapping("/delete")
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(DeleteBrandRequest deleteBrandRequest) {
		brandService.delete(deleteBrandRequest);
	};
}
