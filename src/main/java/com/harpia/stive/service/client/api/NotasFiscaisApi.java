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
import com.harpia.stive.domain.model.DetalheNotaFiscalDTO;
import com.harpia.stive.domain.model.NotaFiscalDTO;
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

public class NotasFiscaisApi {
    private ApiClient apiClient;

    public NotasFiscaisApi() {
        this(Configuration.getDefaultApiClient());
    }

    public NotasFiscaisApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for notaFiscalUsingGET
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param chaveUnicaNotaFiscal Chave única da nota fiscal (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call notaFiscalUsingGETCall(String chaveApiDados, String chaveUnicaNotaFiscal, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api-de-dados/notas-fiscais-por-chave";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (chaveUnicaNotaFiscal != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("chaveUnicaNotaFiscal", chaveUnicaNotaFiscal));

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
    private com.squareup.okhttp.Call notaFiscalUsingGETValidateBeforeCall(String chaveApiDados, String chaveUnicaNotaFiscal, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'chaveApiDados' is set
        if (chaveApiDados == null) {
            throw new ApiException("Missing the required parameter 'chaveApiDados' when calling notaFiscalUsingGET(Async)");
        }
        
        // verify the required parameter 'chaveUnicaNotaFiscal' is set
        if (chaveUnicaNotaFiscal == null) {
            throw new ApiException("Missing the required parameter 'chaveUnicaNotaFiscal' when calling notaFiscalUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = notaFiscalUsingGETCall(chaveApiDados, chaveUnicaNotaFiscal, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Consulta uma nota fiscal eletrônica (NFe) do Poder Executivo Federal pela chave única
     * Filtros mínimos: Código do registro
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param chaveUnicaNotaFiscal Chave única da nota fiscal (required)
     * @return DetalheNotaFiscalDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public DetalheNotaFiscalDTO notaFiscalUsingGET(String chaveApiDados, String chaveUnicaNotaFiscal) throws ApiException {
        ApiResponse<DetalheNotaFiscalDTO> resp = notaFiscalUsingGETWithHttpInfo(chaveApiDados, chaveUnicaNotaFiscal);
        return resp.getData();
    }

    /**
     * Consulta uma nota fiscal eletrônica (NFe) do Poder Executivo Federal pela chave única
     * Filtros mínimos: Código do registro
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param chaveUnicaNotaFiscal Chave única da nota fiscal (required)
     * @return ApiResponse&lt;DetalheNotaFiscalDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<DetalheNotaFiscalDTO> notaFiscalUsingGETWithHttpInfo(String chaveApiDados, String chaveUnicaNotaFiscal) throws ApiException {
        com.squareup.okhttp.Call call = notaFiscalUsingGETValidateBeforeCall(chaveApiDados, chaveUnicaNotaFiscal, null, null);
        Type localVarReturnType = new TypeToken<DetalheNotaFiscalDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Consulta uma nota fiscal eletrônica (NFe) do Poder Executivo Federal pela chave única (asynchronously)
     * Filtros mínimos: Código do registro
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param chaveUnicaNotaFiscal Chave única da nota fiscal (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call notaFiscalUsingGETAsync(String chaveApiDados, String chaveUnicaNotaFiscal, final ApiCallback<DetalheNotaFiscalDTO> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = notaFiscalUsingGETValidateBeforeCall(chaveApiDados, chaveUnicaNotaFiscal, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<DetalheNotaFiscalDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for notasFiscaisUsingGET
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param cnpjEmitente CNPJ do emitente (optional)
     * @param codigoOrgao Código do Órgão (SIAFI) (optional)
     * @param nomeProduto Nome do produto (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call notasFiscaisUsingGETCall(String chaveApiDados, Integer pagina, String cnpjEmitente, String codigoOrgao, String nomeProduto, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api-de-dados/notas-fiscais";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (cnpjEmitente != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("cnpjEmitente", cnpjEmitente));
        if (codigoOrgao != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("codigoOrgao", codigoOrgao));
        if (nomeProduto != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("nomeProduto", nomeProduto));
        if (pagina != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("pagina", pagina));

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
    private com.squareup.okhttp.Call notasFiscaisUsingGETValidateBeforeCall(String chaveApiDados, Integer pagina, String cnpjEmitente, String codigoOrgao, String nomeProduto, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'chaveApiDados' is set
        if (chaveApiDados == null) {
            throw new ApiException("Missing the required parameter 'chaveApiDados' when calling notasFiscaisUsingGET(Async)");
        }
        
        // verify the required parameter 'pagina' is set
        if (pagina == null) {
            throw new ApiException("Missing the required parameter 'pagina' when calling notasFiscaisUsingGET(Async)");
        }
        

        com.squareup.okhttp.Call call = notasFiscaisUsingGETCall(chaveApiDados, pagina, cnpjEmitente, codigoOrgao, nomeProduto, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Consulta todas as notas fiscais eletrônicas (NFe´s) do Poder Executivo Federal
     * Filtros mínimos:  Página (padrão &#x3D; 1);  CNPJ Emitente / Órgão / Produto; 
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param cnpjEmitente CNPJ do emitente (optional)
     * @param codigoOrgao Código do Órgão (SIAFI) (optional)
     * @param nomeProduto Nome do produto (optional)
     * @return List&lt;NotaFiscalDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<NotaFiscalDTO> notasFiscaisUsingGET(String chaveApiDados, Integer pagina, String cnpjEmitente, String codigoOrgao, String nomeProduto) throws ApiException {
        ApiResponse<List<NotaFiscalDTO>> resp = notasFiscaisUsingGETWithHttpInfo(chaveApiDados, pagina, cnpjEmitente, codigoOrgao, nomeProduto);
        return resp.getData();
    }

    /**
     * Consulta todas as notas fiscais eletrônicas (NFe´s) do Poder Executivo Federal
     * Filtros mínimos:  Página (padrão &#x3D; 1);  CNPJ Emitente / Órgão / Produto; 
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param cnpjEmitente CNPJ do emitente (optional)
     * @param codigoOrgao Código do Órgão (SIAFI) (optional)
     * @param nomeProduto Nome do produto (optional)
     * @return ApiResponse&lt;List&lt;NotaFiscalDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<NotaFiscalDTO>> notasFiscaisUsingGETWithHttpInfo(String chaveApiDados, Integer pagina, String cnpjEmitente, String codigoOrgao, String nomeProduto) throws ApiException {
        com.squareup.okhttp.Call call = notasFiscaisUsingGETValidateBeforeCall(chaveApiDados, pagina, cnpjEmitente, codigoOrgao, nomeProduto, null, null);
        Type localVarReturnType = new TypeToken<List<NotaFiscalDTO>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Consulta todas as notas fiscais eletrônicas (NFe´s) do Poder Executivo Federal (asynchronously)
     * Filtros mínimos:  Página (padrão &#x3D; 1);  CNPJ Emitente / Órgão / Produto; 
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email (required)
     * @param pagina Página consultada (required)
     * @param cnpjEmitente CNPJ do emitente (optional)
     * @param codigoOrgao Código do Órgão (SIAFI) (optional)
     * @param nomeProduto Nome do produto (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call notasFiscaisUsingGETAsync(String chaveApiDados, Integer pagina, String cnpjEmitente, String codigoOrgao, String nomeProduto, final ApiCallback<List<NotaFiscalDTO>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = notasFiscaisUsingGETValidateBeforeCall(chaveApiDados, pagina, cnpjEmitente, codigoOrgao, nomeProduto, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<NotaFiscalDTO>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
