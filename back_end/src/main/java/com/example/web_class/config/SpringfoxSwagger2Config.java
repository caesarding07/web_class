package com.example.web_class.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

/**
*@ClassName: SpringfoxSwagger2Config
*@Description swagger配置文件
*@Author CaesarDing
*@Date 2020/11/15
*@Time 14:41
*/
@Configuration
@EnableSwagger2
//包扫描，在此包下的Controller都会被纳入swagger接口文档生成的范围，这里也可以配置类扫描，同时也可以在这个配置类里面细化过滤规则
@ComponentScan(basePackages = "com.example.web_class.controller")
public class SpringfoxSwagger2Config {
    //组织Docket对象，翻译过来就是摘要的意思，它是生成API文档的核心对象，里面配置一些必要的信息
    @Bean
    public Docket swaggerSpringMvcPlugin(){
        //指定规范，这里是SWAGGER_2
        return new Docket(DocumentationType.SWAGGER_2)
                //设定Api文档头信息，这个信息会展示在文档UI的头部位置
                .apiInfo(swaggerDemoApiInfo())
                .select()
                //添加过滤条件，谓词过滤predicate，这里是自定义注解进行过滤
                //.apis(not(withMethodAnnotation(SwaggerCustomIgnore.class)))
                //这里配合@ComponentScan一起使用，又再次细化了匹配规则(当然，我们也可以只选择@ComponentScan、paths()方法当中的一中)
//                .paths(allowPaths())
                .build();
    }
    /**
    *@Author CaesarDing
    *@Description 自定义API文档基本信息实体
    *@Date 2020/11/15
    *@Time 14:52
    *@Param []
    *@Return com.google.common.base.Predicate<java.lang.String>
    *@MethodName: allowPaths
    */
    private ApiInfo swaggerDemoApiInfo() {
        //构建联系实体，在UI界面会显示
        Contact contact = new Contact("web_class", "http://caesarding.space", "caesarding07@gmail.com");
        return new ApiInfoBuilder()
                //联系人信息
                .contact(contact)
                //文档标题
                .title("WebClass")
                //文档描述
                .description("WebClass API document 2020.11")
                //文档版本
                .version("1.0.0")
                .build();
    }
    /**
    *@Author CaesarDing
    *@Description PATH匹配规则
    *@Date 2020/11/15
    *@Time 14:55
    *@Param []
    *@Return com.google.common.base.Predicate<java.lang.String>
    *@MethodName: allowPaths
    */
    private Predicate<String> allowPaths() {
        return or(
                PathSelectors.regex("/api/user/*")
        );
    }
}
