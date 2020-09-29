package br.com.driw.fallenangel.api;

import org.springframework.http.HttpStatus;

public class ApiUtils {

	public static HttpStatus parseHttpStatus(Object object) {
		if (!(object instanceof ImHttpStatus)) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}

		return ((ImHttpStatus) object).getHttpStatus();
	}
}
