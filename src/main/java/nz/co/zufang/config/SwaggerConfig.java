package nz.co.zufang.config;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

import com.fasterxml.classmate.TypeResolver;

import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.WildcardType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.GrantType;
import springfox.documentation.service.ImplicitGrant;
import springfox.documentation.service.LoginEndpoint;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

//	@Value("${swagger.oauth.url}")
//	private String swaggerOAuthUrl;

	@Autowired
	private TypeResolver typeResolver;

	@Bean
	ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Properties Rental APIs", "Draft version of the Properties Rental APIs", "1.0.0",
				null, "lillian.cheng2012@gmail.com", null, null);
		return apiInfo;
	}

	@Bean
	public Docket rentApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("nz.co.zufang.controller")).paths(PathSelectors.any()).build()
				.pathMapping("/")
				// .ignoredParameterTypes(MetaClass.class)
				.directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
				.alternateTypeRules(newRule(
						typeResolver.resolve(DeferredResult.class,
								typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
						typeResolver.resolve(WildcardType.class)))
				.useDefaultResponseMessages(false).globalResponseMessage(RequestMethod.GET, getBadRequestContent())
				.globalResponseMessage(RequestMethod.POST, getBadRequestContent())
				.globalResponseMessage(RequestMethod.DELETE, getBadRequestContent()).enableUrlTemplating(false);
				// .securitySchemes(newArrayList(apiKey()))
//				.securitySchemes(newArrayList(oauth2()));
		
	}

//	@Bean
//	SecurityScheme oauth2() {
//		return new OAuthBuilder().name("oauth2").grantTypes(grantTypes()).scopes(scopes()).build();
//	}
//	
//	List<AuthorizationScope> scopes() {
//        return newArrayList(new AuthorizationScope("entity.read","Read access on entity in my new API"));
//    }
//
//	List<GrantType> grantTypes() {
//		ImplicitGrant implicitGrant = new ImplicitGrant(new LoginEndpoint(swaggerOAuthUrl), "access_code");
//
//		return newArrayList(implicitGrant);
//	}

	// @Bean
	// SecurityConfiguration security() {
	// return new SecurityConfiguration(
	// "test-app-client-id",
	// "test-app-client-secret",
	// "test-app-realm",
	// "test-app",
	// "apiKey",
	// ApiKeyVehicle.HEADER,
	// "api_key",
	// "," /*scope separator*/);
	// }

	// private ApiKey apiKey() {
	// return new ApiKey("Authorization", "Basic
	// bXktdHJ1c3RlZC1jbGllbnQ6c2VjcmV0", "header");
	// }

	private List<ResponseMessage> getBadRequestContent() {
		return newArrayList(new ResponseMessageBuilder().code(500)
				.message("When the API encounters an unexpected exception").build());
	}

}