package br.com.driw.fallenangel.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ApiResponse<T> {
	private int code;
	private long timestamp;
	private String message;
	private T result;
}
