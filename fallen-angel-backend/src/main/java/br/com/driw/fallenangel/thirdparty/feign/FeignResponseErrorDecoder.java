package br.com.driw.fallenangel.thirdparty.feign;

import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignResponseErrorDecoder implements ErrorDecoder {
	@Override
	public Exception decode(String s, Response response) {
		return null;
	}
}
