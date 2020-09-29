package br.com.driw.fallenangel.modules.permission;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(schema = "${driw.schema.ecommerce}", name = "permissions", uniqueConstraints = {
	@UniqueConstraint(name = "uk_permissions", columnNames = { "short_name" })
})
public class Permission implements Serializable {

	private static final long serialVersionUID = -2322389405611108952L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Size(min = 3, max = 24)
	@Column(name = "short_name")
	private String shortName;

	@NotNull
	@Size(min = 6, max = 128)
	@Column(name = "description")
	private String description;
}
