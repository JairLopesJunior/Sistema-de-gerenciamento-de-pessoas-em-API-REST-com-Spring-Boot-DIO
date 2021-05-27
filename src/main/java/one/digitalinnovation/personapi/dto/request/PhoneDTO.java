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

    @ApiModelProperty(name = "id", allowEmptyValue = false, value = "ID", example = "1", position = 0)
    private Long id;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(name = "type", allowEmptyValue = true, value = "Tipo de Telefone", example = "HOME", position = 1)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    @ApiModelProperty(name = "number", allowEmptyValue = false, value = "Numero do Telefone", example = "1199999999999", position = 2)
    private String number;
}
