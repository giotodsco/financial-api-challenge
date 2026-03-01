package financial.dev.financial_api_challenge.service;

import financial.dev.financial_api_challenge.dtos.TransacaoRequestDTO;
import financial.dev.financial_api_challenge.expections.CampoObrigatorioException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {


    public void validarTransacao(TransacaoRequestDTO transacaoRequestDTO){
        if(transacaoRequestDTO.valor() == null){
            throw new CampoObrigatorioException("Erro: Campos vazios, falta o valor");
        }
        if(transacaoRequestDTO.dateTime() == null){
            throw new CampoObrigatorioException("Erro: Campos vazios, falta a hora");
        }
        if(transacaoRequestDTO.dateTime().toInstant().isAfter(OffsetDateTime.now().toInstant())){
            throw new IllegalArgumentException("Erro: Não foi possível realizar a transação pois a data é futura - ["
                    + transacaoRequestDTO.dateTime() + "]");
        }
        if(transacaoRequestDTO.valor().compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Erro: Valor negativo - [" + transacaoRequestDTO.valor() + "]");
        }
    }


}
