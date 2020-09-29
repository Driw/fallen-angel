package br.com.driw.fallenangel.modules;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleRuntimeException extends RuntimeException {

	private HttpStatus httpStatus;
	private AutoMessageConfig autoMessageConfig;
	private Object[] arguments;

	public ModuleRuntimeException(AutoMessageConfig autoMessageConfig) {
		super(autoMessageConfig.toString());

		this.setAutoMessageConfig(autoMessageConfig);
		this.setHttpStatus(HttpStatus.BAD_REQUEST);
	}

	public ModuleRuntimeException(AutoMessageConfig autoMessageConfig, Object... args) {
		super(autoMessageConfig.toString());

		this.setAutoMessageConfig(autoMessageConfig);
		this.setHttpStatus(HttpStatus.BAD_REQUEST);
		this.setArguments(args);
	}
}
