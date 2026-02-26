package financial.dev.financial_api_challenge.repository;

import financial.dev.financial_api_challenge.dtos.TransacaoRequestDTO;

import java.util.ArrayList;
import java.util.List;

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
}
