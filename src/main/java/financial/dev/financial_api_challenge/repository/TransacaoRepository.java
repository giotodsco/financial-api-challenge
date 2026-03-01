package financial.dev.financial_api_challenge.repository;

import financial.dev.financial_api_challenge.dtos.EstatisticaResponseDTO;
import financial.dev.financial_api_challenge.dtos.TransacaoRequestDTO;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository {

    List<TransacaoRequestDTO> transacaoRequestDTOS = new ArrayList<>();

    public void salvarDados(TransacaoRequestDTO transacaoRequestDTO){
        transacaoRequestDTOS.add(transacaoRequestDTO);
    }

    public void limparLista(){
        transacaoRequestDTOS.clear();
    }

    public void deletarList(){
        transacaoRequestDTOS.clear();
    }

    public EstatisticaResponseDTO pegarEstatisticas(OffsetDateTime horaInicial){
        // ...
        if(transacaoRequestDTOS.isEmpty()){
            return new EstatisticaResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }
        DoubleSummaryStatistics estatisticas = transacaoRequestDTOS.stream()
                .filter(transacaoRequestDTO ->
                        transacaoRequestDTO.dateTime().toInstant().isAfter(horaInicial.toInstant()) ||
                                transacaoRequestDTO.dateTime().toInstant().equals(horaInicial.toInstant()))
                .mapToDouble(value -> value.valor().doubleValue()).summaryStatistics();


        if(estatisticas.getCount() == 0){
            return new EstatisticaResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }
        return new EstatisticaResponseDTO(
                estatisticas.getCount(),
                estatisticas.getAverage(),
                estatisticas.getMax(),
                estatisticas.getMin(),
                estatisticas.getSum()
        );
    }
}
