package application.afericao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springdoc.api.ErrorMessage;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(
    name = "Aferições", 
    description = "Operações relacionadas às aferições",
    externalDocs = @ExternalDocumentation(
        description = "Documentação detalhada",
        url = "https://swagger.io/docs/"
    )
)
@RestController
@RequestMapping("/afericoes")
public class AfericaoController {
    @Autowired
    private AfericaoService afericaoService;

    @PostMapping
    public AfericaoDTO insert(@RequestBody AfericaoInsertDTO novaAfericao) {
        return afericaoService.insert(novaAfericao);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma aferição pelo ID")
    @ApiResponse(responseCode = "200", description = "Aferição encontrada com sucesso")
    @ApiResponse(
        responseCode = "404", 
        description = "Aferição não encontrada",
        content = @Content (
            mediaType = "application/json",
            schema = @Schema(implementation = ErrorMessage.class)
        )
    )
    public AfericaoDTO getOne(
        @Parameter(description = "ID da aferição a ser buscada", example = "0", required = true)
        @PathVariable long id) {
        return afericaoService.getOne(id);
    }

    @GetMapping
    @Operation(summary = "Lista todas as aferições cadastradas")
    @ApiResponse(responseCode = "200", description = "Aferições listadas com sucesso")
    public Iterable<AfericaoDTO> getAll() {
        return afericaoService.getAll();
    }

    @PutMapping("/{id}")
    public AfericaoDTO update(
        @PathVariable long id, @RequestBody AfericaoInsertDTO novosDados) {
        return afericaoService.update(id, novosDados);
    }

    @DeleteMapping("/{id}")
    public void remove(
        @PathVariable long id) {
        afericaoService.delete(id);
    }
}