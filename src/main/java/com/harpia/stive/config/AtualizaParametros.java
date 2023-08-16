package com.harpia.stive.config;

import com.harpia.stive.domain.model.CadastroServidorDTO;
import com.harpia.stive.domain.model.ServidorRemuneracaoDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.api.ServidoresDoPoderExecutivoFederalApi;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class AtualizaParametros {

    private static Logger logger = LoggerFactory.getLogger(AtualizaParametros.class);
     private final String chaveApiDados = System.getenv("TRANSPARENCIA");

    private ServidoresDoPoderExecutivoFederalApi servidorApi = new ServidoresDoPoderExecutivoFederalApi();

    @Scheduled(cron = "00 00 06 * * ?")
    public void verificaMesAnoServidorRemuneracao() throws IOException {

        try {

            Boolean consultaServidorRemureracao = false;
            int i = 1;
            Integer anoMes = null;

            String cpf = getCpfRemuneracaoServidores();

            if (cpf == null || cpf.isBlank()) {
                cpf = "22225978115";
                gravaCpfRemuneracaoServidores(cpf);
            }
            
                List<CadastroServidorDTO> servidores = new ArrayList<>();
                ApiResponse<List<CadastroServidorDTO>> servidorWithHttpInfo = null;
                Integer idServidor = 0;


                servidorWithHttpInfo = servidorApi.dadosServidoresUsingGETWithHttpInfo(chaveApiDados, 1, null, cpf, null, null, null,null, null);

                if (servidorWithHttpInfo != null && servidorWithHttpInfo.getData().size() > 0){
                    
                    idServidor = servidorWithHttpInfo.getData().get(0).getServidor().getId();
                }
                        
            while (!consultaServidorRemureracao) {

                anoMes = Integer.valueOf(LocalDate.now().minusMonths(i).format(DateTimeFormatter.ofPattern("yyyyMM")));
                i++;
                
                
                ApiResponse<List<ServidorRemuneracaoDTO>> remuneracoesServidores = servidorApi.remuneracoesServidoresUsingGETWithHttpInfo(chaveApiDados, anoMes, 1, cpf, idServidor);

                if (!remuneracoesServidores.getData().isEmpty()) {
                    if (!remuneracoesServidores.getData().get(0).getRemuneracoesDTO().isEmpty()) {
                        consultaServidorRemureracao = true;
                    }
                }

            }

            gravaAnoMesRemuneracaoServidores(anoMes);
            System.out.println("Gavado parametros de mesAno da Consulta de Remuneracao!");

        } catch (ApiException ex) {
            java.util.logging.Logger.getLogger(AtualizaParametros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void gravaAnoMesRemuneracaoServidores(Integer anoMes) throws FileNotFoundException, IOException {

        //ClassLoader loader = Thread.currentThread().getContextClassLoader();
        ClassLoader loader = AtualizaParametros.class.getClassLoader();
        Properties prop;

        try (InputStream resourceAsStream = loader.getResourceAsStream("config.properties")) {
            prop = new Properties();
            prop.load(resourceAsStream);
            resourceAsStream.close();
        }

        try (OutputStream output = new FileOutputStream("config.properties", false)) {
            prop.setProperty("govbr.servidores.remuneracao.anoMes", anoMes.toString());
            prop.store(output, null);
        }
    }

    public static Integer getAnoMesRemuneracaoServidores() throws FileNotFoundException, IOException {

        ClassLoader loader = AtualizaParametros.class.getClassLoader();
        Integer anoMes;

        try (InputStream resourceAsStream = loader.getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(resourceAsStream);
            anoMes = Integer.valueOf(prop.getProperty("govbr.servidores.remuneracao.anoMes"));
            resourceAsStream.close();
        }

        return anoMes;
    }

    public static String getCpfRemuneracaoServidores() throws FileNotFoundException, IOException {

        ClassLoader loader = AtualizaParametros.class.getClassLoader();
        String cpf;

        try (InputStream resourceAsStream = loader.getResourceAsStream("config.properties")) {
            Properties prop = new Properties();
            prop.load(resourceAsStream);
            cpf = prop.getProperty("govbr.servidores.remuneracao.cpf");
            resourceAsStream.close();
        }

        return cpf;
    }

    public static void gravaCpfRemuneracaoServidores(String cpf) throws FileNotFoundException, IOException {

        ClassLoader loader = AtualizaParametros.class.getClassLoader();
        Properties prop;

        try (InputStream resourceAsStream = loader.getResourceAsStream("config.properties")) {
            prop = new Properties();
            prop.load(resourceAsStream);
            resourceAsStream.close();
        }

        OutputStream output = new FileOutputStream("config.properties", false);

        prop.setProperty("govbr.servidores.remuneracao.cpf", cpf);
        prop.store(output, null);
        output.close();
    }

}
