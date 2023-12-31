/*
 * API REST do Portal da Transparência do Governo Federal
 * API de serviços do Portal da Transparência do Governo Federal
 *
 * OpenAPI spec version: 1.0
 * Contact: listaapitransparencia@cgu.gov.br
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
package com.harpia.stive.service.client.api;

import com.google.gson.reflect.TypeToken;
import com.harpia.stive.domain.model.CartoesDTO;
import com.harpia.stive.service.client.ApiCallback;
import com.harpia.stive.service.client.ApiClient;
import com.harpia.stive.service.client.ApiException;
import com.harpia.stive.service.client.ApiResponse;
import com.harpia.stive.service.client.Configuration;
import com.harpia.stive.service.client.Pair;
import com.harpia.stive.service.client.ProgressRequestBody;
import com.harpia.stive.service.client.ProgressResponseBody;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GastosPorMeioDeCartoDePagamentoApi {
    private ApiClient apiClient;

    public GastosPorMeioDeCartoDePagamentoApi() {
        this(Configuration.getDefaultApiClient());
    }

    public GastosPorMeioDeCartoDePagamentoApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for cartaoUsingGET
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param codigoOrgao Órgão/Entidade (Código SIAFI) (optional)
     * @param cpfCnpjFavorecido Favorecido (CPF/CNPJ) (optional)
     * @param cpfPortador Portador (CPF) (optional)
     * @param dataTransacaoFim Data transação fim (DD/MM/AAAA) (optional)
     * @param dataTransacaoInicio Data transação início (DD/MM/AAAA) (optional)
     * @param mesExtratoFim Mês extrato fim (MM/AAAA) (optional)
     * @param mesExtratoInicio Mês extrato início (MM/AAAA) (optional)
     * @param tipoCartao Tipo de cartão (CPGF&#x3D;1 ou CPCC&#x3D;2 ou CPDC&#x3D;3) (optional)
     * @param valorAte Valor até (####,##) (optional)
     * @param valorDe Valor de (####,##) (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call cartaoUsingGETCall(String chaveApiDados, Integer pagina, String codigoOrgao, String cpfCnpjFavorecido, String cpfPortador, String dataTransacaoFim, String dataTransacaoInicio, String mesExtratoFim, String mesExtratoInicio, Integer tipoCartao, String valorAte, String valorDe, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api-de-dados/cartoes";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (codigoOrgao != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("codigoOrgao", codigoOrgao));
        if (cpfCnpjFavorecido != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("cpfCnpjFavorecido", cpfCnpjFavorecido));
        if (cpfPortador != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("cpfPortador", cpfPortador));
        if (dataTransacaoFim != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dataTransacaoFim", dataTransacaoFim));
        if (dataTransacaoInicio != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("dataTransacaoInicio", dataTransacaoInicio));
        if (mesExtratoFim != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("mesExtratoFim", mesExtratoFim));
        if (mesExtratoInicio != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("mesExtratoInicio", mesExtratoInicio));
        if (pagina != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("pagina", pagina));
        if (tipoCartao != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("tipoCartao", tipoCartao));
        if (valorAte != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("valorAte", valorAte));
        if (valorDe != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("valorDe", valorDe));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (chaveApiDados != null)
        localVarHeaderParams.put("chave-api-dados", apiClient.parameterToString(chaveApiDados));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call cartaoUsingGETValidateBeforeCall(String chaveApiDados, Integer pagina, String codigoOrgao, String cpfCnpjFavorecido, String cpfPortador, String dataTransacaoFim, String dataTransacaoInicio, String mesExtratoFim, String mesExtratoInicio, Integer tipoCartao, String valorAte, String valorDe, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'chaveApiDados' is set
        if (chaveApiDados == null) {
            throw new ApiException("Missing the required parameter 'chaveApiDados' when calling cartaoUsingGET(Async)");
        }
        
        // verify the required parameter 'pagina' is set
        if (pagina == null) {
            throw new ApiException("Missing the required parameter 'pagina' when calling cartaoUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = cartaoUsingGETCall(chaveApiDados, pagina, codigoOrgao, cpfCnpjFavorecido, cpfPortador, dataTransacaoFim, dataTransacaoInicio, mesExtratoFim, mesExtratoInicio, tipoCartao, valorAte, valorDe, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Consulta os registros de Cartões de Pagamento
     * Filtros mínimos:  Página (padrão &#x3D; 1);  Período de até 12 meses ou um órgão ou um portador ou um favorecido específico;
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param codigoOrgao Órgão/Entidade (Código SIAFI) (optional)
     * @param cpfCnpjFavorecido Favorecido (CPF/CNPJ) (optional)
     * @param cpfPortador Portador (CPF) (optional)
     * @param dataTransacaoFim Data transação fim (DD/MM/AAAA) (optional)
     * @param dataTransacaoInicio Data transação início (DD/MM/AAAA) (optional)
     * @param mesExtratoFim Mês extrato fim (MM/AAAA) (optional)
     * @param mesExtratoInicio Mês extrato início (MM/AAAA) (optional)
     * @param tipoCartao Tipo de cartão (CPGF&#x3D;1 ou CPCC&#x3D;2 ou CPDC&#x3D;3) (optional)
     * @param valorAte Valor até (####,##) (optional)
     * @param valorDe Valor de (####,##) (optional)
     * @return List&lt;CartoesDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<CartoesDTO> cartaoUsingGET(String chaveApiDados, Integer pagina, String codigoOrgao, String cpfCnpjFavorecido, String cpfPortador, String dataTransacaoFim, String dataTransacaoInicio, String mesExtratoFim, String mesExtratoInicio, Integer tipoCartao, String valorAte, String valorDe) throws ApiException {
        ApiResponse<List<CartoesDTO>> resp = cartaoUsingGETWithHttpInfo(chaveApiDados, pagina, codigoOrgao, cpfCnpjFavorecido, cpfPortador, dataTransacaoFim, dataTransacaoInicio, mesExtratoFim, mesExtratoInicio, tipoCartao, valorAte, valorDe);
        return resp.getData();
    }

    /**
     * Consulta os registros de Cartões de Pagamento
     * Filtros mínimos:  Página (padrão &#x3D; 1);  Período de até 12 meses ou um órgão ou um portador ou um favorecido específico;
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param codigoOrgao Órgão/Entidade (Código SIAFI) (optional)
     * @param cpfCnpjFavorecido Favorecido (CPF/CNPJ) (optional)
     * @param cpfPortador Portador (CPF) (optional)
     * @param dataTransacaoFim Data transação fim (DD/MM/AAAA) (optional)
     * @param dataTransacaoInicio Data transação início (DD/MM/AAAA) (optional)
     * @param mesExtratoFim Mês extrato fim (MM/AAAA) (optional)
     * @param mesExtratoInicio Mês extrato início (MM/AAAA) (optional)
     * @param tipoCartao Tipo de cartão (CPGF&#x3D;1 ou CPCC&#x3D;2 ou CPDC&#x3D;3) (optional)
     * @param valorAte Valor até (####,##) (optional)
     * @param valorDe Valor de (####,##) (optional)
     * @return ApiResponse&lt;List&lt;CartoesDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<CartoesDTO>> cartaoUsingGETWithHttpInfo(String chaveApiDados, Integer pagina, String codigoOrgao, String cpfCnpjFavorecido, String cpfPortador, String dataTransacaoFim, String dataTransacaoInicio, String mesExtratoFim, String mesExtratoInicio, Integer tipoCartao, String valorAte, String valorDe) throws ApiException {
        com.squareup.okhttp.Call call = cartaoUsingGETValidateBeforeCall(chaveApiDados, pagina, codigoOrgao, cpfCnpjFavorecido, cpfPortador, dataTransacaoFim, dataTransacaoInicio, mesExtratoFim, mesExtratoInicio, tipoCartao, valorAte, valorDe, null, null);
        Type localVarReturnType = new TypeToken<List<CartoesDTO>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Consulta os registros de Cartões de Pagamento (asynchronously)
     * Filtros mínimos:  Página (padrão &#x3D; 1);  Período de até 12 meses ou um órgão ou um portador ou um favorecido específico;
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param codigoOrgao Órgão/Entidade (Código SIAFI) (optional)
     * @param cpfCnpjFavorecido Favorecido (CPF/CNPJ) (optional)
     * @param cpfPortador Portador (CPF) (optional)
     * @param dataTransacaoFim Data transação fim (DD/MM/AAAA) (optional)
     * @param dataTransacaoInicio Data transação início (DD/MM/AAAA) (optional)
     * @param mesExtratoFim Mês extrato fim (MM/AAAA) (optional)
     * @param mesExtratoInicio Mês extrato início (MM/AAAA) (optional)
     * @param tipoCartao Tipo de cartão (CPGF&#x3D;1 ou CPCC&#x3D;2 ou CPDC&#x3D;3) (optional)
     * @param valorAte Valor até (####,##) (optional)
     * @param valorDe Valor de (####,##) (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call cartaoUsingGETAsync(String chaveApiDados, Integer pagina, String codigoOrgao, String cpfCnpjFavorecido, String cpfPortador, String dataTransacaoFim, String dataTransacaoInicio, String mesExtratoFim, String mesExtratoInicio, Integer tipoCartao, String valorAte, String valorDe, final ApiCallback<List<CartoesDTO>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = cartaoUsingGETValidateBeforeCall(chaveApiDados, pagina, codigoOrgao, cpfCnpjFavorecido, cpfPortador, dataTransacaoFim, dataTransacaoInicio, mesExtratoFim, mesExtratoInicio, tipoCartao, valorAte, valorDe, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<CartoesDTO>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
