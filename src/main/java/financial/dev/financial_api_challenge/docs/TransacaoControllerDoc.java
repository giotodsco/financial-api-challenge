package financial.dev.financial_api_challenge.docs;

import financial.dev.financial_api_challenge.dtos.TransacaoRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="Transações",
description = "EndPoints responsaveis por criar, adicionar e deletar as transações numa lista.")

public interface TransacaoControllerDoc {

    @Operation(summary = "Cria uma transação",
    description = "Recebe a transação, se for valida adiciona a lista")
    @ApiResponse(
            responseCode = "201",
            description = "Transação criada com sucesso"
    )
    @ApiResponse(
            responseCode = "422",
            description = "Erro de validação encontrado"
    )
    @ApiResponse(
            responseCode = "400",
            description = "Erro no servidor"
    )

    ResponseEntity createTransaction(@RequestBody TransacaoRequestDTO transacaoRequestDTO);

    @Operation(summary = "Deleta as transação",
    description = "Deleta as transações da lista")
    @ApiResponse(
            responseCode = "200",
            description = "Transações deletas com sucesso"
    )

    ResponseEntity deletarTransacoes();

}

