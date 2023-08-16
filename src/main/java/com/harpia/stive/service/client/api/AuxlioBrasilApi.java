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
import com.harpia.stive.domain.model.AuxilioBrasilPagoDTO;
import com.harpia.stive.domain.model.BeneficioPorMunicipioDTO;
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

public class AuxlioBrasilApi {

    private ApiClient apiClient;

    public AuxlioBrasilApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AuxlioBrasilApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for auxilioBrasilPorMunicipioUsingGET
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call auxilioBrasilPorMunicipioUsingGETCall(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api-de-dados/auxilio-brasil-por-municipio";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (codigoIbge != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("codigoIbge", codigoIbge));
        }
        if (mesAno != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("mesAno", mesAno));
        }
        if (pagina != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("pagina", pagina));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (chaveApiDados != null) {
            localVarHeaderParams.put("chave-api-dados", apiClient.parameterToString(chaveApiDados));
        }

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
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

        String[] localVarAuthNames = new String[]{};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call auxilioBrasilPorMunicipioUsingGETValidateBeforeCall(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'chaveApiDados' is set
        if (chaveApiDados == null) {
            throw new ApiException("Missing the required parameter 'chaveApiDados' when calling auxilioBrasilPorMunicipioUsingGET(Async)");
        }

        // verify the required parameter 'codigoIbge' is set
        if (codigoIbge == null) {
            throw new ApiException("Missing the required parameter 'codigoIbge' when calling auxilioBrasilPorMunicipioUsingGET(Async)");
        }

        // verify the required parameter 'mesAno' is set
        if (mesAno == null) {
            throw new ApiException("Missing the required parameter 'mesAno' when calling auxilioBrasilPorMunicipioUsingGET(Async)");
        }

        // verify the required parameter 'pagina' is set
        if (pagina == null) {
            throw new ApiException("Missing the required parameter 'pagina' when calling auxilioBrasilPorMunicipioUsingGET(Async)");
        }

        com.squareup.okhttp.Call call = auxilioBrasilPorMunicipioUsingGETCall(chaveApiDados, codigoIbge, mesAno, pagina, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Consulta as parcelas do Auxílio Brasil por Município Filtros mínimos:
     * Página (padrão &#x3D; 1); Ano/Mês (YYYYMM); Código IBGE
     * (https://cidades.ibge.gov.br/brasil);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @return List&lt;BeneficioPorMunicipioDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot
     * deserialize the response body
     */
    public List<BeneficioPorMunicipioDTO> auxilioBrasilPorMunicipioUsingGET(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina) throws ApiException {
        ApiResponse<List<BeneficioPorMunicipioDTO>> resp = auxilioBrasilPorMunicipioUsingGETWithHttpInfo(chaveApiDados, codigoIbge, mesAno, pagina);
        return resp.getData();
    }

    /**
     * Consulta as parcelas do Auxílio Brasil por Município Filtros mínimos:
     * Página (padrão &#x3D; 1); Ano/Mês (YYYYMM); Código IBGE
     * (https://cidades.ibge.gov.br/brasil);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @return ApiResponse&lt;List&lt;BeneficioPorMunicipioDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot
     * deserialize the response body
     */
    public ApiResponse<List<BeneficioPorMunicipioDTO>> auxilioBrasilPorMunicipioUsingGETWithHttpInfo(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina) throws ApiException {
        com.squareup.okhttp.Call call = auxilioBrasilPorMunicipioUsingGETValidateBeforeCall(chaveApiDados, codigoIbge, mesAno, pagina, null, null);
        Type localVarReturnType = new TypeToken<List<BeneficioPorMunicipioDTO>>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Consulta as parcelas do Auxílio Brasil por Município (asynchronously)
     * Filtros mínimos: Página (padrão &#x3D; 1); Ano/Mês (YYYYMM); Código IBGE
     * (https://cidades.ibge.gov.br/brasil);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing
     * the request body object
     */
    public com.squareup.okhttp.Call auxilioBrasilPorMunicipioUsingGETAsync(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina, final ApiCallback<List<BeneficioPorMunicipioDTO>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = auxilioBrasilPorMunicipioUsingGETValidateBeforeCall(chaveApiDados, codigoIbge, mesAno, pagina, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<BeneficioPorMunicipioDTO>>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGET
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETCall(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api-de-dados/auxilio-brasil-sacado-beneficiario-por-municipio";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (codigoIbge != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("codigoIbge", codigoIbge));
        }
        if (mesAno != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("mesAno", mesAno));
        }
        if (pagina != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("pagina", pagina));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (chaveApiDados != null) {
            localVarHeaderParams.put("chave-api-dados", apiClient.parameterToString(chaveApiDados));
        }

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
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

        String[] localVarAuthNames = new String[]{};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETValidateBeforeCall(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'chaveApiDados' is set
        if (chaveApiDados == null) {
            throw new ApiException("Missing the required parameter 'chaveApiDados' when calling auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGET(Async)");
        }

        // verify the required parameter 'codigoIbge' is set
        if (codigoIbge == null) {
            throw new ApiException("Missing the required parameter 'codigoIbge' when calling auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGET(Async)");
        }

        // verify the required parameter 'mesAno' is set
        if (mesAno == null) {
            throw new ApiException("Missing the required parameter 'mesAno' when calling auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGET(Async)");
        }

        // verify the required parameter 'pagina' is set
        if (pagina == null) {
            throw new ApiException("Missing the required parameter 'pagina' when calling auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGET(Async)");
        }

        com.squareup.okhttp.Call call = auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETCall(chaveApiDados, codigoIbge, mesAno, pagina, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Consulta as parcelas do Auxílio Brasil Sacado dos Beneficiários por
     * Município e Mes/Ano Filtros mínimos: Página (padrão &#x3D; 1); Ano/Mês
     * (YYYYMM); Código IBGE (https://cidades.ibge.gov.br/brasil);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @return List&lt;AuxilioBrasilPagoDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot
     * deserialize the response body
     */
    public List<AuxilioBrasilPagoDTO> auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGET(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina) throws ApiException {
        ApiResponse<List<AuxilioBrasilPagoDTO>> resp = auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETWithHttpInfo(chaveApiDados, codigoIbge, mesAno, pagina);
        return resp.getData();
    }

    /**
     * Consulta as parcelas do Auxílio Brasil Sacado dos Beneficiários por
     * Município e Mes/Ano Filtros mínimos: Página (padrão &#x3D; 1); Ano/Mês
     * (YYYYMM); Código IBGE (https://cidades.ibge.gov.br/brasil);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @return ApiResponse&lt;List&lt;AuxilioBrasilPagoDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot
     * deserialize the response body
     */
    public ApiResponse<List<AuxilioBrasilPagoDTO>> auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETWithHttpInfo(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina) throws ApiException {
        com.squareup.okhttp.Call call = auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETValidateBeforeCall(chaveApiDados, codigoIbge, mesAno, pagina, null, null);
        Type localVarReturnType = new TypeToken<List<AuxilioBrasilPagoDTO>>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Consulta as parcelas do Auxílio Brasil Sacado dos Beneficiários por
     * Município e Mes/Ano (asynchronously) Filtros mínimos: Página (padrão
     * &#x3D; 1); Ano/Mês (YYYYMM); Código IBGE
     * (https://cidades.ibge.gov.br/brasil);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param codigoIbge Código IBGE (required)
     * @param mesAno Mês e Ano de referência (AAAAMM) (required)
     * @param pagina Página consultada (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing
     * the request body object
     */
    public com.squareup.okhttp.Call auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETAsync(String chaveApiDados, String codigoIbge, Integer mesAno, Integer pagina, final ApiCallback<List<AuxilioBrasilPagoDTO>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = auxilioBrasilSacadoDosBeneficiariosPorMunicipioUsingGETValidateBeforeCall(chaveApiDados, codigoIbge, mesAno, pagina, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<AuxilioBrasilPagoDTO>>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

    /**
     * Build call for auxilioBrasilSacadoPorNisUsingGET
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param nis NIS (sem máscara, somente números) (required)
     * @param pagina Página consultada (required)
     * @param anoMesCompetencia Ano e mês de competência (AAAAMM) (optional)
     * @param anoMesReferencia Ano e mês de referência (AAAAMM) (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call auxilioBrasilSacadoPorNisUsingGETCall(String chaveApiDados, String nis, Integer pagina, Integer anoMesCompetencia, Integer anoMesReferencia, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api-de-dados/auxilio-brasil-sacado-por-nis";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (anoMesCompetencia != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("anoMesCompetencia", anoMesCompetencia));
        }
        if (anoMesReferencia != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("anoMesReferencia", anoMesReferencia));
        }
        if (nis != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("nis", nis));
        }
        if (pagina != null) {
            localVarQueryParams.addAll(apiClient.parameterToPair("pagina", pagina));
        }

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (chaveApiDados != null) {
            localVarHeaderParams.put("chave-api-dados", apiClient.parameterToString(chaveApiDados));
        }

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "*/*"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {};
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if (progressListener != null) {
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

        String[] localVarAuthNames = new String[]{};
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call auxilioBrasilSacadoPorNisUsingGETValidateBeforeCall(String chaveApiDados, String nis, Integer pagina, Integer anoMesCompetencia, Integer anoMesReferencia, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {

        // verify the required parameter 'chaveApiDados' is set
        if (chaveApiDados == null) {
            throw new ApiException("Missing the required parameter 'chaveApiDados' when calling auxilioBrasilSacadoPorNisUsingGET(Async)");
        }

        // verify the required parameter 'nis' is set
        if (nis == null) {
            throw new ApiException("Missing the required parameter 'nis' when calling auxilioBrasilSacadoPorNisUsingGET(Async)");
        }

        // verify the required parameter 'pagina' is set
        if (pagina == null) {
            throw new ApiException("Missing the required parameter 'pagina' when calling auxilioBrasilSacadoPorNisUsingGET(Async)");
        }

        com.squareup.okhttp.Call call = auxilioBrasilSacadoPorNisUsingGETCall(chaveApiDados, nis, pagina, anoMesCompetencia, anoMesReferencia, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Consulta as parcelas disponibilizadas pelo Auxílio Brasil pelo NIS
     * Filtros mínimos: Página (padrão &#x3D; 1); NIS; Ano e mês de competência
     * (AAAAMM) ou Ano e mês de referência (AAAAMM);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param nis NIS (sem máscara, somente números) (required)
     * @param pagina Página consultada (required)
     * @param anoMesCompetencia Ano e mês de competência (AAAAMM) (optional)
     * @param anoMesReferencia Ano e mês de referência (AAAAMM) (optional)
     * @return List&lt;AuxilioBrasilPagoDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot
     * deserialize the response body
     */
    public List<AuxilioBrasilPagoDTO> auxilioBrasilSacadoPorNisUsingGET(String chaveApiDados, String nis, Integer pagina, Integer anoMesCompetencia, Integer anoMesReferencia) throws ApiException {
        ApiResponse<List<AuxilioBrasilPagoDTO>> resp = auxilioBrasilSacadoPorNisUsingGETWithHttpInfo(chaveApiDados, nis, pagina, anoMesCompetencia, anoMesReferencia);
        return resp.getData();
    }

    /**
     * Consulta as parcelas disponibilizadas pelo Auxílio Brasil pelo NIS
     * Filtros mínimos: Página (padrão &#x3D; 1); NIS; Ano e mês de competência
     * (AAAAMM) ou Ano e mês de referência (AAAAMM);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param nis NIS (sem máscara, somente números) (required)
     * @param pagina Página consultada (required)
     * @param anoMesCompetencia Ano e mês de competência (AAAAMM) (optional)
     * @param anoMesReferencia Ano e mês de referência (AAAAMM) (optional)
     * @return ApiResponse&lt;List&lt;AuxilioBrasilPagoDTO&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot
     * deserialize the response body
     */
    public ApiResponse<List<AuxilioBrasilPagoDTO>> auxilioBrasilSacadoPorNisUsingGETWithHttpInfo(String chaveApiDados, String nis, Integer pagina, Integer anoMesCompetencia, Integer anoMesReferencia) throws ApiException {
        com.squareup.okhttp.Call call = auxilioBrasilSacadoPorNisUsingGETValidateBeforeCall(chaveApiDados, nis, pagina, anoMesCompetencia, anoMesReferencia, null, null);
        Type localVarReturnType = new TypeToken<List<AuxilioBrasilPagoDTO>>() {
        }.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Consulta as parcelas disponibilizadas pelo Auxílio Brasil pelo NIS
     * (asynchronously) Filtros mínimos: Página (padrão &#x3D; 1); NIS; Ano e
     * mês de competência (AAAAMM) ou Ano e mês de referência (AAAAMM);
     *
     * @param chaveApiDados Chave para acessar à API. Para obter a chave acesse
     * http://www.portaldatransparencia.gov.br/api-de-dados/cadastrar-email
     * (required)
     * @param nis NIS (sem máscara, somente números) (required)
     * @param pagina Página consultada (required)
     * @param anoMesCompetencia Ano e mês de competência (AAAAMM) (optional)
     * @param anoMesReferencia Ano e mês de referência (AAAAMM) (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing
     * the request body object
     */
    public com.squareup.okhttp.Call auxilioBrasilSacadoPorNisUsingGETAsync(String chaveApiDados, String nis, Integer pagina, Integer anoMesCompetencia, Integer anoMesReferencia, final ApiCallback<List<AuxilioBrasilPagoDTO>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = auxilioBrasilSacadoPorNisUsingGETValidateBeforeCall(chaveApiDados, nis, pagina, anoMesCompetencia, anoMesReferencia, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<AuxilioBrasilPagoDTO>>() {
        }.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }

}
