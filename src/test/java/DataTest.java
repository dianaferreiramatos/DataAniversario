import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class DataTest {

        @Test
        @DisplayName("Teste para verificação do construtor de Data")
        public void givenAnoMesEDiaCreateDataVerifyAno() {
            int ano = 2021;
            int mes = 01;
            int dia = 01;

            Data data = new Data(ano, mes,dia);

            int expResult = 2021;
            int result = data.getAno();

            assertEquals(expResult, result);
        }

        @Test
        @DisplayName("Teste para verificação do construtor de Data")
        public void givenAnoMesEDiaCreateDataVerifyMes() {
            int ano = 2021;
            int mes = 01;
            int dia = 01;

            Data data = new Data(ano, mes,dia);

            int expResult = 01;
            int result = data.getMes();

            assertEquals(expResult, result);
        }

        @Test
        @DisplayName("Teste para verificação do construtor de Data")
        public void givenAnoMesEDiaCreateDataVerifyDia() {
            int ano = 2021;
            int mes = 01;
            int dia = 01;

            Data data = new Data(ano, mes,dia);

            int expResult = 01;
            int result = data.getDia();

            assertEquals(expResult, result);
        }

        @Test
        @DisplayName("Teste para verificação do construtor de Data (vazio)")
        public void withoutInputsCreateDataVerifyAno() {

            Data data = new Data();

            int expResult = 1;
            int result = data.getAno();

            assertEquals(expResult, result);
        }

        @Test
        @DisplayName("Teste para verificação do construtor de Data (vazio)")
        public void withoutInputsCreateDataVerifyMes() {

            Data data = new Data();

            int expResult = 1;
            int result = data.getMes();

            assertEquals(expResult, result);
        }

        @Test
        @DisplayName("Teste para verificação do construtor de Data (vazio)")
        public void withoutInputsCreateDataVerifyDia() {

            Data data = new Data();

            int expResult = 1;
            int result = data.getMes();

            assertEquals(expResult, result);
        }


        @Test
        @DisplayName("Teste para verificação do método isMaior)")
        public void givenTwoDataCheckIfData1isMaiorData2() {
            int ano = 2021;
            int mes = 01;
            int dia = 01;

            Data data1 = new Data(ano, mes,dia);
            Data data2 = new Data(ano+2, mes,dia);

            assertTrue(data2.isMaior(data1));
        }


        @Test
        @DisplayName("Teste para verificação do método diferenca)")
        public void givenTwoDataCheckData1DiferencaData2() {
            int ano = 2021;
            int mes = 01;
            int dia = 01;

            Data data1 = new Data(ano, mes,dia);
            Data data2 = new Data(ano, mes,dia + 2);

            int expResult = 2;
            int result = data1.diferenca(data2);

            assertEquals(result, expResult);
        }

        @Test
        @DisplayName("Teste para verificação do método diferenca)")
        public void givenAnoMesDiaCheckDiferencaComData() {
            int ano = 2021;
            int mes = 01;
            int dia = 01;

            Data data = new Data(ano, mes,dia);

            int expResult = 118;
            int result = data.diferenca(2020, 9, 5);

            assertEquals(result, expResult);
        }

        @Test
        @DisplayName("Teste para verificação da data atual")
        public void checkDataAtual() {

            Calendar hoje = Calendar.getInstance();
            int ano = hoje.get(Calendar.YEAR);
            int mes = hoje.get(Calendar.MONTH) + 1;    // janeiro é representado por 0
            int dia = hoje.get(Calendar.DAY_OF_MONTH);

            Data expResult = new Data(ano, mes, dia);
            Data result = Data.dataAtual();

            assertEquals(result, expResult);
        }

        @Test
        @DisplayName("Teste para verificação de ano bissexto")
        public void givenAnocheckIfIsAnoBissexto() {
            int ano = 2020;
            int mes = 01;
            int dia = 04;

            Data data = new Data(ano, mes,dia);

            assertTrue(data.isAnoBissexto(data.getAno()));
        }

    @Test
    @DisplayName("Teste para verificação das excecoes: mes")
    public void givenMesInvalidocheckIfIsMesInvalidoExceptionIsThrowed() {
        int ano = 2020;
        int mes = 13;
        int dia = 4;

        Exception exception = assertThrows(RuntimeException.class, () -> {
            Data data = new Data(ano, mes,dia);
        });

        String expectedMessage = "Mes fora dos limites !!!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("Teste para verificação das excecoes: dia")
    public void givenDiaInvalidocheckIfIsMesInvalidoExceptionIsThrowed() {
        int ano = 2020;
        int mes = 3;
        int dia = 41;

        Exception exception = assertThrows(RuntimeException.class, () -> {
            Data data = new Data(ano, mes,dia);
        });

        String expectedMessage = "Dia fora dos limites !!!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    }