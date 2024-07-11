# UserApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**apiV1UserInfluencersUserNameGet**](UserApi.md#apiV1UserInfluencersUserNameGet) | **GET** /api/v1/user/influencers/{userName} | Obtener información de un influenciador por nombre de usuario |


<a id="apiV1UserInfluencersUserNameGet"></a>
# **apiV1UserInfluencersUserNameGet**
> InfluencerResponseDTO apiV1UserInfluencersUserNameGet(userName)

Obtener información de un influenciador por nombre de usuario

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.UserApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    UserApi apiInstance = new UserApi(defaultClient);
    String userName = "userName_example"; // String | Nombre de usuario del influenciador
    try {
      InfluencerResponseDTO result = apiInstance.apiV1UserInfluencersUserNameGet(userName);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling UserApi#apiV1UserInfluencersUserNameGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **userName** | **String**| Nombre de usuario del influenciador | |

### Return type

[**InfluencerResponseDTO**](InfluencerResponseDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Información del influenciador |  -  |
| **404** | Influenciador no encontrado |  -  |

