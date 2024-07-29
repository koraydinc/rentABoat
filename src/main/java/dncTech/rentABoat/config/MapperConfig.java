package dncTech.rentABoat.config;

import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dncTech.rentABoat.business.core.utilities.mappers.BrandMapper;

@Configuration
public class MapperConfig {
    @Bean
    public BrandMapper brandMapper() {
        return Mappers.getMapper(BrandMapper.class);
    }
}
