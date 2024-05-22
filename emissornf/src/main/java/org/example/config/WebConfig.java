package org.example.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import org.example.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
	private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("application/x-yaml");
	
	
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}
	
	//método para tornar o CORS global para todas as classes do projeto sem necessidade de especificar por classe
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**") // por padrão, especificaria apenas GET POST PUT DELETE
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "PATCH", "TRACE", "CONNECT"); // parametro adicionado para suportar demais verbos
	}	
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

//		configuração realizada para indicar o midia type via Extensão (pathExtension)! Ex: /api/person/v1/listAll.json
//		carrega favorParameter false para ignorar o tipo de midia por parametro

		/*configurer
			.favorParameter(false)
			.ignoreAcceptHeader(false)
			.defaultContentType( MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML);
		*/
		
		
//		configuração realizada para indicar o midia type via QUERY Parameter. Ex: /api/person/v1/listAll?mediaType=xml
//		favorPathExtension false adicionado para não passar por path o midia type e gerar conflito
//		favorParameter recebe true
//		adicionados também useRegisteredExtensionsOnly(false) e ignoreAcceptHeader(false)
		
		/*configurer
			.favorPathExtension(false)
			.favorParameter(true)
			.parameterName("mediaType")
			.ignoreAcceptHeader(true)
			.useRegisteredExtensionsOnly(false)
			.defaultContentType( MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML);
		*/
	
	
//		configuração realizada para indicar o midia type via HEADER Parameter. Ex: /api/person/v1/listAll
//		no HEADER da requisição utilizar o parêmtro/chave/key: Accept e em seu value: "application/xml" ou "application/json" etc
		
		configurer
		.favorPathExtension(false)
		.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType( MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIA_TYPE_YAML); //adicionado para compatibilidade com estrututra YAML
		
	}
	
}
