package nz.co.zufang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@ComponentScan(basePackages = {"nz.co.zufang.*"})
@EnableWebMvc
@EnableSwagger2 //Loads the spring beans required by the framework
@PropertySource("classpath:swagger.properties")
//@Import({WebContextConfig.class,JpaConfig.class})
public class AppConfig {
	
    @Bean
    ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
        "Properties Rental APIs",
        "Draft version of the Properties Rental APIs",
        "1.0.0",
        null,
        "lillian.cheng2012@gmail.com",
        null,
        null );
        return apiInfo;
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2).pathMapping("").apiInfo(apiInfo());
    }

}