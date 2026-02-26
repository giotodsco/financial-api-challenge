package financial.dev.financial_api_challenge.controller;

import financial.dev.financial_api_challenge.dtos.TransacaoRequestDTO;
import financial.dev.financial_api_challenge.repository.TransacaoRepository;
import financial.dev.financial_api_challenge.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @Autowired
    private TransacaoRepository transacaoRepository;


    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody TransacaoRequestDTO transacaoRequestDTO){
        try {
            transacaoService.validarTransacao(transacaoRequestDTO);
            transacaoRepository.salvarDados(transacaoRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


}
}
