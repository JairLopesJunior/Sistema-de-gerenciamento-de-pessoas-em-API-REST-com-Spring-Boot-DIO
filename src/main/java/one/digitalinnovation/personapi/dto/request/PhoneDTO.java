package one.digitalinnovation.personapi.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {

    @ApiModelProperty(value = "ID", example = "1", position = 0)
    private Long id;

    @ApiModelProperty(value = "Tipo de Telefone", example = "HOME", position = 1)
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @ApiModelProperty(value = "Numero do Telefone", example = "1199999999999", position = 2)
    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
