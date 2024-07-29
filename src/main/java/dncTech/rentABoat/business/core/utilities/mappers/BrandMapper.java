package dncTech.rentABoat.business.core.utilities.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import dncTech.rentABoat.business.dto.requests.CreateBrandRequest;
import dncTech.rentABoat.business.dto.requests.DeleteBrandRequest;
import dncTech.rentABoat.business.dto.requests.UpdateBrandRequest;
import dncTech.rentABoat.business.dto.responses.GetAllBrandsResponse;
import dncTech.rentABoat.entities.concretes.Brand;

@Mapper(componentModel = "spring")
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    GetAllBrandsResponse brandToGetAllBrandResponse(Brand brand);
    List<GetAllBrandsResponse> brandsToGetAllBrandsListResponses(List<Brand> brands);
    
    Brand createBrand(CreateBrandRequest createBrandRequest);
    Brand updateBrand(UpdateBrandRequest updateBrandRequest);
    Brand deleteBrand(DeleteBrandRequest deleteBrandRequest);
}
