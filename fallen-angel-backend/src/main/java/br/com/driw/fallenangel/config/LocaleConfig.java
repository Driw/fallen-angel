package br.com.driw.fallenangel.config;

import org.springframework.context.annotation.Bean;

public class LocaleChangeInterceptor {

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		lci.setParamName("lang");
		return lci;
	}

}
