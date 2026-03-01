package financial.dev.financial_api_challenge.controller;

import financial.dev.financial_api_challenge.docs.EstatisticasControllerDoc;
import financial.dev.financial_api_challenge.dtos.EstatisticaProperties;
import financial.dev.financial_api_challenge.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
@Slf4j
@RestController
@RequestMapping("/estatistica")
public class EstatisticaController implements EstatisticasControllerDoc {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private EstatisticaProperties estatisticaProperties;

    @GetMapping
    public ResponseEntity pegarEstatistica(){
        log.info("Calculando as estatisticas das transações nos ultimos: "
                + estatisticaProperties.segundos() + "segundos");

        final var horaInicial = OffsetDateTime.now()
                .minusSeconds(estatisticaProperties.segundos());
        return ResponseEntity.status(HttpStatus.OK).body(transacaoRepository.pegarEstatisticas(horaInicial));
    }

}
