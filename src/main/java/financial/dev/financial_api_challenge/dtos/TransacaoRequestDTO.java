package financial.dev.financial_api_challenge.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequestDTO(BigDecimal valor, OffsetDateTime dateTime) {
}
