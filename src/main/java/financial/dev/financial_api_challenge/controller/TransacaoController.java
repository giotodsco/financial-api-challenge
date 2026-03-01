package financial.dev.financial_api_challenge.controller;

import financial.dev.financial_api_challenge.dtos.TransacaoRequestDTO;
import financial.dev.financial_api_challenge.repository.TransacaoRepository;
import financial.dev.financial_api_challenge.service.TransacaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacaoRepository transacaoRepository;


    @PostMapping
    public ResponseEntity createTransaction(@RequestBody TransacaoRequestDTO transacaoRequestDTO){
        try {
            transacaoService.validarTransacao(transacaoRequestDTO);
            log.info("Sucesso: Transacao cadastrada com exito");
            transacaoRepository.salvarDados(transacaoRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(IllegalArgumentException e){
            log.error("Erro inesparado: {" + e.getMessage() + "}");
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch(Exception e){
            log.error("Erro inesparado: {" + e.getMessage() +"}");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
   }

    @DeleteMapping
    public ResponseEntity deletarTransacoes(){
        transacaoRepository.deletarList();
        log.info("Sucesso: Transacaos deletadas com exito");
        return ResponseEntity.status(HttpStatus.OK).build();
   }
}
