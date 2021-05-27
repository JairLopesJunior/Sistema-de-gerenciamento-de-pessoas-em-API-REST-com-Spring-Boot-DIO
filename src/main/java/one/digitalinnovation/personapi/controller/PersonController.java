package one.digitalinnovation.personapi.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @ApiOperation("Salvar uma pessoa.")
    @ApiResponse(code = 201, message = "Pessoa cadastrada com sucesso.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @ApiOperation("Buscar todas as pessoas.")
    @ApiResponse(code = 200, message = "Pessoas encontradas com sucesso.")
    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @ApiOperation("Buscar a pessoa por ID.")
    @ApiResponse(code = 200, message = "Pessoa encontrada com sucesso.")
    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @ApiOperation("Atualizar uma pessoa.")
    @ApiResponse(code = 200, message = "Pessoa atualizada com sucesso.")
    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

    @ApiOperation("Deletar uma pessoa.")
    @ApiResponse(code = 200, message = "Pessoa deletada com sucesso.")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }
}
