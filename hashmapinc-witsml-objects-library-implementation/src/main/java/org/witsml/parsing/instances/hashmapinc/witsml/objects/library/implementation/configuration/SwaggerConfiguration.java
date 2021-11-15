package org.witsml.parsing.instances.hashmapinc.witsml.objects.library.implementation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * The type Swagger configuration.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    /**
     * Gets product api.
     *
     * @return the product api
     */
    @Bean(name = "productApi")
    public Docket getProductApi() {
        Docket apiDocket = new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        "org.witsml.parsing.instances.hashmapinc.witsml.objects.library.implementation.controller"
                ))
                .paths(regex("/.*"))
                .build();
                //.apiInfo(metaData());

        return apiDocket;
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("VTD AI PROCESSING API")
                .description("Сервис-аггрегатор для рабоыт с сервисами ИИ")
                .version("0.1.0")
                .contact(new Contact(
                        "[VTD BACK]: Alexander A. Kropotin",
                        "https://university.innopolis.ru",
                        "a.kropotin@innopolis.ru"))
                .build();
    }
}
