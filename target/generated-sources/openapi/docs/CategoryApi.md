# CategoryApi

All URIs are relative to *http://localhost*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**categoriesGet**](CategoryApi.md#categoriesGet) | **GET** /categories | Obtener todas las categorías |
| [**categoriesIdDelete**](CategoryApi.md#categoriesIdDelete) | **DELETE** /categories/{id} | Eliminar una categoría por ID |
| [**categoriesIdGet**](CategoryApi.md#categoriesIdGet) | **GET** /categories/{id} | Obtener una categoría por ID |
| [**categoriesIdPut**](CategoryApi.md#categoriesIdPut) | **PUT** /categories/{id} | Actualizar una categoría por ID |
| [**categoriesPost**](CategoryApi.md#categoriesPost) | **POST** /categories | Crear una nueva categoría |


<a id="categoriesGet"></a>
# **categoriesGet**
> List&lt;CategoryRequestDTO&gt; categoriesGet()

Obtener todas las categorías

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CategoryApi apiInstance = new CategoryApi(defaultClient);
    try {
      List<CategoryRequestDTO> result = apiInstance.categoriesGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryApi#categoriesGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;CategoryRequestDTO&gt;**](CategoryRequestDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Lista de categorías |  -  |

<a id="categoriesIdDelete"></a>
# **categoriesIdDelete**
> categoriesIdDelete(id)

Eliminar una categoría por ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CategoryApi apiInstance = new CategoryApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      apiInstance.categoriesIdDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryApi#categoriesIdDelete");
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
| **id** | **String**|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Categoría eliminada |  -  |
| **404** | Categoría no encontrada |  -  |

<a id="categoriesIdGet"></a>
# **categoriesIdGet**
> CategoryRequestDTO categoriesIdGet(id)

Obtener una categoría por ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CategoryApi apiInstance = new CategoryApi(defaultClient);
    String id = "id_example"; // String | 
    try {
      CategoryRequestDTO result = apiInstance.categoriesIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryApi#categoriesIdGet");
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
| **id** | **String**|  | |

### Return type

[**CategoryRequestDTO**](CategoryRequestDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Categoría encontrada |  -  |
| **404** | Categoría no encontrada |  -  |

<a id="categoriesIdPut"></a>
# **categoriesIdPut**
> CategoryRequestDTO categoriesIdPut(id, categoryRequestDTO)

Actualizar una categoría por ID

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CategoryApi apiInstance = new CategoryApi(defaultClient);
    String id = "id_example"; // String | 
    CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO(); // CategoryRequestDTO | 
    try {
      CategoryRequestDTO result = apiInstance.categoriesIdPut(id, categoryRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryApi#categoriesIdPut");
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
| **id** | **String**|  | |
| **categoryRequestDTO** | [**CategoryRequestDTO**](CategoryRequestDTO.md)|  | |

### Return type

[**CategoryRequestDTO**](CategoryRequestDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Categoría actualizada |  -  |
| **404** | Categoría no encontrada |  -  |

<a id="categoriesPost"></a>
# **categoriesPost**
> CategoryRequestDTO categoriesPost(categoryRequestDTO)

Crear una nueva categoría

### Example
```java
// Import classes:
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.Configuration;
import org.openapitools.client.models.*;
import org.openapitools.client.api.CategoryApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    CategoryApi apiInstance = new CategoryApi(defaultClient);
    CategoryRequestDTO categoryRequestDTO = new CategoryRequestDTO(); // CategoryRequestDTO | 
    try {
      CategoryRequestDTO result = apiInstance.categoriesPost(categoryRequestDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling CategoryApi#categoriesPost");
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
| **categoryRequestDTO** | [**CategoryRequestDTO**](CategoryRequestDTO.md)|  | |

### Return type

[**CategoryRequestDTO**](CategoryRequestDTO.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Categoría creada |  -  |

