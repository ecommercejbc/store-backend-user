/*
 * API de Productos y Categorías
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.ApiCallback;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.ApiResponse;
import org.openapitools.client.Configuration;
import org.openapitools.client.Pair;
import org.openapitools.client.ProgressRequestBody;
import org.openapitools.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import javax.validation.constraints.*;

import org.openapitools.client.model.InfluencerResponseDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.GenericType;

public class UserApi {
    private ApiClient localVarApiClient;
    private int localHostIndex;
    private String localCustomBaseUrl;

    public UserApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserApi(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return localVarApiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.localVarApiClient = apiClient;
    }

    public int getHostIndex() {
        return localHostIndex;
    }

    public void setHostIndex(int hostIndex) {
        this.localHostIndex = hostIndex;
    }

    public String getCustomBaseUrl() {
        return localCustomBaseUrl;
    }

    public void setCustomBaseUrl(String customBaseUrl) {
        this.localCustomBaseUrl = customBaseUrl;
    }

    /**
     * Build call for apiV1UserInfluencersUserNameGet
     * @param userName Nombre de usuario del influenciador (required)
     * @param _callback Callback for upload/download progress
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Información del influenciador </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Influenciador no encontrado </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apiV1UserInfluencersUserNameGetCall(String userName, final ApiCallback _callback) throws ApiException {
        String basePath = null;
        // Operation Servers
        String[] localBasePaths = new String[] {  };

        // Determine Base Path to Use
        if (localCustomBaseUrl != null){
            basePath = localCustomBaseUrl;
        } else if ( localBasePaths.length > 0 ) {
            basePath = localBasePaths[localHostIndex];
        } else {
            basePath = null;
        }

        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/api/v1/user/influencers/{userName}"
            .replace("{" + "userName" + "}", localVarApiClient.escapeString(userName.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        Map<String, String> localVarCookieParams = new HashMap<String, String>();
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = localVarApiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) {
            localVarHeaderParams.put("Accept", localVarAccept);
        }

        final String[] localVarContentTypes = {
        };
        final String localVarContentType = localVarApiClient.selectHeaderContentType(localVarContentTypes);
        if (localVarContentType != null) {
            localVarHeaderParams.put("Content-Type", localVarContentType);
        }

        String[] localVarAuthNames = new String[] {  };
        return localVarApiClient.buildCall(basePath, localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAuthNames, _callback);
    }

    @SuppressWarnings("rawtypes")
    private okhttp3.Call apiV1UserInfluencersUserNameGetValidateBeforeCall(String userName, final ApiCallback _callback) throws ApiException {
        // verify the required parameter 'userName' is set
        if (userName == null) {
            throw new ApiException("Missing the required parameter 'userName' when calling apiV1UserInfluencersUserNameGet(Async)");
        }

        return apiV1UserInfluencersUserNameGetCall(userName, _callback);

    }

    /**
     * Obtener información de un influenciador por nombre de usuario
     * 
     * @param userName Nombre de usuario del influenciador (required)
     * @return InfluencerResponseDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Información del influenciador </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Influenciador no encontrado </td><td>  -  </td></tr>
     </table>
     */
    public InfluencerResponseDTO apiV1UserInfluencersUserNameGet(String userName) throws ApiException {
        ApiResponse<InfluencerResponseDTO> localVarResp = apiV1UserInfluencersUserNameGetWithHttpInfo(userName);
        return localVarResp.getData();
    }

    /**
     * Obtener información de un influenciador por nombre de usuario
     * 
     * @param userName Nombre de usuario del influenciador (required)
     * @return ApiResponse&lt;InfluencerResponseDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Información del influenciador </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Influenciador no encontrado </td><td>  -  </td></tr>
     </table>
     */
    public ApiResponse<InfluencerResponseDTO> apiV1UserInfluencersUserNameGetWithHttpInfo( @NotNull String userName) throws ApiException {
        okhttp3.Call localVarCall = apiV1UserInfluencersUserNameGetValidateBeforeCall(userName, null);
        Type localVarReturnType = new TypeToken<InfluencerResponseDTO>(){}.getType();
        return localVarApiClient.execute(localVarCall, localVarReturnType);
    }

    /**
     * Obtener información de un influenciador por nombre de usuario (asynchronously)
     * 
     * @param userName Nombre de usuario del influenciador (required)
     * @param _callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     * @http.response.details
     <table summary="Response Details" border="1">
        <tr><td> Status Code </td><td> Description </td><td> Response Headers </td></tr>
        <tr><td> 200 </td><td> Información del influenciador </td><td>  -  </td></tr>
        <tr><td> 404 </td><td> Influenciador no encontrado </td><td>  -  </td></tr>
     </table>
     */
    public okhttp3.Call apiV1UserInfluencersUserNameGetAsync(String userName, final ApiCallback<InfluencerResponseDTO> _callback) throws ApiException {

        okhttp3.Call localVarCall = apiV1UserInfluencersUserNameGetValidateBeforeCall(userName, _callback);
        Type localVarReturnType = new TypeToken<InfluencerResponseDTO>(){}.getType();
        localVarApiClient.executeAsync(localVarCall, localVarReturnType, _callback);
        return localVarCall;
    }
}
