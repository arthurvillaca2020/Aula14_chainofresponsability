import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class teste {
    FuncionarioEnfermeiro enfermeiro;
    FuncionarioMedicoClinico medicoClinico;
    FuncionarioCirurgiao cirurgiao;

    @BeforeEach
    void setUp() {
        cirurgiao = new FuncionarioCirurgiao(null);
        medicoClinico = new FuncionarioMedicoClinico(cirurgiao);
        enfermeiro = new FuncionarioEnfermeiro(medicoClinico);
    }

    @Test
    void deveRetornarEnfermeiroColetaSangue() {
        assertEquals("Enfermeiro", enfermeiro.tratarIntercorrencia(new Intercorrencia(TipoIntercorrenciaColetaSangue.getTipoIntercorrenciaColetaSangue())));
    }
    @Test
    void deveRetornarMedicoFezAnaminese() {
        assertEquals("Médico clinico", enfermeiro.tratarIntercorrencia(new Intercorrencia(TipoIntercorrenciaAnaminese.getTipoIntercorrenciaAnaminese())));
    }

    @Test
    void deveRetornarCirurgiãoFezCirurgia() {
        assertEquals("Cirurgião", enfermeiro.tratarIntercorrencia(new Intercorrencia(TipoIntercorrenciaCirurgia.getTipoIntercorrenciaCirurgia())));
    }

    @Test
    void deveRetornarSemTratamento() {
        assertEquals("Sem tratamento", enfermeiro.tratarIntercorrencia(new Intercorrencia(TipoIntercorrenciaCancerEstagio4.getTipoIntercorrenciaCancerEstagio4())));
    }
}
