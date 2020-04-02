package by.radzivon.partshop.config;

import by.radzivon.partshop.dto.*;
import by.radzivon.partshop.entity.*;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MappingConfig {

    @Bean
    public BeanMappingBuilder beanMappingBuilder() {
        return new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Brand.class, BrandDto.class);
                mapping(Comment.class, CommentDto.class)
                        .fields("photo.id", "photoId");
                mapping(Order.class, OrderDto.class)
                        .fields("user.id", "userId");
                mapping(PairPartQuantity.class, PairPartQuantityDto.class)
                        .fields("order.id", "orderId")
                        .fields("part.id", "orderId");
                mapping(Part.class, PartDto.class)
                        .fields("brand.id", "brandId")
                        .fields("stock.id", "stockId");
                mapping(Photo.class, PhotoDto.class)
                        .fields("part.id", "partId");

                mapping(Stock.class, StockDto.class)
                        .fields("part.id", "partId");
                mapping(User.class, UserDto.class);
            }
        };
    }

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        dozerBeanMapper.addMapping(beanMappingBuilder());
        return dozerBeanMapper;
    }
}
