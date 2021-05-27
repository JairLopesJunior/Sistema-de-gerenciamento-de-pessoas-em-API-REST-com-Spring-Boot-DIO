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

    @ApiModelProperty(name = "id", value = "ID", allowEmptyValue = false, example = "1", position = 0)
    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    @ApiModelProperty(name = "firstName", allowEmptyValue = false, value = "Primeiro nome", example = "James", position = 1)
    private String firstName;

    @NotEmpty
    @Size(min = 2, max = 100)
    @ApiModelProperty(name = "lastName", allowEmptyValue = false, value = "Ultimo nome", example = "Gosling", position = 2)
    private String lastName;

    @NotEmpty
    @CPF
    @ApiModelProperty(name = "cpf", value = "CPF", allowEmptyValue = false, example = "42090734078", position = 3)
    private String cpf;

    @ApiModelProperty(name = "birthDate", allowEmptyValue = true, value = "Data de Nascimento", example = "04-04-2010", position = 4)
    private String birthDate;

    @NotEmpty
    @Valid
    private List<PhoneDTO> phones;
}
