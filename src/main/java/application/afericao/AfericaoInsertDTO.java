package application.afericao;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para representar os dados de uma nova aferição a ser inserida")
public record AfericaoInsertDTO(
    @Schema(
        description = "Sensor da aferição", 
        example = "TERM01",
        requiredMode = Schema.RequiredMode.REQUIRED)
    String idSensor, 
    @Schema(
        description = "Unidade de medida",
        example = "Graus Celsius",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    String unidade, 
    @Schema(
        description = "Valor da aferição",
        example = "35.5",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    String valor) {
    public AfericaoInsertDTO(Afericao dados) {
        this(dados.getIdSensor(), dados.getUnidade(), dados.getValor());
    }    
}
