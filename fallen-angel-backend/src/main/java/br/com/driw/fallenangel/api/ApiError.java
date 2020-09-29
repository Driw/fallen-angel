package br.com.driw.fallenangel.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ApiError {
	private String exception;
	private String message;
	private String cause;
	private String causeMessage;
}
