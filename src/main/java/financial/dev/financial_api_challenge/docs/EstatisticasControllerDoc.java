package financial.dev.financial_api_challenge.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name="Captura as estatisticas",
description = "Captura as estatisticas dos ultimos segundos (60seg)")
public interface EstatisticasControllerDoc {

    @Operation(summary = "Retorna as estatisticas",
            description = "Retorna as estatisticas dos ultimos segundos")
    @ApiResponse(
            responseCode = "200",
            description = "Estatisticas retornadas"
    )

    ResponseEntity pegarEstatistica();
}
