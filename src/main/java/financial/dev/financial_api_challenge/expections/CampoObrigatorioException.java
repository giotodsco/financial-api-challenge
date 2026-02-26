package financial.dev.financial_api_challenge.expections;

public class CampoObrigatorioException extends RuntimeException {
    public CampoObrigatorioException(String message){
        super(message);
    }
}
