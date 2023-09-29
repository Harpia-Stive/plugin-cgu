/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.harpia.stive.util;

import com.harpia.stive.domain.model.CodigoDescricaoDTO;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.api.LicitaesDoPoderExecutivoFederalApi;
import com.mdimension.jchronic.Chronic;
import com.mdimension.jchronic.Options;
import com.mdimension.jchronic.tags.Pointer;
import com.mdimension.jchronic.utils.Span;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class Util {

    private static LicitaesDoPoderExecutivoFederalApi licitacoesApi = new LicitaesDoPoderExecutivoFederalApi();
    private static final String chaveApiDados = System.getenv("TRANSPARENCIA");
    public static final int TAMANHO_PADRAO_PAGINA_API = 15;

    /*
     * Formata a data para exibicao, sem a localidade (formatos: dd/MM/yyyy e
     * dd/MM/yyyy HH:mm:ss)
     */
    public static String getCodigoModidadeLicitacao(String modalidade) throws ApiException {

        String codigo = null;
        List<CodigoDescricaoDTO> modalidades = licitacoesApi.modalidadesUsingGET(chaveApiDados);
        for (CodigoDescricaoDTO m : modalidades) {
            if (m.getDescricao().equalsIgnoreCase(modalidade)) {
                codigo = m.getCodigo();
            }
        }

        return codigo;
    }

    public static String formataData(String data) {

        String retorno = null;
        String retornoCompl = null;

        if (data == null) {
            return null;
        }

        if (data != null && !data.trim().equals("") && data.length() > 9) {
            data = data.replace("T", " ");
            String[] partes = data.split(" ");

            if (StringUtils.isNotBlank(partes[0])) {
                if (partes != null && partes.length > 1 && StringUtils.isNotBlank(partes[1])) {
                    retorno = partes[0];
                    retornoCompl = partes[1].substring(0, 8);
                } else {
                    retorno = partes[0];
                }
            }
        }

        LocalDateTime localDate = null;
        DateTimeFormatter FOMATTER = null;

        if (retorno != null) {

            if (retorno.length() == 10) {

                try {

                    SimpleDateFormat dt3 = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat dt2 = new SimpleDateFormat("dd/MM/yyyy");
                    SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");

                    boolean ini4 = NumberUtils.isDigits(retorno.substring(0, 4));
                    boolean ini2 = NumberUtils.isDigits(retorno.substring(0, 2));
                    boolean fim2 = NumberUtils.isDigits(retorno.substring(retorno.length() - 2, retorno.length()));
                    boolean fim4 = NumberUtils.isDigits(retorno.substring(retorno.length() - 4, retorno.length()));
                    boolean contemBarra = retorno.contains("/") && !retorno.contains("-");
                    boolean contemTraco = retorno.contains("-") && !retorno.contains("/");

                    SimpleDateFormat format = null;
                    SimpleDateFormat formatCorreto = new SimpleDateFormat("dd/MM/yyyy");

                    if (ini4 && contemBarra && fim2) {
                        format = new SimpleDateFormat("yyyy/MM/dd");

                    } else if (ini4 && contemTraco && fim2) {
                        format = new SimpleDateFormat("yyyy-MM-dd");

                    } else if (ini2 && contemBarra && fim4) {
                        format = new SimpleDateFormat("dd/MM/yyyy");

                    } else if (ini2 && contemTraco && fim4) {
                        format = new SimpleDateFormat("dd-MM-yyyy");

                    } else {

                        return null;
                    }

                    Date parse = format.parse(retorno);

                    retorno = formatCorreto.format(parse);

                } catch (ParseException ex) {
                    Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }

            } else if (retorno.length() == 19) {

                FOMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                localDate = LocalDateTime.parse(retorno, FOMATTER);
                retorno = localDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            }
        }

        if (StringUtils.isNotBlank(retornoCompl)){
            retorno = retorno + " " + retornoCompl;
        }

        return retorno ;
    }

    public static Date getDate(String data) {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;

        try {
            date = formato.parse(data);
        } catch (ParseException ex) {
            date = null;
        }

        return date;
    }

    /**
     * @param uma data no formato dd/MM/yyyy
     * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * represented by this date.
     * @throws ParseException
     */
    public static Long getTimeStamp(String data) throws ParseException {

        Long ret = null;

        if (data == null)
            return null;

        boolean ini4 = NumberUtils.isDigits(data.substring(0, 4));
        boolean ini2 = NumberUtils.isDigits(data.substring(0, 2));
        boolean fim2 = NumberUtils.isDigits(data.substring(data.length() - 2, data.length()));
        boolean fim4 = NumberUtils.isDigits(data.substring(data.length() - 4, data.length()));
        boolean contemBarra = data.contains("/") && !data.contains("-");
        boolean contemTraco = data.contains("-") && !data.contains("/");

        SimpleDateFormat format = null;
        SimpleDateFormat formatCorreto = new SimpleDateFormat("dd/MM/yyyy");

        if (ini4 && contemBarra && fim2) {

            format = new SimpleDateFormat("yyyy/MM/dd");
            data = formataData(data);

        } else if (ini4 && contemTraco && fim2) {

            format = new SimpleDateFormat("yyyy-MM-dd");
            data = formataData(data);

        } else if (ini2 && contemBarra && fim4) {

            format = new SimpleDateFormat("dd/MM/yyyy");

        } else if (ini2 && contemTraco && fim4) {

            format = new SimpleDateFormat("dd-MM-yyyy");
            data = formataData(data);

        } else {
            return null;
        }

        if (data == null) {
            return null;
        }

        SimpleDateFormat dt2 = new SimpleDateFormat("dd/MM/yyyy");
        ret = dt2.parse(data).getTime();

        return ret/1000;
    }

    public static String textfromHtml(String htmlText) {

        Document doc = Jsoup.parse(htmlText);
        Elements elements = doc.getElementsByTag("p");
        return elements.text().replaceAll("\\\"", "\"");
    }

    public static String getNumerics(String str) {

        if (str == null) {
            return null;
        }

        StringBuffer strBuff = new StringBuffer();
        char c;

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (Character.isDigit(c)) {
                strBuff.append(c);
            }
        }

        return strBuff.toString();
    }

    public static String trataPlaca(String str) {

        if (str == null) {
            return null;
        }

        StringBuffer strBuff = new StringBuffer();
        char c;

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (c != '-') {
                strBuff.append(c);
            }
        }

        return strBuff.toString();
    }

    public static String completaZeroEsquedaNumber(String numero, Integer tamMinimo) {

        if (tamMinimo == null) {
            tamMinimo = 11; //CPF 
        }

        NumberFormat nf = new DecimalFormat(numero);
        nf.setMinimumIntegerDigits(tamMinimo);

        String format = nf.format(numero);

        return format;
    }

    public static boolean isCPF(String CPF) {

        if (CPF == null) {
            return false;
        }

        CPF = removeCaracteresEspeciais(CPF);

        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") || CPF.equals("99999999999") || (CPF.length() != 11)) {
            return (false);
        }

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                // converte o i-esimo caractere do CPF em um numero:
                // por exemplo, transforma o caractere '0' no inteiro 0        
                // (48 eh a posicao de '0' na tabela ASCII)        
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig10 = '0';
            } else {
                dig10 = (char) (r + 48); // converte no respectivo caractere numerico
            }
            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11)) {
                dig11 = '0';
            } else {
                dig11 = (char) (r + 48);
            }

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }

    private static String removeCaracteresEspeciais(String doc) {

        if (doc != null) {

            if (doc.contains(".")) {
                doc = doc.replace(".", "");
            }
            if (doc.contains("-")) {
                doc = doc.replace("-", "");
            }
            if (doc.contains("/")) {
                doc = doc.replace("/", "");
            }
        }

        return doc;
    }

    public static boolean isCNPJ(String CNPJ) {

        if (CNPJ == null) {
            return false;
        }

        CNPJ = removeCaracteresEspeciais(CNPJ);

        // considera-se erro CNPJ's formados por uma sequencia de numeros iguais
        if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222") || CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555") || CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888") || CNPJ.equals("99999999999999") || (CNPJ.length() != 14)) {
            return (false);
        }

        char dig13, dig14;
        int sm, i, r, num, peso;

        // "try" - protege o código para eventuais erros de conversao de tipo (int)
        try {
            // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 11; i >= 0; i--) {
                // converte o i-ésimo caractere do CNPJ em um número:
                // por exemplo, transforma o caractere '0' no inteiro 0
                // (48 eh a posição de '0' na tabela ASCII)
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig13 = '0';
            } else {
                dig13 = (char) ((11 - r) + 48);
            }

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 2;
            for (i = 12; i >= 0; i--) {
                num = (int) (CNPJ.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso + 1;
                if (peso == 10) {
                    peso = 2;
                }
            }

            r = sm % 11;
            if ((r == 0) || (r == 1)) {
                dig14 = '0';
            } else {
                dig14 = (char) ((11 - r) + 48);
            }

            // Verifica se os dígitos calculados conferem com os dígitos informados.
            if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13))) {
                return (true);
            } else {
                return (false);
            }
        } catch (InputMismatchException erro) {
            return (false);
        }
    }


    /*
     * public static String getNumerics(String str) {
     *
     * if (str == null) {
     * return null;
     * }
     *
     * StringBuffer strBuff = new StringBuffer();
     * char c;
     *
     * for (int i = 0; i < str.length(); i++) {
     * c = str.charAt(i);
     *
     * if (Character.isDigit(c)) {
     * strBuff.append(c);
     * }
     * }
     *
     * return strBuff.toString();
     * }
     */

 /*
     * public static String trataPlaca(String str) {
     *
     * if (str == null) {
     * return null;
     * }
     *
     * StringBuffer strBuff = new StringBuffer();
     * char c;
     *
     * for (int i = 0; i < str.length(); i++) {
     * c = str.charAt(i);
     *
     * if (c != '-') {
     * strBuff.append(c);
     * }
     * }
     *
     * return strBuff.toString();
     * }
     */

 /*
     * public static String completaZeroEsquedaNumber(String numero, Integer
     * tamMinimo) {
     *
     * if (tamMinimo == null) {
     * tamMinimo = 11; //CPF
     * }
     *
     * NumberFormat nf = new DecimalFormat(numero);
     * nf.setMinimumIntegerDigits(tamMinimo);
     *
     * String format = nf.format(numero);
     *
     * return format;
     * }
     */

 /*
     * Trata mes ano, formato de datas aceitos
     * dd/MM/yyyy => 01/01/2021
     * yyyy/MM/dd => 2021/02/01
     * ddMMyyyy => 01032021
     * yyyyMMdd => 20210401
     * yyyy/MM => 2021/05
     * MM/yyyy => 06/2021
     * MMyyyy => 072021
     * yyyyMM => 202108
     */
    public static Integer trataMesAno(String mesAno) {

        try {

            String anoMes = null;

            String mesAnoAux = null;

            if (mesAno != null && mesAno.startsWith("0")) {
                mesAnoAux = mesAno.substring(1, mesAno.length());
            }

            if (mesAno == null || (mesAnoAux != null && !NumberUtils.isCreatable(mesAnoAux.replaceAll("/", "")))) {
                return Integer.valueOf(LocalDate.now().minusMonths(2).format(DateTimeFormatter.ofPattern("yyyyMM")));
                //return 202212;

            } else if (mesAno.contains("/")) {

                int indexOf = mesAno.indexOf("/");

                if (mesAno.length() == 7) {

                    if (indexOf == 4 && NumberUtils.isCreatable(mesAno.replaceAll("/", ""))) {
                        return Integer.valueOf(mesAno.replaceAll("/", ""));
                    } else if (indexOf == 2 && NumberUtils.isCreatable(mesAno.replaceAll("/", ""))) {
                        return Integer.valueOf(LocalDate.parse("01/" + mesAno, DateTimeFormatter.ofPattern("dd/MM/yyyy")).format(DateTimeFormatter.ofPattern("yyyyMM")));
                    }
                }

            } else if (NumberUtils.isCreatable(mesAno) && mesAno.length() == 8) {

                String finalData = mesAno.substring(4, mesAno.length());
                String inicioData = mesAno.substring(0, 2);

                if (Integer.valueOf(finalData) > 1900 && Integer.valueOf(inicioData) < 13) {
                    return Integer.valueOf(LocalDate.parse(mesAno, DateTimeFormatter.ofPattern("ddMMyyyy")).format(DateTimeFormatter.ofPattern("yyyyMM")));
                } else {
                    return Integer.valueOf(mesAno.substring(0, 6));
                }

            } else if (NumberUtils.isCreatable(mesAno) && mesAno.length() == 6) {

                String finalData = mesAno.substring(2, mesAno.length());
                String inicioData = mesAno.substring(0, 2);

                if (Integer.valueOf(finalData) > 1900 && Integer.valueOf(inicioData) < 13) {
                    return Integer.valueOf(LocalDate.parse("01" + mesAno, DateTimeFormatter.ofPattern("ddMMyyyy")).format(DateTimeFormatter.ofPattern("yyyyMM")));
                } else {
                    return Integer.valueOf(mesAno);
                }

            }

            Options opts = new Options(Pointer.PointerType.PAST);
            Span result = Chronic.parse(mesAno, opts);

            TimeZone timeZone = result.getBeginCalendar().getTimeZone();
            Instant toInstant = result.getEndCalendar().toInstant();
            LocalDate local = LocalDate.ofInstant(toInstant, timeZone.toZoneId());

            anoMes = local.format(DateTimeFormatter.ofPattern("yyyyMM"));

            return Integer.valueOf(anoMes);

        } catch (Exception e) {
            //return Integer.valueOf(LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("yyyyMM")));
            return 202212;
        }
    }

    public static String md5(String texto) throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance("MD5");

        m.reset();
        m.update(texto.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1, digest);
        String hashtext = bigInt.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }

        return hashtext;
    }

    public static String dataAtual() {

        String pattern = "yyyy/MM/dd";
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return formatter.format(localDate);
    }
}
