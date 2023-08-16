package com.harpia.stive.api.contrato;

import com.harpia.stive.api.model.Atributo;
import com.harpia.stive.api.model.Consulta;
import com.harpia.stive.api.model.Contrato;
import com.harpia.stive.api.model.Filtro;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 *
 * @author fernando
 */
@Data
public class ContratoApi {

    private List<Consulta> consultas = new ArrayList<>();

    private Contrato contrato;
    
    public static final String CHAVE_API_PORTAL_TRANSPARENCIA = "63f8e4bec41a078ed742e00b581738ec";

    public static final String FONTE_REF = "govbr";
    public static final String FONTE_NOME = "CGU - TRANSPARÊNCIA FEDERAL";
    public static final String FONTE_DESCRICAO = "Obter as informações acessíveis no Portal da Transparência do Governo Federal divulgadas pela CGU";

    /*
        Consulta servidores
     */
    public static final String CONSULTA_SERVIDORES_ENDPOINT = "busca";
    public static final String CONSULTA_SERVIDORES_REF = "govbr_servidores";
    public static final String CONSULTA_SERVIDORES_URL = FONTE_REF + "/" + CONSULTA_SERVIDORES_REF + "/" + CONSULTA_SERVIDORES_ENDPOINT;
    public static final String CONSULTA_SERVIDORES_NOME = "Servidores do Poder Executivo Federal";
    public static final String CONSULTA_SERVIDORES_DESC = "Obter as informações referentes aos Servidores do Poder Executivo Federal atualmente acessíveis via API do Portal da "
            + "Transparência do Governo Federal disponibilizada pela Controladoria-Geral da União (CGU)";

    public static final String CONSULTA_CONTRATOS_ENDPOINT = "busca";
    public static final String CONSULTA_CONTRATOS_REF = "govbr_contratos";
    public static final String CONSULTA_CONTRATOS_URL = FONTE_REF + "/" + CONSULTA_CONTRATOS_REF + "/" + CONSULTA_CONTRATOS_ENDPOINT;
    public static final String CONSULTA_CONTRATOS_NOME = "Contratos do Poder Executivo Federal";
    public static final String CONSULTA_CONTRATOS_DESC = "Consulta os dados dos Contratos firmados com o Poder Executivo Federal";

    public static final String CONSULTA_LICITACOES_ENDPOINT = "busca";
    public static final String CONSULTA_LICITACOES_REF = "govbr_licitacoes";
    public static final String CONSULTA_LICITACOES_URL = FONTE_REF + "/" + CONSULTA_LICITACOES_REF + "/" + CONSULTA_LICITACOES_ENDPOINT;
    public static final String CONSULTA_LICITACOES_NOME = "Contratos do Executivo Federal";
    public static final String CONSULTA_LICITACOES_DESC = "Obter informações relativas aos dados das Licitações do Poder Executivo Federal";

    public static final String CONSULTA_SEGURODEFESO_ENDPOINT = "busca";
    public static final String CONSULTA_SEGURODEFESO_REF = "govbr_segurodefeso";
    public static final String CONSULTA_SEGURODEFESO_URL = FONTE_REF + "/" + CONSULTA_SEGURODEFESO_REF + "/" + CONSULTA_SEGURODEFESO_ENDPOINT;
    public static final String CONSULTA_SEGURODEFESO_NOME = "Programa Seguro Defeso";
    public static final String CONSULTA_SEGURODEFESO_DESC = "Consulta os registros dos Beneficiãrios do Programa Seguro Defeso";

    public static final String CONSULTA_BOLSAFAMILIA_ENDPOINT = "busca";
    public static final String CONSULTA_BOLSAFAMILIA_REF = "govbr_bolsafamilia";
    public static final String CONSULTA_BOLSAFAMILIA_URL = FONTE_REF + "/" + CONSULTA_BOLSAFAMILIA_REF + "/" + CONSULTA_BOLSAFAMILIA_ENDPOINT;
    public static final String CONSULTA_BOLSAFAMILIA_NOME = "Programa Bolsa Família";
    public static final String CONSULTA_BOLSAFAMILIA_DESC = "Consulta as parcelas disponibilizadas aos Beneficiários do Programa Bolsa Família";

    public static final String CONSULTA_GARANTIASAFRA_ENDPOINT = "busca";
    public static final String CONSULTA_GARANTIASAFRA_REF = "govbr_garantiasafra";
    public static final String CONSULTA_GARANTIASAFRA_URL = FONTE_REF + "/" + CONSULTA_GARANTIASAFRA_REF + "/" + CONSULTA_GARANTIASAFRA_ENDPOINT;
    public static final String CONSULTA_GARANTIASAFRA_NOME = "Garantia-Safra";
    public static final String CONSULTA_GARANTIASAFRA_DESC = "Consulta os registros dos Beneficiários do Programa Garantia-Safra";

    public static final String CONSULTA_BPC_ENDPOINT = "busca";
    public static final String CONSULTA_BPC_REF = "govbr_bpc";
    public static final String CONSULTA_BPC_URL = FONTE_REF + "/" + CONSULTA_BPC_REF + "/" + CONSULTA_BPC_ENDPOINT;
    public static final String CONSULTA_BPC_NOME = "Benefício de Prestação Continuada (BPC)";
    public static final String CONSULTA_BPC_DESC = "Consulta informações de Beneficiários do programa Benefício de Prestação Continuada (BPC)";

    public static final String CONSULTA_PETI_ENDPOINT = "busca";
    public static final String CONSULTA_PETI_REF = "govbr_peti";
    public static final String CONSULTA_PETI_URL = FONTE_REF + "/" + CONSULTA_PETI_REF + "/" + CONSULTA_PETI_ENDPOINT;
    public static final String CONSULTA_PETI_NOME = "Programa de Erradicação do Trabalho Infantil (PETI)";
    public static final String CONSULTA_PETI_DESC = "Consulta os registros Programa de Erradicação do Trabalho Infantil";

    public static final String CONSULTA_AUXEMERGENCIAL_ENDPOINT = "busca";
    public static final String CONSULTA_AUXEMERGENCIAL_REF = "govbr_auxemergencial";
    public static final String CONSULTA_AUXEMERGENCIAL_URL = FONTE_REF + "/" + CONSULTA_AUXEMERGENCIAL_REF + "/" + CONSULTA_AUXEMERGENCIAL_ENDPOINT;
    public static final String CONSULTA_AUXEMERGENCIAL_NOME = "Auxílio Emergencial";
    public static final String CONSULTA_AUXEMERGENCIAL_DESC = "Consulta os Contemplados do Programa Auxílio Emergencial";

    public static final String CONSULTA_ACORDOLENIENCIA_ENDPOINT = "busca";
    public static final String CONSULTA_ACORDOLENIENCIA_REF = "govbr_acordos";
    public static final String CONSULTA_ACORDOLENIENCIA_URL = FONTE_REF + "/" + CONSULTA_ACORDOLENIENCIA_REF + "/" + CONSULTA_ACORDOLENIENCIA_ENDPOINT;
    public static final String CONSULTA_ACORDOLENIENCIA_NOME = "Acordo de Leniência";
    public static final String CONSULTA_ACORDOLENIENCIA_DESC = "Obtém os registros de Acordos de Leniência disponibilizados pelo Poder Executivo Federal";

    public static final String CONSULTA_CEPIM_ENDPOINT = "busca";
    public static final String CONSULTA_CEPIM_REF = "govbr_cepim";
    public static final String CONSULTA_CEPIM_URL = FONTE_REF + "/" + CONSULTA_CEPIM_REF + "/" + CONSULTA_CEPIM_ENDPOINT;
    public static final String CONSULTA_CEPIM_NOME = "Entidades Privadas Sem Fins Lucrativos Impedidas (CEPIM)";
    public static final String CONSULTA_CEPIM_DESC = "Consulta informações do Governo Federal sobre Entidades Privadas Sem Fins Lucrativos Impedidas";

    public static final String CONSULTA_CEIS_ENDPOINT = "busca";
    public static final String CONSULTA_CEIS_REF = "govbr_ceis";
    public static final String CONSULTA_CEIS_URL = FONTE_REF + "/" + CONSULTA_CEIS_REF + "/" + CONSULTA_CEIS_ENDPOINT;
    public static final String CONSULTA_CEIS_NOME = "Cadastro de Empresas Inidôneas e Suspensas (CEIS)";
    public static final String CONSULTA_CEIS_DESC = "Obtém informações do Cadastro Nacional de Empresas Inidôneas e Suspensas";

    public static final String CONSULTA_CNEP_ENDPOINT = "busca";
    public static final String CONSULTA_CNEP_REF = "govbr_cnep";
    public static final String CONSULTA_CNEP_URL = FONTE_REF + "/" + CONSULTA_CNEP_REF + "/" + CONSULTA_CNEP_ENDPOINT;
    public static final String CONSULTA_CNEP_NOME = "Cadastro Nacional de Empresas Punidas (CNEP)";
    public static final String CONSULTA_CNEP_DESC = "Consulta os dados do Cadastro Nacional de Empresas Punidas";

    public static final String CONSULTA_CEAF_ENDPOINT = "busca";
    public static final String CONSULTA_CEAF_REF = "govbr_ceaf";
    public static final String CONSULTA_CEAF_URL = FONTE_REF + "/" + CONSULTA_CEAF_REF + "/" + CONSULTA_CEAF_ENDPOINT;
    public static final String CONSULTA_CEAF_NOME = "Expulsões da Administração Federal (CEAF)";
    public static final String CONSULTA_CEAF_DESC = "Consulta os registros de Expulsões da Administração Federal";

    public static final String CONSULTA_NOTA_ENDPOINT = "busca";
    public static final String CONSULTA_NOTA_REF = "govbr_notas";
    public static final String CONSULTA_NOTA_URL = FONTE_REF + "/" + CONSULTA_NOTA_REF + "/" + CONSULTA_NOTA_ENDPOINT;
    public static final String CONSULTA_NOTA_NOME = "Notas Fiscais";
    public static final String CONSULTA_NOTA_DESC = "Consulta Notas Fiscais emitidas pelo Governo Federal";
    
    public static final String CONSULTA_PEP_ENDPOINT = "busca";
    public static final String CONSULTA_PEP_REF = "govbr_peps";
    public static final String CONSULTA_PEP_URL = FONTE_REF + "/" + CONSULTA_PEP_REF + "/" + CONSULTA_PEP_ENDPOINT;
    public static final String CONSULTA_PEP_NOME = "Pessoas Expostas Politicamente";
    public static final String CONSULTA_PEP_DESC = "Pesquisa o cadastro de Pessoas Expostas Politicamente mantido pelo Governo Federal";
    
    public static final String CONSULTA_EMPENHOS_ENDPOINT = "busca";
    public static final String CONSULTA_EMPENHOS_REF = "govbr_empenhos";
    public static final String CONSULTA_EMPENHOS_URL = FONTE_REF + "/" + CONSULTA_EMPENHOS_REF + "/" + CONSULTA_EMPENHOS_ENDPOINT;
    public static final String CONSULTA_EMPENHOS_NOME = "Empenhos do Governo Federal";
    public static final String CONSULTA_EMPENHOS_DESC = "Pesquisa os favorecidos de Empenhos do Governo Federal";
    
    
    public static final String CONSULTA_PAGAMENTO_ENDPOINT = "busca";
    public static final String CONSULTA_PAGAMENTO_REF = "govbr_pagamentos";
    public static final String CONSULTA_PAGAMENTO_URL = FONTE_REF + "/" + CONSULTA_PAGAMENTO_REF + "/" + CONSULTA_PAGAMENTO_ENDPOINT;
    public static final String CONSULTA_PAGAMENTO_NOME = "Pagamentos do Governo Federal";
    public static final String CONSULTA_PAGAMENTO_DESC = "Pesquisa os favorecidos de Pagamentos do Governo Federal";
    
    
    public static final String CONSULTA_LIQUIDACAO_ENDPOINT = "busca";
    public static final String CONSULTA_LIQUIDACAO_REF = "govbr_liquidacoes";
    public static final String CONSULTA_LIQUIDACAO_URL = FONTE_REF + "/" + CONSULTA_LIQUIDACAO_REF + "/" + CONSULTA_LIQUIDACAO_ENDPOINT;
    public static final String CONSULTA_LIQUIDACAO_NOME = "Liquidações do Governo Federal";
    public static final String CONSULTA_LIQUIDACAO_DESC = "Pesquisa os favorecidos de Liquidaões do Governo Federal";
    
    public static final String CONSULTA_NOVOBOLSAFAM_ENDPOINT = "busca";
    public static final String CONSULTA_NOVOBOLSAFAM_REF = "govbr_novobolsafam";
    public static final String CONSULTA_NOVOBOLSAFAM_URL = FONTE_REF + "/" + CONSULTA_NOVOBOLSAFAM_REF + "/" + CONSULTA_NOVOBOLSAFAM_ENDPOINT;
    public static final String CONSULTA_NOVOBOLSAFAM_NOME = "Novo Bolsa Família";
    public static final String CONSULTA_NOVOBOLSAFAM_DESC = "Pesquisa as parcelas disponibilizadas aos favorecidos do programa Novo Bolsa Família";

    public static final int VERSAO_PROTOCOLO = 1;

    //#Verificar nome consulta antes do nome da fontes de dados: govbr/consulta
    public Contrato contratoApi() {

        Contrato contrato = new Contrato();

        contrato.setVersao_protocolo(1);
        contrato.setTipo(1);
        contrato.setReferencia(FONTE_REF);
        contrato.setNome(FONTE_NOME);
        contrato.setLogo("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAALEAAACWCAYAAACRgGlLAAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAuIwAALiMBeKU/dgAAABZ0RVh0Q3JlYXRpb24gVGltZQAwOC8wNy8yMxvaooYAAAAcdEVYdFNvZnR3YXJlAEFkb2JlIEZpcmV3b3JrcyBDUzbovLKMAAAgAElEQVR4nO2dd3wURf/Hv9+Z3b2SShLA0BFR7MojSu9VsYv6SO8K2H/o42PHDj7YQAHpIFYsgBJCRxQLClhAERWQTgipd7dl5vv7I7lwhITcJXeXhOyb1wW4zM5+du+zc1O+M4NEBFWZB398LWl75q6mJphNDGk2B8AGHsvX2K046kmSiV6hx0kpFUAouhCGzHJxRy5DzPFI45CLaXsY4H4GbJdDUXfXc9bePbvt04cq87pswgdWFRPfsO7BpCw9u4lB1nkWieaSZDMEaAgAdYmoFiC5JZETADkAcQDAwOP9V4EB/4YT7xEACAT0AoKHAWYDQAYiO8CA/cOR/cWQ7XJy51+NY8/aN7P1E56IX7BN2Kg0E9+y9uE6B/TDrSXJ7oJEGwI6h4gSZZEFS9JVYFEsLHYRsSgZQyw8ioodceJ9Iv+xFHAWKkrFEAEBDzPE3zjwbQpTvufAtnap03Lnk5ePMcJ7B2zCRVRNfPO68XUO6RnXmNK8WRJ1ECTi/ab047eX/z1EBCTII8RDHPh+ZLCPEe4joEOa4jwipMwSZGWlOBK8AKCb0rKwsJQmksSZylSmanlmviPXzI2Nd8TVyjO9CRzYWQZZqQywLhE1ECDrAVBdIHIR+J+NAm2IbD9H9i1nfIOLOzdeldzm5xcuH2KbuooQFRN3Th/V2Su8Qy0SfYlkUqBRA80CiMAAjzBkvwLgFob4k8qU31zo2D38/NuO3tags4yUxsm/zFVWHv4+xSt8jQyyzpYEF0qSF0qS50uSLQgIsFAzIB7kyNZqTEuLV2LWf9Htjb2R0mVTNhEz8WcHflVe/nnyrbrQxwkSbQqqCRRg3AJDcMSjDPnXCvL1DPlXzRwNf5vb+amciIgqJ31WjmvgJb2FLo1WlhRtJNBVRLIOABU+eOxbB9MWxylxy9K6v76jsvXWNMJuYgSErumjRuSK/PssKS70l2AABVUFBASGLJMj/0Jhygf1nKlfftjp+aywiogwL/78gbbi4OoLDGm01cnoRkTdiCgBAIAh+0Vl6vsJqvvDtG5v/l7ZWmsCYTVx5xXDu3mk/rxF4koiGdCoAmAF5t2iMe3ts1xJHy3u9L+jYTtxJXPPD5Nd2zJ3XOq1fH0kiRsk0CUFDytu0VCbmazFLl7S9Y3Dla3zTCUsJr5lw8O1D3gOvawLY5CEQPMSIDDgyL9xccekDb1mfVzhk1UDeq8e2yzX9PQypHmHBNkOAIAjX+pk6usbes1eVdn6zjQqbOLO6aNu8Fj5b5hkNQg0LwCCisouB9ee/rLX7IVh0Fot6bvm/nqZxvHrTWkOIoDWCLBHQWV6khY36/NuU45Utr4zgQqZuF3akIleqY8/uepAwJFLB3NOaplw4TNvtHkwP1xiqzu9Vt/ZLEvP6y8BBgFSCgdlhcbVlzf0nPl9ZWurzpTLxAPXPhL/h2//B4Y0ewU23AAAFKb8HKvGjlrTfdo34ZN55tEpfXgHnzDGEFBXBNyhovLaxt5zPqlsXdWRkE18/dr7Gx30HV1qSvOS4nVfB9dmtEtode/Lbcb5IiH2TOSG1ffUOWJmD7JI/BuBmSrymdfUu2HuI5dcb1W2tupCSCbuu+aBS47pGV/4pF6/yMBEwBiHGO4et6HXzKmREloTaJc29BpBYhQApCCyd891N5wxr+Mz9shgGQRt4lvXPdxsj/fgJl3qtVlA1xlHlp/A429f3WvasgjqrFF0WjniUl1Yo5GoOUP8rLGj/sxFXZ6zv91KISgT37bmoaS/fQc2mWSee3IDTslKUOOvWd3jra8jLbQm0mnlqEaG0EdxwAs58PRzYlvMnNV+vFnZuqoaZZp4wY5VfMrueasNaXY6MfIGwJHnJqkJPdN7vGk34CJM1/SRdS0pR0qQTRljaRt6zvqwsjVVJco0cdu0IVO9wjcmcOiYI6cENbHn6h5v2h33UaTLqpEpUtAgAKzPGCxb2+PttZWtqSpwWhN3Th95S46V96G/H9gfwxvHY4ev7/X27OjJtAmky8rRZ0mSt6ioOAFh2arub/1W2Zoqk1JN3G/Nw7X/9u3bIchKDoyBcHHXlK97z7k7ihptSqHHyjGNAWVnFRQPY3z1sq6vZVa2psqgVBO3XT74fa/Ubw2sRqiobflv3KhWN3ToIKIn0aYsrl1933kS5Pka1w7FMPx+YcdJNerzKdHEXdNHdc4yc9eemN8AoCCXZznqtlzabfK2KGu0CZKb1j10ocp4kotru+a2e/pgZeuJFiWa+MovBvxgktkycNqQU3E9/3WvOY9GU5xN6Az56llVYaJRLIvnmlPbO/HSsWd8//IpJu6UPuKmXDN/ceBETY5877kpjc9758rnz/gbcqbw8I9T3bW0+Limjnq558c38VxSt1llS4oYSvE3vJbvcQqICQZAcHPn07aBqxcvtRzrAQDP8t1fq5WtJdKcZOLOK0d2s0hcFtgboSD7q1X9VvMrQ5xNxenTpO0ZP8LHAv/jtXzjAtdtQADQmPrayxfdaUdU2VRZikx8w+r7Glgk+vj/XzCwwXKTnbVq7KwMm+pBkYmPWlk3EknHSQHuyJct6fxKjexAt6k+FJnYlNb1J1clEBxM+6BSVNnYhAADALh+7f0pkmRbCJxij5hbR0v+sjLF2dgEAwMAyLO8rQWRK3BFNAZs60ddJh6rNGU2NkHCAAB0oV8VsLwvACBwZHagu021gAEAGNK4uHjXGmfsp8oSZWMTCmz096/ESYCTxiQLGnXqX5UlysYmFNju3F0XEMiUwGAfRDRU5jxQibpsbIKGGZZ+CQDEFXs/q1FMPbt/2KZawARZFxKRw/9G4fKrx3tpnfMqU5iNTbAwncR5BMBPehOZ5+aWbSpLk41NSDAH0xr797gAKGjUCRLeyhRlYxMKzCv0pOJzOyRJuyphU21gprBOCZpGQEdJiW1sqiL+7d9OgjMeE30pNjblg9EpO3MSIIBWWYJsbEKFqchOmr6CgGCRiL/9yydPmX9nY1MVYU7Febz4mwhYC8hIqAxBNjahwiwhDkKxjZSJKC7TOF67kjTZ2IQE44z9jgAnbTdLAMwj9fqVJcrGJhQUBZU/ENAkoIBROwIhZQsAWF1pysILXnD3e42z8kWzPN1qqnKe6tGNFAKIVTjjUpKUJPNjnVqGaYp9boeyOynW+devL12zF9yuiK5rdu/bX7rStx1qmJmnN7SkbEgEdQkgOderxzpUxYWISERkmEJ3OdR8jbNMwxJHXBo/4NTYP6mJjn3fTLwl6DiXcdM2OLMN6RYEp13TV0HCOIXlTR3TKeTtFoa98WWsIaUm4TRLriKAygEurKNmP9SvXYX27FYUxn8ChHwgcPrfJAAgoosqknFl0/KB98/al2l0z9etnpakK6Wks4lIlQAAVNCWJQDQzYL7hwiQmacDAECeISAjTzcdQ9/dyxB/dij823inuvGyJnFbljzWt0Jbmg18aalr1e/ZrXN9ZhdJ0EZIOl9KqicLN6E6sSITgsc4+fnJ85lFWvMNCxAQDmT5jjtvm/2Xwthmt4Zr6iY41v/8+u2l7l76yeZ99xzL0/9DZZiYMcCkGG3EVICQN9D89Pu/3/boohfB6c+hcrS21I1r9VA/qNAG70qKM/6XLCMnUwIlB/a1SZCXVCTjyqL+sAVtc3QxVjfFNUJSgizYF71YR2IAhe8H3m0iAkmggqBmgNBMN8UN+T4TjvzsO5A6dMGog3MGfh6yruELr8r2mINMIfsKSY0kAQT4NSj8yU+UbwQgoJZF9C8d5b+8JowWEqYBwF2l5eGzZJxuiFplngwRvCo5y0xXArohaumGqHXa6yIAoTDQBfHTpAoK5b32Ew+2+qL/AQBqfuJuEkiSF/57w/jEdztOqhabhzcdvejSjBzjWa8p+gpZ+CmfWImrfAQY3CICYYl6llRCGs1sMGJh+6x88z8+U1wjij9Q5dVVik5JALolT7uHNCKIYM6LCIAI5fqaR0QLEMq8PkSwwnELFAAAhuwvIOxUlDkgEFHCIV/WpQCwPgzniShJA+c9luuznrAEqcHcvPLCGIJD5UF99XV57NOEH/7Kmug1xShLyAJXQOS0+bN2qMo/kTtD1cRv4m3F7y0BgU8aHaEKm/i6Z5fGrPk1412PIa6l01UZwgQCmC4Nj5aVrvmYD67Yn5m3yGvI5gUPVYSFFYKIoDA4FJWTVSEYAICKyk/FHUBAIEh0rxRVQXD9hCUJa3/NWJevi2sJoHwGpsBXGVuhEQAiZrVsmnzaZQzqD5/XaW9G7toiA5eXwAowBfxdBoyxGmdiBQAgUUv8JV94PUTk9v8CAUGSvOKmteNrf9xlUpmlTzTZuGWfsua3Y5/kGeKKkIxSaALGABiizhAPccaOCyJTYeAwLFkLAVMkkUv4TROQPyIc69WzZ6lhqs3u/ODSjFzrc8OimPIaGKGg2sIQPUSUqSk8W0jwYkFB67aETALA2oKIycAHjwAYAyM5zlmlPqtooAAALOnyv6Otvui/wwL6V+CEUUnkPmoc6w4A71aWwJK4/tU1L+froksoxyABKJzlaAr72KXxJUluxw/t/1X/4KwR7YpiR7o+/Zm2/5CvdpbXOMdnibamRb1MIdsJSUphYNSRYZeWnH+fCUtiD2TlLw7ZwAXmA4Wxw5zhWk3j65wK21Y33rnH4Yg59t1LfU7qp73p+WUxOw546mXk6RfopmhvWLKbEHS5RRIQmCc53lHj5kYWBflw5BsEiX+d/GsCQ5o3QxUyceOR77TN8Zj3Bl0HJgDOEWIdyrTUROdzO6bctq+0pGuevN4AgP2Fr/UA8EKzO98/NzPPd7vHsO5SFVZqH/Gm34+/5DNFs+ANTMAQQVPY1hiH+upljVI+W/VsnzJ7gj7+b998APij8PUZAEDjkYuuysw3xhLRJQ+0a1DjZuUUmdjN3WtNad5fvA9cSNH9xnUPJX3SeWKVeMKP5uqTLFE8gLQUCEBT2PHkOMegA7P6l2vv6T+n3bYTACa0efiTN49ke5uUlKbJ6HcvyDesO4POlABUzvQEl/ro0fmDXgEoX1eWnz1v3/EtAHx75f99nPzwOz/Q9b0vq0h21Y4iEzd11d+4zcrJkiQTA6sUAighQ8+4DgDmVoK+k6g/bEEXw6K2wRpYVVhug0R39z9n3P5jRc+96aUbMwAgo6TfHcvTH7IksZJ+V5Iup4LH6iRo1+55e+CmiuoK5LuXb6qRa+cV3fhZHR4/zpBtODWJBF3oQ6MpqjSyveKuooGMMuAMISlG7R8OA5+OKx5cnGIY4uagEhOAxtFTr5azd7gNXJM5qfRwMO1jLFbMISAIoPY9Vo07P6rKitH6wY8TDUv0DLbOGePgCw7NGbg0sqoA/s7I72lJig0mLSJAglu9/8/p/TdHWldN4iQT19WSv2DITmkYSJIs38obHT1Zp/JnRn5rQVR2oD4BcIZG/STXE1GQBbopewT15VBQP996ZN6gGREXVcM4ycQfdZl0lCNbfWqAE4Ehzf63r3s0PoraTkK3ZOvgahIEbk1Zs/2N23ZHWBIAAAghLw8mHSJCjINPibSemsgp8+g0ps0xpegbODxUMPAhUvb5DgwHgFeiKdCPJLggmHSICCrHxZHWAwDQ4b9LEgRBw2CqOJyD3jAlNi2YfJvd9V4HnynPLytcshQw1qkc2Dn11nL1xlRHTjFxk5hGy3fk/HFIknVWYD8WAYAujbtf2bzg9fuvGBj1DbBNSzQ4bUhlIYgILk2JSp3zWJ6eQkSJwaTljP2xdfLN+4NJeyRbH5OvW7eXJ+SCiMClKV8DQI0x8SndQgvaP+XVGF9EpzTwAASJpp8cW39HtMQFwhgklBk8UFAfzk+t5YrKsrRZ+UYtKOEengIBMKSgA78JIJ+AQFLoLyIASZRTkeuqbpT4ASQo8W8zZKeExBAQeKXvsVf+ebfCgcyhsPzLnQoCuoIa4UDIbXN+aoVmXwTLweM+LaguPwTw6lFdGqw81ZBqS4kmXt59ym8q8lPm1yEgCGmd+8n21QMiL+0EmosIghzVQgAURnQ2QA3l6z5K0ZhFp4vq2U4lqg9RqV+FLu6cXLzPGKAwzlj4Jjz4zeSordfW7YrzBBDowaSVBHFf/XGk+KLhEaFxHbeXM1b2R0YALk0Jqu584ojqC0b5iS3VxGt7vr2cI/+leAO5YIUgq9G3Wb+Mjbi6AAggs8zyBQGkJPeRLG/DaGhyqDwTgMxgyj1LyrMh+BKyqqyFV66HSUgZ1ermaRslMYrz5VJLY6k/du26B5MipqwYnOPuYNIREXh00TbCcgAA4IKGiYcRMaPMj7rg4Wpy3pj3m5WREgAAGNB3ALACgJb7Xwj0BUfYWXHVwULgUIJotJaA1xSOaFZoTiuyf8MbFqpM/auk0liQqJXhOzYhouoCUBhuDSYdEYBhiX6R1gMA8PH4nj7OgjOWkKQcydFvCiZtzqIhr9LiEb1p8cir/S+5eOQ18THazIopBsAyp7CcQDdEKFWgIhwqjwm2DKfg5ZTKaU088vy+woHa86XVcQxp3NV75dhSwsTDS5xT+ZIHU9dCAEPIdo1GvROV0ljjfGMwpQ4RgMew7rp/xoZyrzgqCSrcDtENGVS8MRGAIahxqPnfN+M7RUqqF0xaBBAJMY4KjzmU+XUx7OzeczjwP4o/LwgAkgQ7buVEZSi112UNtiic7Q3mCReC4FiuMQWi0EpPdCvLFIZl1x4RwBSyydwNux+rwOkqfD2IdDSodhcBSEkhByYv3bK7iSSqF0z7hYjyHApUeEmIMk085Nx+Mk6JfaakujECgiHN9h1XjBhZUSFlMXNcJ9Oh4KKgPgAE8Bri8loD5r8WaV3LH+v3rcpwezBpCQByfcZj9Ya/c3WEZZWK26H8FdSTgACGpDYdHvsspCrF8VxvDymDWBCFABSGByeOvaDCAzNBVdzX9Jy+kDP+Y2lD+R7hnXT9uvvPqqiYsqiT6H6LM9SDKY0JAHK8xt1JA+a9GElNFzTWyO1UJgfbqyQI8GiOb3GdoQuviaSu0qiX6NjOkXmC+0aT8b/uzR4RSv4+S4wJtprLGG5rk3pOKNmXnE+Q6ShBifsvx1MfsILhaCvhkPfY9AqrKYM/pt661+3gU4P9UpUAkO01H467Y87nLca817yi57/lhWXxvScsOyXeZGT3BvOcCtsZbGPGEtJ5PE9fljhg3oTRU1eGslRUhVtBP/yv31GFww9BnYwA8n3mEy3ufj+oe5c8aN7juikvCmpglQE4VSU9mHzLIugulFU93lqhopJWUmmMgGBK87qOK4aH9NSWh9ZNUp50KGxPsI1sCQB5PnH13xn5W+LvmPtq49HvhFTPO3fMe42TBy/oH3P7nA9W/Hx0q2nJU75eXxjY1aoVo43mLMinCxEsQZDjNR+fv+GfrbUGzL374nsWlbmULmdolpUmGNwOJehqmWFR3O4j+SsbjVzUvtR0VjZPHjj/sRyPNSHY2GqFY17DFHdYgpQwlC6Oa1aPa3HYl/mzAKmcumIQAEeWl+qqe+nSLq9EdHPzRiMWtjmUrW80BbGgmzqFEXCcIaiMbVU5bmIMf4pzq/syc7yZuiFkvZSE2FyPXlsSNTGFvIAILrakbCGIHFSwEhUlunnDzAVDS4xGqzVg7tM5XuuJkGZ9UsGQtMIxT2XsW1Vh3wLQjoQY7fD+o/m5sW5NUTivZ1riMp8pbjeEbFpWfk6Np3nfG9qntCQdH/007rtdmX/qpqwd7HxFhSM4FPaZQ+XLFYXtPJZteOvEO+rkm9blpilu0S15UbDXjQAQ71KnZi0cPC7IQ06fX6j9dO3SBk/0CN/4kgdBABxM++abPvPbQoSHTlOHzhuYkWfOtwSE3manAucgICCe6Kss6EqkE4vtFAv9VBhS87qJF26fcvOO0rJOGDBvdq7XHBryxQeskMnQH8NdMKu76N/BLFMQhIkBAOoOWTAiI1d/O9Rp1gX3jApvYQi6ivQROFSe2Tw15byfX72uxIm3oRLyiEyLuHOf1FD9p+RqBYAhjdbt04Y9Fw5xp+PgnMELkmK0QSpHEUL/fQGF36X+cEf/SlYF4YwBT1+xD4YAMMfrOW1cRvbCwcPiXeoMhhDaYxywEKIkAOHXVRBaWaKeinB47sCZsU7lMwzx1hXcsxP3KyRdBQvYQC03HxkuAwOUw8Sz2j3qTdDix2KphxL4hO+RLitHRbwb6fDcQQvqJji7OlUe0eqLHykJsr2izClaWQsHj050qQ8qHK2qHMrTuUV8/xgH/yoqGgtivSHBrd53cM7gkBfuPh3lGhtP7/7mUgfX5pd87QgCBOSa+fOuW3N/xANx/pnZf8NFjWpdEedU3lIYlm9CT5AgItSKdQbVb3psweDJDZJdbVwOvp4jlL1gYXgJ6mSfPX5T/s2tzuoZ51Q+ZBDEgE0F1Gic+ZJitREZ8waFve++XCYGAGjubHCPwpSDpfVWCLJSjugZH636a3PEI5q+n3Tj8Zx3hoxpUCumVZxL/VBhWLB4c5g/FEkEx3J9dYNN//e0OzZ73h3aOSXWcYdT498UDZtH0CyFBL1929wH+nhyFg25NSlWHeVQ2f6w3jcC4IgQ41DSGyW7Wx+ZO3BWmHI+iZAbdoF0XDWyb56et7S0qyYgcHPXrK96z41411sgZ49+t8XRPP0205I3WJIuk5JOLQhLq8f5GykBDS3/SpUcYV+MQx2fuWDQe+XRVW/Ywq65XusOU8hepqQGRY0iv56yGkhULF1RA7VoJc1MheEOt4bvZcwfEnI4QPenvqj1w64jQ30mDTGFvFgE6vNrDEIXAoDCmcfJcaXbqb51aM6AFaFqCYUKmRgAoG3akNle4Rta+r1HiFNi7l3fa+brFTpROWk6+r2Ljuf72ppCXikkXUgSGgFikiWlEwp7JwAKl/8lApUzk4hyGcMMRNyrIPtNUXBrrEvd2vfy+tvfuqtjhRfsGzplvfvzzXtaWgLaGZZsJSSdJySlAlKCkKT4jVmkq2BFTlAYM6Ukj8JZFgEd5YztYwx3qQx3uJ3Kjqa1Y3//8vnrwrJmXr1h71zhNURXU4g2lqQWkiAVCOItImQB9wyAQGGoE2EmY7iXM9zmUNjGJnXi1v34vxujsmp9hU08euMk95acbT+ZZDYrLfaYowJJWkLf9O5vhrxhS7i59tkvXEeyjeTfDmQlxrk0t9PBXURAXt3yHs83fBc1TMyVwsr6YXK/qO5V0nb85wm5hif576P58bXjnW7OUQMCMgX58r2GpVvkvahxoud4vp7zQr/Lc2/s0DwsAx9B63t0SdLhTG/ysVxfXHK8040IimFK3/E83dMiNSErVtUy1r54jSeamvxU2MQAAN1Wjr4qy8z9iqjkiH4CAgWV3NrO5Ku+6Pp6qX2sNjblodwNu0BW95j+rYs5Hynt94VTmuKO+jK/uH3df+ztdm3CSlhMDACwsffsSRrTPi+tXEdAMMls8rf3wOd3ff0/dynJbGxCJmwmBgBo6DhrkIrqPllKbwUDBF3qrX7M3vZ+OM9rU7MJq4k/7DoxM06J7ceRlbp1MAMEQxp926YNWRTOc9vUXMJqYgCA1T3f+iaWx9xd+rB0QT+iT/j+3S5tyNRwn9+m5hF2EwMArO818y0Xd5QZJO8VvjHt0oa+FAkNNjWHsHSxlYgJcNWqgWsMaXY53UAPAICbu176qvec/0RGiM2ZTkRKYgAAUAFSnam3qKj8WVr92G9uj/A+3C5taETnwtmcuUSuJC6kd/rY8zOs45sEiYSSRvQAAktk50tf9Z5rl8g2IRFxEwMAdF85unuWmZsmSPLSqxYEAAxiuPPNjb3nRHWdN5vqTeSqEwGs6jF9VZwSM5QhQulVi4IwKI/wjmmXNuSdaOiyOTOISknsp0Pa8P/LF55J/qis0iAgcDLHp12TOvZ/7qoRlRJUYlN9iKqJAQA6rhj2Yp7lebisdAQAGtM2NYxrcO1H7Z+vkTtl2gRH1E0MANA2bcgUr/CNLWt+oQQClam/J2mJ163oNiWKy5raVCcqxcQAAG3SBs/wCX1k2TPQCRRUjsSqMbev7TFjbVTE2VQrotKwK4lNveeNcjDHnLIXk0SwyKqTY+ald0ofMTwq4myqFZVmYgCAb/rMG+YM0siSpJJn5s9snzZ0YlTE2VQbKq06EUibtMGzfUIfChDUAjfgYNryc9wNBy7s9Jzd4LOpGiYGAGiTNniaT+ijAQhKG9nzQ0CgMu3PODXmjtXdp30XJYk2VZRKrU4Esqn3vDtjFPcbAKUPiPgpWNzbaJZl5HzZccXwu6Ik0aaKUmVKYj/t0oY+5hXeZyjIEpkBAyd3zG+Z2GLcG63/kxslmTZViCpnYgCADiuG3+cR3lckiTKN7IczviOBxw9b1fOtbyIsz6aKUSVNDADQacWoW/NF/iJBotSgoUAKSmUuXNz1+Mbes16IuECbKkOVNTEAQI+VY7tkmVkfWmQlB1MiU+E6Sk7mWFPPUWfs4q6Tfou8SpvKpkqbGADg6lV3n5thZn1iSvOC4JfBJeDIs93c+fCGXrMjvpeITeVS5U0MADB0w4Rav+X/uUiXeu9gj/E3DDWmfZ7srHXv511e+zOSGm0qj2ph4kKwfdqQVzzCd28wPRcA/hkjBUtoubnrqfW9Zk6OtEib6FOdTAwAAB3Sho30SH2KJEsLtufCX1fWUF0fr8aNX9njze8jq9ImmlQ7EwMA9Fo1ts1xM3uhKc2zgzUyQGEVA5l0Mcdr58U0nzC7w6NRXfnSJjJUSxMDANyy/qHkfZ5Dsw1pXhfK0ub+qghHZY+TO5/4stfM+RGUaRMFqq2J/XROG/lkrsx/UpDA4De1KyqVQQFlTazqenxNjxlfR1CmTQSp9iYGAOiWfleXXCt3rklWo5C3tAMCBAYaVxckKjET0rq/tSsiIm2CZtm+jdi3QfugjVllAoAqwuqeb4jBXBwAAAm0SURBVK09O7bpv5xMfTeYAKJA/LOsdWEMPKpnbW2TNuSlG9c+WCdyam1Ox4QtM+ruzT0Q0mZFZ0RJHEj7FcOG+4RvsiAZH3qpXABHnqEy5fXGMfWmvtfhhbDsgWFTNretf6QRR5a0qONzW0M57owoiQPZ2Gv2rFRHSiuNqasLdgoNpVQueAmyUnShT9iVu/fXdiuGjh+w8YnT7iJqU3H6f/lETK6Vd3WmkfV7qMeecSVxIO3Tht3nk77nBAl3KF1xfvz9yxz5XgdTp9dxpk7/pPML9mySCNAt/c5nOWOL07u/uSXUY89oEwMA9Fk9rkWmkf2GKc3uoeyjHciJagY7ojJ1em1H8swlXSbvDaPMGk2HFUMnILDDG3rNKtd61We8if20WzFklC7M50WQEXEl4S+ZGfJ8jfEFsdz91soe034Kr9KaRfu0oS8AQOrG3nOGlDePGmNiAIDrV9/f4IiZ+bwhjYGSZNAB98U5YWYkBfmnTu6Ysb7nrLTwqj3zaZc2ZBYAXdA8qVmHuVc+YZU3nxplYj+d00dd7bE8L5pkXQxQviqGHwIARAAOfKuDu+bV0uIXLe0y+Uh4lJ6ZjPzuufifjv32AQI2Otfd5Mr5nSbklSefP/b+xb7K/z21RpoYAGD2L0vVWfs+flCX+kOSZK2K5ucfzkZkmSoqn7oUbf7aHjPXh0PrmUTn9BFt84VvMQLsb1arabt3Wz+jlzevUd+9cH4jrc6hGmtiP9eufqBhhnHsGYOMwZJOv1pnMPjvJkMEBmybypT3EtSYj5d3e7NGryV3z6bJ7s1Z257SyRzPkS+5p8mgmwac30OUN79b1j3UkaGy+4NOz++t8Sb2023lne3yLM+TpjR7EJS/vhzIiV4NtBjydSqqH8dpMcvTuk7ZXeHMqxGdV4y8I094XpAkGzmY49lNfeY+XpH8eq8ad73ClJxlXV9dC1BD68Sno1P68Ju8wnjckuZlwQbfB0NAY9DHgW/UuLI0VnGvSuv25vawnKAK0iltxHUe8j5sSdFWRcUTp8b2X91j2qcVybNr+uj+DDFmVY9pM/zv2SYuASGJdVo5bKgujIcEiXPL279cGoG9GwzYFo58hcKUNU1jGny/oP2E7DCeKurcuO7B5KO+47cY0hhtknV5wRQx9aMm7nr3v9fpxX0VybvjihEjGbL663rOeCrwfdvEp+GBr6Y6v8vdPNwnjQcEybMhTNUMP/7pU+j/g+wIQ9ysorZRYdpXDd2pPy1s/2SVD9x//Ie3nRsyvu/gk95bBYkbBMkUAADO+M4Y5n5kfa+3P67oOdqvGPY8A3Rv6DXrvuK/s00cBHdtetH9U/bOYbrU75Ukzgl3yewn8JNgwAARjjLAXzji95xp37tR+7lubP09C9o+7ovA6UOi68pRjX3SbCvJ6iWk7CxINpYkARBAQX7IyRyvda/T/rWnWg73VuQ8gzc9E7Mz+89FDHDPV73n3FNSGtvEITDm60mOrdm/DrVI3GeRdV5Ze4+EAyr6WVD9AGD7GcCfiLhDQb4dEf8AZH/X11KPfND5uSwIZZpLECzZs1GZtuuDOvnCc7YprYsliZaSqJUgeT6B1PwBVlgYY6IxdXqqK3XaR50qHv3XMX34laYwFyGw97/uM/fR0tLZJi4Hi7evUl/b924/n2XcY4F1FVVg9K88BH4TIGDhgAseR4SjSHgIAQ6rTDlsgcxkwDIcXMv1mN48AMqL0WJMv80ZABhksDzT64xVYuIZ47F5pifRydQ6BpmpANAACOpLoFQgclHRI3XCuIVTvb7SuDLzgrhmH81o+1i5Bi6K03r5oCcI6H4V1fs29p4973RpbRNXkC7po/p4hfcuk6y+kgijZ+WTCSyxofBnSdUeRDylrC4erlpwnP97puB/CAENUkBgjG1TgH0Wo7g/W9Vj+o/huo4u6SPb5wnvdEboilPjblzV481tZR1jmzhMdF951yV5Vv4Ii6zbJMk6kao3R4tAVyAAMGQ5DPhWhfFVTuZYvqbn9M3hPN81q+8+95iR/axFop+G6rzWyZfdOfnK+4Kq+9smDjM3rR+fdNib0c+Q5kBJop2EgtD8SFU3yvOwlFTuQsBPRJAIuJ8hbmeofMuRb0pWU7Ys6TrxcMUVn8zVq+9pcdzIGm+SNQwBDzq5a9iXvWaGFExlmziCdFw5spUh9H9bUtwkSTQGKJ/pSoMjAwS0LBJKWWn9D1HhLG8CAA8CZgFABkN2AAF2M2R/ILCdTq7uvCy2+d7JbcaXO66hLDqlj+jiE74xppS3IAJoTHmhfdIVz0y68p6QezNsE0eB+zZPdP947PfuhtT/bZHsKYmSKtqJIElCnBoLCVrs9zlG3lKLxF8IkK8yBS2SCgA5AUAlAvQKX26s4vK5FZc318zPiVdjsxhTcs6La5w9+YoHorZja4+VY87LFXnXC2kNEEQXAwBwxt9JcSQ+ubzrlHKvlWebOMr0Wz8+5YAvo5slrJsEiC6SZO3A1n4oSCL/CqD5DNkuRNysofpNjOr8dsjZg7bf0bRNuQNswsG47151/5q94zKf8HYRJK+2pGgrgYAjAwX4O7FKzKTVPaeV2XArC9vElcitGx9JPOA51MEQ5rVE1EWSPIcC+grKW9ctGP3DPIbsTw74C0f+M0e+3cW1v1Icsfvf6TAp7KOAT2yZ7tyc+XO9fMvbwiCrpZTiSgHUUpKs7+/nYMgOq0yZH8/jZ63oMSXkCaGlYZu4ivDGriXKp38va+kTRndTWp0E0BVEIgmg/PXowIfBX8oj4jEAOIAABxD5AZXxA4awDsWozkxTmNkWWTkJWryuMc3AwhwkAOpS17L0HGeMGpMoSCQKKetIkmcRUEMCaERE9YjoLABSAxuziOjjyNZqzPHOpbGNlkxt91TY91WxTVxFGbDxiaR/8vdfbpDVXpC4SpK8VBLVo0KDAIRe/QAouT/Z/3dgLHTxx4aAgOhEzzEVHXMiR38fMiIe58i+VpAviVVdaendpkV0Uq1t4mrCgK+fdv+Tt+c8QXSZJUVLCfISImouic4ikFjSpxjuyDs8aXWlgkcIEQEBjzFgOzjjX3FQ1qW6k7//sOPEqC1tYJu4GjPyu0nuPTl/1/MJvYkg0VSSPNsi0RAA6wPI2gSUAIAxRNIJgAoBcQhtwRxCQIsATIboAYBsAjjCke1nyP5QkO1QmbY9lrl3Le32aqWFkNomPkP5z+ZXEn/M2tmAM6VptpHTyK04m2Qbuakq1xoryJNMacXqQo/1VwMKIOTITaei5SBAplfoe+OUmD26MP9MVGN3Ohnf9XGX1/ZU3lWVzP8Dzj2G3s5V110AAAAASUVORK5CYII=");
        contrato.setDescricao(FONTE_DESCRICAO);

        /*
            Consultas disponiveis na fonte
         */
        consultaServidores();
        
        consultaPeps();
        
        consultaNovoBolsaFamilia();

        consultaSeguroDefeso();

        consultaGarantiaSafra();

        consultaBpc();

        consultaPeti();

        consultaContratos();

        consultaBolsaFamilia();

        consultaAuxilioEmergencia();

        consultaCepim();

        consultaCeis();

        consultaCnep();

        consultaCeaf();

        consultaAcordoLeniencia();

        consultaNotaFiscal();
        
        consultaPagamento();
        
        consultaLiquidacao();
        
        consultaEmpenhos();

        contrato.setConsultas(consultas);

        return contrato;
    }

    //
    private void consultaServidores() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_SERVIDORES_ENDPOINT, "Digite o CPF do servidor do Executivo Federal que deseja encontrar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        atributos.add(addAtributo("Mês/Ano", "mesAno", 2, "99/9999"));

        filtros.add(addFiltro(CONSULTA_SERVIDORES_ENDPOINT, "Digite o CPF do servidor do Executivo Federal que deseja encontrar e o Mês/Ano e o mês ano da sua remuneração", atributos));

        addConsulta(CONSULTA_SERVIDORES_NOME,
                CONSULTA_SERVIDORES_REF,
                CONSULTA_SERVIDORES_DESC,
                filtros);
    }
    
    
    //
    private void consultaLiquidacao() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_LIQUIDACAO_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar, será utilizado o ano anterior como referência", atributos));
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_LIQUIDACAO_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar, será utilizado o ano anterior como referência", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        atributos.add(addAtributo("Ano", "ano", 2, "9999"));
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        atributos.add(addAtributo("Ano", "ano", 2, "9999"));

        filtros.add(addFiltro(CONSULTA_LIQUIDACAO_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar e o Ano de referência", atributos));

        addConsulta(CONSULTA_LIQUIDACAO_NOME,
                CONSULTA_LIQUIDACAO_REF,
                CONSULTA_LIQUIDACAO_DESC,
                filtros);
    }
    
        private void consultaPagamento() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_PAGAMENTO_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar, será utilizado o ano anterior como referência", atributos));
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_PAGAMENTO_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar, será utilizado o ano anterior como referência", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        atributos.add(addAtributo("Ano", "ano", 2, "9999"));
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        atributos.add(addAtributo("Ano", "ano", 2, "9999"));

        filtros.add(addFiltro(CONSULTA_PAGAMENTO_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar e o Ano de referência", atributos));

        addConsulta(CONSULTA_PAGAMENTO_NOME,
                CONSULTA_PAGAMENTO_REF,
                CONSULTA_PAGAMENTO_DESC,
                filtros);
    }
        
        
    private void consultaEmpenhos() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_EMPENHOS_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar, será utilizado o ano anterior como referência", atributos));
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_EMPENHOS_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar, será utilizado o ano anterior como referência", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        atributos.add(addAtributo("Ano", "ano", 2, "9999"));
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        atributos.add(addAtributo("Ano", "ano", 2, "9999"));

        filtros.add(addFiltro(CONSULTA_EMPENHOS_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar e o Ano de referência", atributos));

        addConsulta(CONSULTA_EMPENHOS_NOME,
                CONSULTA_EMPENHOS_REF,
                CONSULTA_EMPENHOS_DESC,
                filtros);
    }


    private void consultaContratos() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_CONTRATOS_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_CONTRATOS_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_CONTRATOS_NOME,
                CONSULTA_CONTRATOS_REF,
                CONSULTA_CONTRATOS_DESC,
                filtros);
    }
    
    private void consultaPeps() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_PEP_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("Nome", "nome", 4, ""));
        filtros.add(addFiltro(CONSULTA_PEP_ENDPOINT, "Digite o nome da pessoa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_PEP_NOME,
                CONSULTA_PEP_REF,
                CONSULTA_PEP_DESC,
                filtros);
    }

    private void consultaLicitacoes() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_LICITACOES_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_LICITACOES_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_LICITACOES_NOME,
                CONSULTA_LICITACOES_REF,
                CONSULTA_LICITACOES_DESC,
                filtros);
    }

    //VERIFICAR filtro:url  e atributo:chave - valores
    private void consultaSeguroDefeso() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_SEGURODEFESO_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        filtros.add(addFiltro(CONSULTA_SEGURODEFESO_ENDPOINT, "Digite o NIS da pessoa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_SEGURODEFESO_NOME,
                CONSULTA_SEGURODEFESO_REF,
                CONSULTA_SEGURODEFESO_DESC,
                filtros);
    }

    private void consultaBolsaFamilia() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_BOLSAFAMILIA_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        filtros.add(addFiltro(CONSULTA_BOLSAFAMILIA_ENDPOINT, "Digite o NIS da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        atributos.add(addAtributo("Mês/Ano", "mesAno", 2, "00/0000"));
        filtros.add(addFiltro(CONSULTA_BOLSAFAMILIA_ENDPOINT, "Digite o CPF da pessoa e o Mês/Ano que deseja pesquisar o pagamento do benefício", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        atributos.add(addAtributo("Mês/Ano", "mesAno", 2, "00/0000"));
        filtros.add(addFiltro(CONSULTA_BOLSAFAMILIA_ENDPOINT, "Digite o NIS da pessoa e o Mês/Ano que deseja pesquisar o pagamento do benefício", atributos));

        addConsulta(CONSULTA_BOLSAFAMILIA_NOME,
                CONSULTA_BOLSAFAMILIA_REF,
                CONSULTA_BOLSAFAMILIA_DESC,
                filtros);
    }
    
    
    private void consultaNovoBolsaFamilia() {

        List<Filtro> filtros = new ArrayList<>();
         List<Atributo> atributos = new ArrayList<>();

        /*
       
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_NOVOBOLSAFAM_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        atributos.add(addAtributo("Mês/Ano", "mesAno", 2, "00/0000"));
        filtros.add(addFiltro(CONSULTA_NOVOBOLSAFAM_ENDPOINT, "Digite o CPF da pessoa e o Mês/Ano que deseja pesquisar o pagamento do benefício", atributos));
        */
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        filtros.add(addFiltro(CONSULTA_NOVOBOLSAFAM_ENDPOINT, "Digite o NIS da pessoa que deseja pesquisar", atributos));
        
        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        atributos.add(addAtributo("Mês/Ano", "mesAno", 2, "00/0000"));
        filtros.add(addFiltro(CONSULTA_NOVOBOLSAFAM_ENDPOINT, "Digite o NIS da pessoa e o Mês/Ano que deseja pesquisar o pagamento do benefício", atributos));

        addConsulta(CONSULTA_NOVOBOLSAFAM_NOME,
                CONSULTA_NOVOBOLSAFAM_REF,
                CONSULTA_NOVOBOLSAFAM_DESC,
                filtros);
    }

    private void consultaGarantiaSafra() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_GARANTIASAFRA_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        filtros.add(addFiltro(CONSULTA_GARANTIASAFRA_ENDPOINT, "Digite o NIS da pessoa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_GARANTIASAFRA_NOME,
                CONSULTA_GARANTIASAFRA_REF,
                CONSULTA_GARANTIASAFRA_DESC,
                filtros);
    }

    private void consultaBpc() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_BPC_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        filtros.add(addFiltro(CONSULTA_BPC_ENDPOINT, "Digite o NIS da pessoa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_BPC_NOME,
                CONSULTA_BPC_REF,
                CONSULTA_BPC_DESC,
                filtros);
    }

    private void consultaPeti() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_PETI_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        filtros.add(addFiltro(CONSULTA_PETI_ENDPOINT, "Digite o NIS da pessoa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_PETI_NOME,
                CONSULTA_PETI_REF,
                CONSULTA_PETI_DESC,
                filtros);
    }

    private void consultaAuxilioEmergencia() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_AUXEMERGENCIAL_ENDPOINT, "Digite o CPF da pessoa que deseja pesquisar", atributos));

        atributos = new ArrayList<>();
        atributos.add(addAtributo("NIS", "nis", 2, ""));
        filtros.add(addFiltro(CONSULTA_AUXEMERGENCIAL_ENDPOINT, "Digite o NIS da pessoa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_AUXEMERGENCIAL_NOME,
                CONSULTA_AUXEMERGENCIAL_REF,
                CONSULTA_AUXEMERGENCIAL_DESC,
                filtros);
    }

    private void consultaCepim() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_CEPIM_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_CEPIM_NOME,
                CONSULTA_CEPIM_REF,
                CONSULTA_CEPIM_DESC,
                filtros);
    }

    private void consultaCeis() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_CEIS_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_CEIS_NOME,
                CONSULTA_CEIS_REF,
                CONSULTA_CEIS_DESC,
                filtros);
    }

    private void consultaCnep() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_CNEP_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_CNEP_NOME,
                CONSULTA_CNEP_REF,
                CONSULTA_CNEP_DESC,
                filtros);
    }

    private void consultaCeaf() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CPF", "cpf", 1, ""));
        filtros.add(addFiltro(CONSULTA_CEAF_ENDPOINT, "Digite o CPF da pessoa que deseja encontrar", atributos));

        addConsulta(CONSULTA_CEAF_NOME,
                CONSULTA_CEAF_REF,
                CONSULTA_CEAF_DESC,
                filtros);
    }

    private void consultaAcordoLeniencia() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 3, ""));
        filtros.add(addFiltro(CONSULTA_ACORDOLENIENCIA_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_ACORDOLENIENCIA_NOME,
                CONSULTA_ACORDOLENIENCIA_REF,
                CONSULTA_ACORDOLENIENCIA_DESC,
                filtros);
    }

    private void consultaNotaFiscal() {

        List<Filtro> filtros = new ArrayList<>();

        List<Atributo> atributos = new ArrayList<>();
        atributos.add(addAtributo("CNPJ", "cnpj", 1, ""));
        filtros.add(addFiltro(CONSULTA_NOTA_ENDPOINT, "Digite o CNPJ da empresa que deseja pesquisar", atributos));

        addConsulta(CONSULTA_NOTA_NOME,
                CONSULTA_NOTA_REF,
                CONSULTA_NOTA_DESC,
                filtros);
    }

    private void addConsulta(String nome, String url, String decricao, List<Filtro> filtros) {

        Consulta c = new Consulta();
        c.setFiltros(filtros);
        c.setNome(nome);
        c.setDescricao(decricao);
        c.setUrl(url);

        this.consultas.add(c);
    }

    private Filtro addFiltro(String url, String instrucao, List<Atributo> atributos) {

        Filtro filtro = new Filtro();
        List<Filtro> filtros = new ArrayList<>();

        filtro.setAtributos(atributos);
        filtro.setInstrucao(instrucao);
        filtro.setUrl(url);

        filtros.add(filtro);

        return filtro;

    }

    private Atributo addAtributo(String rotulo, String chave, Integer tipo, String mascara) {

        Atributo a = new Atributo();
        a.setChave(chave);
        a.setMascara(mascara);
        a.setRotulo(rotulo);
        a.setTipo(tipo);

        return a;
    }

    public static void main(String[] args) {

        ContratoApi contratoApi = new ContratoApi();
        Contrato contratoApi1 = contratoApi.contratoApi();

        System.out.println("contrato " + contratoApi1);

    }

}
