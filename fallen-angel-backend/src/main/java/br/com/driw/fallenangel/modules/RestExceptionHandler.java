package br.com.driw.fallenangel.modules;

import br.com.driw.fallenangel.FallenAngel;
import br.com.driw.fallenangel.api.ApiError;
import br.com.driw.fallenangel.api.ApiResponse;
import br.com.driw.fallenangel.api.ApiUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Locale;
import java.util.Optional;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(FallenAngel.class);

	private final MessageSource messageSource;

	@Autowired
	public RestExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler({ ModuleRuntimeException.class })
	public ResponseEntity<ApiResponse<ApiError>> handleModuleRuntimeException(ModuleRuntimeException e) {
		HttpStatus httpStatus = ApiUtils.parseHttpStatus(e);
		String message = getMessageSource(e.getAutoMessageConfig(), e.getArguments());

		return ResponseEntity.status(httpStatus)
			.body(this.generateApiResponse(e, httpStatus, message));
	}

	private String getMessageSource(AutoMessageConfig autoMessageConfig, Object[] arguments) {
		String messageProperty = this.generateMessageProperty(autoMessageConfig);

		return this.messageSource.getMessage(messageProperty, arguments, Locale.getDefault());
	}

	private String generateMessageProperty(AutoMessageConfig autoMessageConfig) {
		if (!autoMessageConfig.getClass().isEnum()) {
			return autoMessageConfig.toString();
		}

		return String.format("%s.%s", autoMessageConfig.getClass().getName(), autoMessageConfig.toString());
	}

	private ApiResponse<ApiError> generateApiResponse(ModuleRuntimeException e, HttpStatus httpStatus, String message) {
		return new ApiResponse<ApiError>()
			.setCode(httpStatus.value())
			.setMessage(message)
			.setTimestamp(System.currentTimeMillis())
			.setResult(this.generateApiError(e));
	}

	private ApiError generateApiError(ModuleRuntimeException e) {
		ApiError apiError = new ApiError()
			.setException(e.getClass().getName())
			.setMessage(e.getMessage());

		Optional.ofNullable(ExceptionUtils.getRootCause(e))
			.ifPresent(cause -> this.fillApiErrorWithCause(apiError, cause));

		return apiError;
	}

	private void fillApiErrorWithCause(ApiError apiError, Throwable cause) {
		apiError.setCause(cause.getClass().getName())
			.setCauseMessage(cause.getMessage());
	}
}
