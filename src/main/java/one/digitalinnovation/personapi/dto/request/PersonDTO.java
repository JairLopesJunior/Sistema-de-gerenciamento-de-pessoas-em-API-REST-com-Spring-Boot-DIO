package one.digitalinnovation.personapi.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    @ApiModelProperty(value = "ID", example = "1", position = 0)
    private Long id;

    @ApiModelProperty(value = "Primeiro nome", example = "James", position = 1)
    @NotEmpty
    @Size(min = 2, max = 100)
    private String firstName;

    @ApiModelProperty(value = "Ultimo nome", example = "Gosling", position = 2)
    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @ApiModelProperty(value = "CPF", example = "42090734078", position = 3)
    @NotEmpty
    @CPF
    private String cpf;

    @ApiModelProperty(value = "Data de Nascimento", example = "04-04-2010", position = 4)
    private String birthDate;

    @ApiModelProperty(dataType="List", value = "phones", position = 5)
    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;
}
