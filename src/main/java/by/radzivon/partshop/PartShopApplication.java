package by.radzivon.partshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
public class PartShopApplication {

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:validationMessages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    public static void main(String[] args) {
        SpringApplication.run(PartShopApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init(PartRepository repository, PhotoRepository photoRepository, StockRepository stockRepository, CommentRepository commentRepository) {
//        return args -> {
//            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
//                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
//                Comment comment = Comment.builder()
//                        .text("comment")
//                        .build();
//                Photo photo = Photo.builder()
//                        .dateOfDownload(new Date())
//                        .imageUrl("https://images.unsplash.com/photo-1534067783941-51c9c23ecefd?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80")
//                        .comments(Set.of(
//                                comment
//                        ))
//                        .part(Part.builder()
//                                .id(1L)
//                                .build())
//                        .build();
////                photoRepository.save(photo);
////                comment.setPhoto(photo);
////                commentRepository.save(comment);
//                Stock stock = Stock.builder()
//                        .stock(10)
//                        .part(Part.builder()
//                                .id(1L)
//                                .build())
//                        .build();
//                Brand brand = Brand.builder()
//                        .name(name)
//                        .parts(Set.of(Part.builder()
//                                .id(1L)
//                                .build()))
//                        .build();
//                Part car = Part.builder()
//                        .brand(brand)
//                        .category("Engine")
//                        .condition(PartCondition.USED)
//                        .description("description")
//                        .model("model")
//                        .price(new BigDecimal(100))
//                        .realiseDate(new Date())
//                        .photos(Set.of(photo))
//                        .stock(stock)
//                        .build();
//                repository.save(car);
//                stock.setPart(car);
//                stockRepository.save(stock);
//                photo.setPart(car);
//                photoRepository.save(photo);
//            });
//        };
//    }
}
