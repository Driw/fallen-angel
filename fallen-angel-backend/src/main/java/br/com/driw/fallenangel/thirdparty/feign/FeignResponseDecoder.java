package br.com.driw.fallenangel.thirdparty.feign;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

public class FeignResponseDecoder implements Decoder {
	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
		return null;
	}
}
